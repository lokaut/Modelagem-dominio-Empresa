package br.com.contmatic.prova;

import static br.com.contmatic.prova.ConstantesTestes.CARACTER_ESPECIAL;
import static br.com.contmatic.prova.ConstantesTestes.CODIGO_ERRADO_IBGE;
import static br.com.contmatic.prova.ConstantesTestes.CODIGO_IBGE_PINDAMONHANGABA;
import static br.com.contmatic.prova.ConstantesTestes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contmatic.prova.ConstantesTestes.MAIS_CIQUENTA_NUMEROS;
import static br.com.contmatic.prova.ConstantesTestes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.ConstantesTestes.TRES_CARACTERES_ALFABETICOS;
import static br.com.contmatic.prova.ConstantesTestes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_FIXO_CODIGOIBGE;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_FIXO_UNIDADE_FEDERATIVA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.model.Cidade;

public class CidadeTest {
	
	Cidade cidade;
	
	Cidade cidadeConstrutor;
	
	Cidade cidadeConstrutor2;

	IllegalStateException illegalState;
	
	IllegalArgumentException illegalArgument;

	@BeforeEach
	public void instancia() {
		cidade = new Cidade(CODIGO_IBGE_PINDAMONHANGABA);
		cidadeConstrutor = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP);
		cidadeConstrutor2 = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Cidade");
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_codigoIbge() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.setCodigoIbge(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "  " })
	void nao_deve_aceitar_campo_vazio_nome_codigoIbge(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = { MAIS_CIQUENTA_NUMEROS, "224" })
	void nao_deve_aceitar_caracteres_diferente_sete_codigoIbge(String codigoErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge(codigoErrado));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas "
				+ TAMANHO_FIXO_CODIGOIBGE + " caracteres" + ", atualmente o campo possui " + codigoErrado.length() + " caractere(s)"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc1221", "35380O6", "35E8006", "3538@06", "35$8006"})
	void nao_deve_aceitar_caracter_diferente_numerico_codigoIbge(String codigoErrado) {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge(codigoErrado));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_municipio() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.setMunicipio(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "  " })
	void nao_deve_aceitar_campo_vazio_nome_municipio(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_mais_cem_caracteres_municipio() {
		assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio(MAIS_CEM_CARACTERES));
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "ab", "@"})
	void nao_deve_aceitar_menos_tres_caracteres_municipio(String caracterInvalido) {
		assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio(caracterInvalido));
	}

	@Test
	void nao_deve_aceitar_caracter_numerico_municipio() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio("abc1221"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_caracter_especial_municipio() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio(CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_unidadeFederativa() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.setUnidadeFederativa(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_vazio_unidadeFederativa() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setUnidadeFederativa(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_diferente_sete_caracteres_unidadeFederativa() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setUnidadeFederativa(TRES_CARACTERES_ALFABETICOS));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas "
				+ TAMANHO_FIXO_UNIDADE_FEDERATIVA + " caracteres" + ", atualmente o campo possui " + TRES_CARACTERES_ALFABETICOS.length() + " caractere(s)"));
	}

	@Test
	void nao_deve_aceitar_caracter_numerico_unidadeFederativa() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setUnidadeFederativa("11"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_caracter_especial_unidadeFederativa() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setUnidadeFederativa("@$"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_retornar_nulo_unidadeFederativa() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.getUnidadeFederativa());
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_retornar_nulo_municipio() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.getMunicipio());
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_codigoIbge() {
		assertEquals(CODIGO_IBGE_SAO_PAULO, cidadeConstrutor.getCodigoIbge());
	}

	@Test
	void deve_validar_municio() {
		assertEquals(MUNICIPIO_SAO_PAULO, cidadeConstrutor.getMunicipio());
	}

	@Test
	void deve_validar_unidadeFederativa() {
		assertEquals(UNIDADE_FEDERATIVA_SP, cidadeConstrutor.getUnidadeFederativa());
	}

	@Test
	void nao_deve_validar_hashcode_diferente() {
		assertThat(cidadeConstrutor.hashCode(), is(not(this.cidade.hashCode())));
	}

	@Test
	void deve_validar_equals_hashcode() {
		assertEquals(cidadeConstrutor, cidadeConstrutor2);
		assertEquals(cidadeConstrutor, cidadeConstrutor);
		assertNotEquals(null, cidadeConstrutor);
		assertNotEquals(true, cidadeConstrutor.equals(new Object()));
	}

	@Test
	void deve_validar_toString() {
		assertEquals("Cidade [ codigoIbge = " + CODIGO_IBGE_SAO_PAULO + " , municipio = " + MUNICIPIO_SAO_PAULO + ", uf = "
				+ UNIDADE_FEDERATIVA_SP + " ]", cidadeConstrutor.toString());
	}
}
