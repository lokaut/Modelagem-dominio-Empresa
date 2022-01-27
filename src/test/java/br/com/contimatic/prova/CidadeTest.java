package br.com.contimatic.prova;

import static br.com.contimatic.prova.constantes.Constantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.ConstantesTestes.CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.ConstantesTestes.CODIGO_ERRADO_IBGE;
import static br.com.contimatic.prova.constantes.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contimatic.prova.constantes.ConstantesTestes.TRES_CARACTERES_ALFABETICOS;
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

import br.com.contimatic.prova.model.Cidade;

public class CidadeTest {
	Cidade cidade, cidadeConstrutor, cidadeConstrutor2;

	IllegalStateException illegalState;
	IllegalArgumentException illegalArgument;

	private String codigoIbge = CODIGO_IBGE_SAO_PAULO;
	private String codigoIbgePindamonhagaba = "3538006";
	private String municipio = "São Paulo";
	private String unidadeFederativa = "SP";

	@BeforeEach
	public void instancia() {
		cidade = new Cidade(codigoIbgePindamonhagaba);
		cidadeConstrutor = new Cidade(codigoIbge, municipio, unidadeFederativa);
		cidadeConstrutor2 = new Cidade(codigoIbge, municipio, unidadeFederativa);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes na classe Cidade");
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_codigoIbge() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.setCodigoIbge(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_vazio_nome_codigoIbge() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_diferente_sete_caracteres_codigoIbge() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge(CODIGO_ERRADO_IBGE));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas "
				+ 7 + " caracteres" + ", atualmente o campo possui " + CODIGO_ERRADO_IBGE.length() + " caractere(s)"));
	}

	@Test
	void nao_deve_aceitar_caracter_alfabetico_codigoIbge() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge("abc1221"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void nao_deve_aceitar_caracter_especial_codigoIbge() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setCodigoIbge(CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_municipio() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidade.setMunicipio(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_vazio_nome_municipio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_mais_cem_caracteres_municipio() {
		assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio(MAIS_CEM_CARACTERES));
	}

	@Test
	void nao_deve_aceitar_menos_tres_caracteres_municipio() {
		assertThrows(IllegalStateException.class, () -> this.cidade.setMunicipio("ab"));
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
				+ 2 + " caracteres" + ", atualmente o campo possui " + TRES_CARACTERES_ALFABETICOS.length() + " caractere(s)"));
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
		assertEquals(codigoIbge, cidadeConstrutor.getCodigoIbge());
	}

	@Test
	void deve_validar_municio() {
		assertEquals(municipio, cidadeConstrutor.getMunicipio());
	}

	@Test
	void deve_validar_unidadeFederativa() {
		assertEquals(unidadeFederativa, cidadeConstrutor.getUnidadeFederativa());
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
		assertEquals("Cidade [ codigoIbge = " + codigoIbge + " , municipio = " + municipio + ", uf = "
				+ unidadeFederativa + " ]", cidadeConstrutor.toString());
	}
}
