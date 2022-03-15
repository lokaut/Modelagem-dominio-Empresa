package br.com.contimatic.prova;

import static br.com.contimatic.prova.ConstantesTestes.CNPJ_VALIDO;
import static br.com.contimatic.prova.ConstantesTestes.DESCRICAO_SETOR;
import static br.com.contimatic.prova.ConstantesTestes.FUNCIONARIOS;
import static br.com.contimatic.prova.ConstantesTestes.FUNCIONARIO_01;
import static br.com.contimatic.prova.ConstantesTestes.FUNCIONARIO_02;
import static br.com.contimatic.prova.ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS;
import static br.com.contimatic.prova.ConstantesTestes.NOME_SETOR;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_SETOR;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_SETOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import br.com.contimatic.prova.model.Empresa;
import br.com.contimatic.prova.model.Funcionario;
import br.com.contimatic.prova.model.Setor;

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
		setor = new Setor(NOME_SETOR);
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
	@ValueSource(strings = { "Setor errad0", "s3tor setor"})
	void nao_deve_aceitar_caracter_numerico_nome_setor(String setoErrado) {
		illegalState = assertThrows(IllegalStateException.class, () -> this.setor.setNome(setoErrado));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "a", MAIS_SESSENTA_CARACTERES_ALFABETICOS })
	void nao_deve_aceitar_caracter_numerico_especial_nome(String nomeErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.setor.setNome(nomeErrado));
		assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NOME_SETOR
				+ " a " + TAMANHO_MAXIMO_NOME_SETOR + " caracteres" + ", atualmente o campo possui " + nomeErrado.length()));
	}
	
	@Test
	void deve_validar_nome_setor_correto() {
		assertEquals(NOME_SETOR, setorCompleto.getNome());
	}
	
	@Test
	void nao_deve_aceitar_lista_vazia() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> setorCompleto.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));		
	}
	
	@Test
	void nao_deve_aceitar_lista_funcionarios_acima_limite() {
		while (funcionarioVazio.size() <= TAMANHO_MAXIMO_LISTA_FUNCIONARIO) {
			funcionarioVazio.add(FUNCIONARIO_01);
			funcionarioVazio.add(FUNCIONARIO_02);
		}
		
		this.illegalState = assertThrows(IllegalStateException.class, () -> setorCompleto.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}
	
	@Test
	@DisplayName("Validar timeout da lista acima do limite estabelicido")
	void deve_validar_timeout_lista_funcionario() {
		assertTimeout(Duration.ofMillis(40), () -> nao_deve_aceitar_lista_funcionarios_acima_limite());
	}
	
}

