package br.com.contimatic.prova;

import static br.com.contimatic.prova.constantes.Constantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.ConstantesTestes.CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.ConstantesTestes.EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS;
import static br.com.contimatic.prova.constantes.ConstantesTestes.MAIS_CIQUENTA_NUMEROS;
import static br.com.contimatic.prova.constantes.ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS;
import static br.com.contimatic.prova.constantes.ConstantesTestes.ONZE_NUMEROS;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_FIXO_CEP;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_BAIRRO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_COMPLEMENTO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LOGRADOURO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NUMERO_ENDERECO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_BAIRRO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_COMPLEMENTO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_LOGRADOURO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NUMERO_ENDERECO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contimatic.prova.model.Cidade;
import br.com.contimatic.prova.model.Endereco;

public class EnderecoTest {

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;

	private Endereco enderecoCompleto, enderecoCompleto2, endereco, enderecoHash2, enderecoHash3;
	private Cidade cidade;

	private String codigoIbge = CODIGO_IBGE_SAO_PAULO;
	private String municipio = "Pindamonhagaba";
	private String unidadeFederativa = "SP";

	private String logradouro = "Rua Basto";
	private String numero = "101";
	private String segundoNumero = "103";
	private String segundoCep = "18321050";
	private String bairro = "Vila Olimpía";
	private String cep = "16822050";
	private String complemento = "predio A, apartamento 23";

	@BeforeEach
	public void instancia() {
		cidade = new Cidade(codigoIbge, municipio, unidadeFederativa);
		endereco = new Endereco(segundoCep, segundoNumero);
		enderecoHash2 = new Endereco(segundoCep, numero);
		enderecoHash3 = new Endereco(cep, segundoNumero);
		enderecoCompleto = new Endereco(logradouro, numero, bairro, cep, cidade);
		enderecoCompleto2 = new Endereco(logradouro, numero, bairro, complemento, cep, cidade);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Endereco");
	}

	@Test
	void nao_deve_aceitar_logradouro_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setLogradouro(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_logradouro_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setLogradouro("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_logradouro_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> this.endereco.setLogradouro(MAIS_SESSENTA_CARACTERES_ALFABETICOS));
		assertTrue(this.illegalState.getMessage().contains(
				"Quantidade de carácter inválido, o campo deve estar entre "+TAMANHO_MINIMO_LOGRADOURO+" a "+TAMANHO_MAXIMO_LOGRADOURO+" caracteres, atualmente o campo possui "
						+ MAIS_SESSENTA_CARACTERES_ALFABETICOS.length()));
	}

	@Test
	void nao_deve_aceitar_logradouro_caracter_especial() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> this.endereco.setLogradouro(CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}

	@Test
	void deve_validar_logradouro_correto() {
		this.endereco.setLogradouro("Rua A");
		assertEquals(logradouro, this.enderecoCompleto.getLogradouro());
		assertThat(this.endereco.getLogradouro(), equalToIgnoringCase("rua a"));
	}

	@Test
	void nao_deve_aceitar_bairro_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setBairro(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_bairro_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_bairro_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> this.endereco.setBairro(MAIS_SESSENTA_CARACTERES_ALFABETICOS));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_BAIRRO + " a "
						+ TAMANHO_MAXIMO_BAIRRO + " caracteres, atualmente o campo possui "
						+ MAIS_SESSENTA_CARACTERES_ALFABETICOS.length()));
	}

	@Test
	void nao_deve_aceitar_bairro_caracter_especial() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro(CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}

	@Test
	void deve_validar_bairro_correto() {
		this.endereco.setBairro("Vila das belezas");
		assertThat(endereco.getBairro(), is(equalToIgnoringCase("vila das belezas")));
	}

	@Test
	void nao_deve_aceitar_numero_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setNumero(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_numero_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setNumero("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_numero_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setNumero(MAIS_CIQUENTA_NUMEROS));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NUMERO_ENDERECO
						+ " a " + TAMANHO_MAXIMO_NUMERO_ENDERECO + " caracteres, atualmente o campo possui "
						+ MAIS_CIQUENTA_NUMEROS.length()));
	}

	@Test
	void nao_deve_aceitar_caracter_alfabetico_em_numero_endereco() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setNumero("onze"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void deve_validar_numero_correto() {
		this.endereco.setNumero(ONZE_NUMEROS);
		assertNotEquals(segundoNumero, endereco.getNumero());
		assertEquals(ONZE_NUMEROS, endereco.getNumero());
	}

	@Test
	void nao_deve_aceitar_cidade_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setCidade(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_cidade_correta() {
		assertEquals(cidade, this.enderecoCompleto.getCidade());
	}

	@Test
	void nao_deve_aceitar_cep_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setCep(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_cep_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setCep("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "00", "123", "1234567", "0455105", "045510504551050455105", "0000000" })
	void nao_deve_aceitar_cep_fora_limite_caracteres(String cep) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setCep(cep));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácteres inválido! O campo deve possuir apenas " + TAMANHO_FIXO_CEP
						+ " caracteres, atualmente o campo possui " + cep.length() + " caractere(s)"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abcdefgh", "abc2345h", "@b4def@@", "04551@59", "abc#´%g3" })
	void nao_deve_aceitar_caracter_alfabetico_cep(String cep) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setCep(cep));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void deve_aceitar_cep_correto() {
		assertEquals(endereco.getCep(), this.segundoCep);
		assertEquals(enderecoCompleto.getCep(), this.cep);
	}
	
	@Test
	void deve_aceitar_complemento_nulo() {
		assertNull(endereco.getComplemento());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"   ", "", "       "})
	void deve_aceitar_complemento_vazio(String complemento) {
		this.endereco.setComplemento(complemento);
		assertTrue(endereco.getComplemento().isBlank());
	}
	
	@Test
	void nao_deve_aceitar_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setComplemento(EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_COMPLEMENTO
						+ " a " + TAMANHO_MAXIMO_COMPLEMENTO + " caracteres, atualmente o campo possui "
						+ EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS.length()));
	}
	
	@Test
	void deve_validar_hashcode_endereco() {
		assertEquals(enderecoCompleto.hashCode(), enderecoCompleto2.hashCode());
		assertNotEquals(enderecoHash2.hashCode(), enderecoHash3.hashCode());
		assertNotEquals(enderecoHash3, endereco.hashCode());
		assertNotEquals(enderecoHash2.hashCode(), enderecoCompleto.hashCode());
	}

	@Test
	void deve_validar_equals() {
		assertEquals(enderecoCompleto,enderecoCompleto2);
		assertEquals(enderecoCompleto,enderecoCompleto);
		assertNotEquals(null, enderecoCompleto);
		assertNotEquals(true, enderecoCompleto.equals(new Object()));
		assertNotEquals(enderecoHash2, enderecoHash3);
		assertNotEquals(enderecoHash2, endereco);
	}

	@Test
	void deve_validar_toString() {
		assertEquals("Endereco [logradouro = " + logradouro + ", numero = " + numero +", complemento = "+ complemento +", bairro = " + bairro + ", cidade = " + cidade + ", cep = " + cep + "]", enderecoCompleto2.toString());
		assertNotEquals("Endereco [logradouro = " + logradouro + ", numero = " + numero +", complemento = "+ complemento +", bairro = " + bairro + ", cidade = " + cidade + ", cep = " + cep + "]", enderecoCompleto.toString());
	}
}
