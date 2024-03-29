package br.com.contimatic.prova;

import static br.com.contimatic.prova.ConstantesTestes.CATORZE_NUMEROS_LETRAS;
import static br.com.contimatic.prova.ConstantesTestes.CNPJ_VALIDO;
import static br.com.contimatic.prova.ConstantesTestes.CNPJ_VALIDO_ALEATORIO;
import static br.com.contimatic.prova.ConstantesTestes.CONTATOS;
import static br.com.contimatic.prova.ConstantesTestes.CONTATO_01;
import static br.com.contimatic.prova.ConstantesTestes.CONTATO_02;
import static br.com.contimatic.prova.ConstantesTestes.DOIS_CARACTERES;
import static br.com.contimatic.prova.ConstantesTestes.ENDERECOS;
import static br.com.contimatic.prova.ConstantesTestes.ENDERECO_01;
import static br.com.contimatic.prova.ConstantesTestes.ENDERECO_02;
import static br.com.contimatic.prova.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contimatic.prova.ConstantesTestes.NOME_FANTASIA;
import static br.com.contimatic.prova.ConstantesTestes.RAZAO_SOCIAL;
import static br.com.contimatic.prova.ConstantesTestes.SETORES;
import static br.com.contimatic.prova.ConstantesTestes.SETOR_01;
import static br.com.contimatic.prova.ConstantesTestes.SETOR_02;
import static br.com.contimatic.prova.constantes.Constantes.FUNDACAO_EMPRESA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CNPJ_INVALIDO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_DATA_FUTURA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_CONTATOS;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_ENDERECOS;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_SETORES;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contimatic.prova.model.Contato;
import br.com.contimatic.prova.model.Empresa;
import br.com.contimatic.prova.model.Endereco;
import br.com.contimatic.prova.model.Setor;

public class EmpresaTest {
	
	private List<Setor> setoresVazio;
	
	private List<Contato> contatosVazio;
	
	private List<Endereco> enderecosVazio;
	
	private Empresa empresaCompleta;
	
	private Empresa empresa;
	
	private IllegalStateException illegalState;
	
	private IllegalArgumentException illegalArgument;
	

	@BeforeEach
	public void instanciar() {
		setoresVazio = new ArrayList<>();
		contatosVazio = new ArrayList<>();
		enderecosVazio = new ArrayList<>();
		empresa = new Empresa(CNPJ_VALIDO_ALEATORIO);
		empresaCompleta = new Empresa(CNPJ_VALIDO, RAZAO_SOCIAL, NOME_FANTASIA, FUNDACAO_EMPRESA, SETORES, CONTATOS, ENDERECOS);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Empresa");
	}
	
	@Test
	void nao_deve_aceitar_cnpj_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "  "})
	void nao_deve_aceitar_campo_vazio_nome(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "440856", "9079500780", "907950078", "90795007", "9079500", "90795", "9079", "907", "90",
			"9", "907950078095", "9079500780990795007809" })
	void nao_deve_aceitar_numeros_diferente_catorze_numeros_cnpj(String cnpj) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(cnpj));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "00000000000000", "11111111111111", "22222222222222", "33333333333333", "44444444444444", "55555555555555",
			"66666666666666", "77777777777777", "88888888888888", "99999999999999" })
	void nao_deve_aceitar_cnpj_somente_numeros_iguais(String cnpjInvalido) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(cnpjInvalido));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CNPJ_INVALIDO));
	}
	
	@Test
	void nao_deve_aceitar_caracter_texto_cnpj() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(CATORZE_NUMEROS_LETRAS));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CNPJ_INVALIDO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "56973542000102", "08068013000101", "12344459000108" })
	void nao_deve_aceitar_cnpj_invalido(String cnpjInvalido) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(cnpjInvalido));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CNPJ_INVALIDO));
	}
	
	@Test
	void deve_validar_cnpj_correto() {
		assertEquals(CNPJ_VALIDO_ALEATORIO, empresa.getCnpj());
	}
	
	@Test
	void nao_deve_aceitar_razaoSocial_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "  "})
	void nao_deve_aceitar_campo_vazio_cnpj(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { DOIS_CARACTERES, MAIS_CEM_CARACTERES })
	void nao_deve_aceitar_fora_limite_caracteres_razaoSocial(String nome) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nome));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA + " a "
						+ TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA + " caracteres" + ", atualmente o campo possui " + nome.length()));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "@@123", "Am@anda sous@", "J$ssica Cardoso", "&rick" })
	void nao_deve_aceitar_caracter_numerico_especial_razaoSocial(String nomeErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nomeErrado));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}
	
	@Test
	void deve_validar_razaoSocial_correto() {
		assertEquals(RAZAO_SOCIAL, empresaCompleta.getRazaoSocial());
	}
	
	@Test
	void nao_deve_aceitar_nomeFantasia_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "  "})
	void nao_deve_aceitar_campo_vazio_NomeFantasia(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setNomeFantasia(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { DOIS_CARACTERES, MAIS_CEM_CARACTERES })
	void nao_deve_aceitar_fora_limite_caracteres_NomeFantasia(String nome) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nome));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA + " a "
						+ TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA + " caracteres" + ", atualmente o campo possui " + nome.length()));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "@@123", "Am@anda sous@", "J$ssica Cardoso", "&rick" })
	void nao_deve_aceitar_caracter_numerico_especial_NomeFantasia(String nomeErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nomeErrado));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}
	
	@Test
	void deve_validar_correto_nomeFantasia() {
		assertEquals(NOME_FANTASIA, empresaCompleta.getNomeFantasia());
	}
	
	@Test
	void nao_deve_aceitar_dataFundacao_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setDataFundacao(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@ParameterizedTest
	@ValueSource(longs = {1, 10, 30 })
	void nao_deve_aceitar_data_futura_dataFundacao(long dias) {
		LocalDate dataFutura = now().plusDays(dias);
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setDataFundacao(dataFutura));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DATA_FUTURA));
	}
	
	@Test
	void deve_validar_correto_dataFundacao() {
		assertEquals(FUNDACAO_EMPRESA, empresaCompleta.getDataFundacao());
	}
	
	@Test
	void nao_deve_aceitar_lista_vazia_setores() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> empresa.setSetores(setoresVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));		
	}
	
	@Test
	void nao_deve_aceitar_lista_nula_setores() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setSetores(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void nao_deve_aceitar_lista_acima_limite_setores() {
		while (setoresVazio.size() <= TAMANHO_MAXIMO_LISTA_SETORES) {
			setoresVazio.add(SETOR_01);
			setoresVazio.add(SETOR_02);
		}
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setSetores(setoresVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}
	
	@Test
	void deve_validar_lista_setores() {
		assertAll(
				() -> assertEquals(SETOR_01, SETORES.get(0)),
				() -> assertEquals(SETOR_02, SETORES.get(1)),
				() -> assertEquals(SETORES, empresaCompleta.getSetores())
				);
	}
	
	@Test
	void nao_deve_aceitar_lista_vazia_contatos() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> empresa.setContatos(contatosVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));		
	}
	
	@Test
	void nao_deve_aceitar_lista_acima_limite_contatos() {
		while (contatosVazio.size() <= TAMANHO_MAXIMO_LISTA_CONTATOS) {
			contatosVazio.add(CONTATO_01);
			contatosVazio.add(CONTATO_02);
			
		}
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setContatos(contatosVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}
	
	@Test
	void nao_deve_aceitar_lista_nulo_contatos() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setContatos(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void deve_validar_lista_contatos() {
		assertAll(
				() -> assertEquals(CONTATO_01, CONTATOS.get(0)),
				() -> assertEquals(CONTATO_02, CONTATOS.get(1)),
				() -> assertEquals(CONTATOS, empresaCompleta.getContatos())
				);
	}
	
	@Test
	void nao_deve_aceitar_lista_vazia_enderecos() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> empresa.setEnderecos(enderecosVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));		
	}
	
	@Test
	void nao_deve_aceitar_lista_acima_limite_enderecos() {
		while (enderecosVazio.size() <= TAMANHO_MAXIMO_LISTA_ENDERECOS) {
			enderecosVazio.add(ENDERECO_01);
			enderecosVazio.add(ENDERECO_02);
		}
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setEnderecos(enderecosVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}
	
	@Test
	void nao_deve_aceitar_lista_nulo_enderecos() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setEnderecos(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void deve_validar_lista_enderecos() {
		assertAll(
				() -> assertEquals(ENDERECO_01, ENDERECOS.get(0)),
				() -> assertEquals(ENDERECO_02, ENDERECOS.get(1)),
				() -> assertEquals(ENDERECOS, empresaCompleta.getEnderecos())
				);
	}
	
	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertNotEquals(empresaCompleta.hashCode(), empresa.hashCode());
	}
	
	@Test
	void deve_validar_hashcode_iguais() {
		assertEquals(empresaCompleta.hashCode(), empresaCompleta.hashCode());
	}
	
	@Test
	void deve_validar_equals() {
		assertAll(
				() -> assertEquals(empresaCompleta, empresaCompleta),
				() -> assertNotEquals(empresaCompleta, empresa),
				() -> assertNotNull(empresaCompleta),
				() -> assertNotEquals(true, empresaCompleta.equals(new Object()))
			);
	}

	void deve_validar_toString() {
		assertAll(
				() -> assertEquals("Empresa [cnpj=" + CNPJ_VALIDO + ", razaoSocial=" + RAZAO_SOCIAL + ", nomeFantasia=" + NOME_FANTASIA
						+ ", dataAbertura=" + FUNDACAO_EMPRESA + ", setores=" + SETORES + ", contato=" + CONTATOS + ", endereco="
						+ ENDERECOS + "]", empresaCompleta.toString()),
				() -> assertNotEquals(empresa.toString(), empresaCompleta.toString())
		);
	}
	
}
