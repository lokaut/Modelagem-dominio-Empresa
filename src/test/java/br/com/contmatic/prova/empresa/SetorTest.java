package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_DESCRICAO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_SETOR;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_DESCRICAO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_SETOR;
import static br.com.contmatic.prova.constantes.ConstantesTestes.CNPJ_VALIDO;
import static br.com.contmatic.prova.constantes.ConstantesTestes.DESCRICAO_SETOR;
import static br.com.contmatic.prova.constantes.ConstantesTestes.EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS;
import static br.com.contmatic.prova.constantes.ConstantesTestes.FUNCIONARIOS;
import static br.com.contmatic.prova.constantes.ConstantesTestes.FUNCIONARIO_01;
import static br.com.contmatic.prova.constantes.ConstantesTestes.FUNCIONARIO_02;
import static br.com.contmatic.prova.constantes.ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS;
import static br.com.contmatic.prova.constantes.ConstantesTestes.NOME_SETOR;
import static br.com.contmatic.prova.constantes.ConstantesTestes.NOME_SETOR_RH;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.model.empresa.Empresa;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;

public class SetorTest {

	private IllegalStateException illegalState;

	private IllegalArgumentException illegalArgument;

	private Setor setor;

	private Setor setorCompleto;

	private Empresa cnpjEmpresa;

	private List<Funcionario> funcionarioVazio;

	@BeforeEach
	public void instancia() {
		funcionarioVazio = new ArrayList<>();
		cnpjEmpresa = new Empresa(CNPJ_VALIDO);
		setor = new Setor(NOME_SETOR_RH);
		setorCompleto = new Setor(NOME_SETOR, FUNCIONARIOS, DESCRICAO_SETOR, cnpjEmpresa);

	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Setor");
	}

	@Test
	void nao_deve_aceitar_nome_nulo_setor() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> setor.setNome(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { " ", "", "      " })
	void nao_deve_aceitar_campo_vazio_nome(String stringVazio) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> setor.setNome(stringVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Setor errad0", "s3tor setor" })
	void nao_deve_aceitar_caracter_numerico_nome_setor(String setoErrado) {
		illegalState = assertThrows(IllegalStateException.class, () -> this.setor.setNome(setoErrado));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "a", MAIS_SESSENTA_CARACTERES_ALFABETICOS })
	void nao_deve_aceitar_caracter_numerico_especial_nome(String nomeErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.setor.setNome(nomeErrado));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NOME_SETOR
						+ " a " + TAMANHO_MAXIMO_NOME_SETOR + " caracteres" + ", atualmente o campo possui "
						+ nomeErrado.length()));
	}

	@Test
	void deve_validar_nome_setor_correto() {
		assertEquals(NOME_SETOR, setorCompleto.getNome());
	}

	@Test
	void nao_deve_aceitar_lista_vazia() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> setorCompleto.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_lista_funcionarios_acima_limite() {
		while (funcionarioVazio.size() <= TAMANHO_MAXIMO_LISTA_FUNCIONARIO) {
			funcionarioVazio.add(FUNCIONARIO_01);
			funcionarioVazio.add(FUNCIONARIO_02);
		}

		this.illegalState = assertThrows(IllegalStateException.class,
				() -> setorCompleto.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}

	@Test
	@DisplayName("Validar timeout da lista acima do limite estabelicido")
	void deve_validar_timeout_lista_funcionario() {
		assertTimeout(Duration.ofMillis(40), () -> nao_deve_aceitar_lista_funcionarios_acima_limite());
	}

	@Test
	void deve_validar_funcionario_correto() {
		assertEquals(FUNCIONARIOS, setorCompleto.getFuncionario());
	}

	@Test
	void nao_deve_aceitar_descricao_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> setor.setDescricao(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { " ", "", "   " })
	void nao_deve_aceitar_campo_descricao_vazio(String variavelVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> setor.setDescricao(variavelVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "a", EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS })
	void nao_deve_aceitar_caracter_numerico_especial_descricao(String nomeErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.setor.setDescricao(nomeErrado));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_DESCRICAO
						+ " a " + TAMANHO_MAXIMO_DESCRICAO + " caracteres" + ", atualmente o campo possui "
						+ nomeErrado.length()));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "Descrição errad@", "D$scrição erradissimo" })
	void nao_deve_aceitar_caracter_numerico_descricao_setor(String descricaoErrado) {
		illegalState = assertThrows(IllegalStateException.class, () -> this.setor.setDescricao(descricaoErrado));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}
	
	@Test
	void deve_validar_descricao_setor_correto() {
		assertEquals(DESCRICAO_SETOR, setorCompleto.getDescricao());
	}
	
	@Test
	void nao_deve_aceitar_empresa_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> setor.setEmpresa(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void deve_validar_empresa_correta() {
		assertEquals(cnpjEmpresa, setorCompleto.getEmpresa());
	}
	
	@Test
	void nao_deve_validar_hashcode_diferente() {
		assertNotEquals(setor.hashCode(), setorCompleto.hashCode());
	}
	
	@Test
	void deve_validar_hashcode_igual() {
		assertEquals(setor.hashCode(), setor.hashCode());
	}
	
	@Test
	void deve_validar_equals_hashcode() {
		assertAll(
				() -> assertEquals(setorCompleto, setorCompleto), 
				() -> assertNotEquals(null, setorCompleto),
				() -> assertNotEquals(setor, setorCompleto),
				() -> assertNotEquals(true, setorCompleto.equals(new Object()))
				);
	}
	
	@Test
	void deve_validar_toString() {
		assertEquals(  "Setor [nome = " + NOME_SETOR + ", funcionarios = " + FUNCIONARIOS + ", descricao = " + DESCRICAO_SETOR + ", empresa = "
				+ cnpjEmpresa + "]", setorCompleto.toString());
	}
}
