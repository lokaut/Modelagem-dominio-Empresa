package br.com.contmatic.prova.endereco;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import br.com.contmatic.prova.constantes.ConstantesTestes;
import br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.model.CidadeConstantes;
import br.com.contmatic.prova.model.endereco.Cidade;

public class CidadeTest {

	private Cidade cidadeConstrutor;

	private Cidade cidadeConstrutor2;

	private IllegalStateException illegalState;

	private IllegalArgumentException illegalArgument;

	private Cidade cidadeConstrutor3;

	@BeforeEach
	public void instancia() {
		cidadeConstrutor = new Cidade(CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO, CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO, CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP);
		cidadeConstrutor2 = new Cidade(CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO, CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO, CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP);
		cidadeConstrutor3 = new Cidade(CidadeObjetosConstantes.CODIGO_IBGE_PINDAMONHANGABA, CidadeObjetosConstantes.MUNICIPIO_PINDAMONHANGABA, CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Cidade");
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_codigoIbge() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setCodigoIbge(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "  " })
	void nao_deve_aceitar_campo_vazio_nome_codigoIbge(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCodigoIbge(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = {ConstantesTestes.MAIS_CIQUENTA_NUMEROS, "224" })
	void nao_deve_aceitar_caracteres_diferente_sete_codigoIbge(String codigoErrado) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCodigoIbge(codigoErrado));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas "
				+ CidadeConstantes.TAMANHO_FIXO_CODIGOIBGE + " caracteres" + ", atualmente o campo possui " + codigoErrado.length() + " caractere(s)"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc1221", "35380O6", "35E8006", "3538@06", "35$8006"})
	void nao_deve_aceitar_caracter_diferente_numerico_codigoIbge(String codigoErrado) {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCodigoIbge(codigoErrado));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_municipio() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setMunicipio(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "  " })
	void nao_deve_aceitar_campo_vazio_nome_municipio(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_mais_cem_caracteres_municipio() {
		assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(ConstantesTestes.MAIS_CEM_CARACTERES));
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "ab", "@"})
	void nao_deve_aceitar_menos_tres_caracteres_municipio(String caracterInvalido) {
		assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(caracterInvalido));
	}

	@ParameterizedTest
	@ValueSource(strings = {"cidade2", "São Pau1o"})
	void nao_deve_aceitar_caracter_numerico_municipio(String municioErrado) {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(municioErrado));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_caracter_especial_municipio() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(ConstantesTestes.CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo_unidadeFederativa() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_vazio_unidadeFederativa() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(" "));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_diferente_sete_caracteres_unidadeFederativa() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(ConstantesTestes.TRES_CARACTERES_ALFABETICOS));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas "
				+ CidadeConstantes.TAMANHO_FIXO_UNIDADE_FEDERATIVA + " caracteres" + ", atualmente o campo possui " + ConstantesTestes.TRES_CARACTERES_ALFABETICOS.length() + " caractere(s)"));
	}

	@Test
	void nao_deve_aceitar_caracter_numerico_unidadeFederativa() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa("11"));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_caracter_especial_unidadeFederativa() {
		illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa("@$"));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_nulo_municipio() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setMunicipio(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_codigoIbge() {
		assertEquals(CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO, this.cidadeConstrutor.getCodigoIbge());
	}

	@Test
	void deve_validar_municio() {
		assertEquals(CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO, this.cidadeConstrutor.getMunicipio());
	}

	@Test
	void deve_validar_unidadeFederativa() {
		assertEquals(CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP, this.cidadeConstrutor.getUnidadeFederativa());
	}

	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertThat(cidadeConstrutor3.hashCode(), is(not(this.cidadeConstrutor.hashCode())));
	}

	@Test
	void deve_validar_hashcode_iguais() {
		assertThat(cidadeConstrutor.hashCode(), is(this.cidadeConstrutor2.hashCode()));
	}

	@Test
	void deve_validar_equals() {
		assertEquals(this.cidadeConstrutor, this.cidadeConstrutor2);
		assertEquals(this.cidadeConstrutor,this.cidadeConstrutor);
		assertNotNull(this.cidadeConstrutor);
		assertNotEquals(cidadeConstrutor, new Object());
	}

	@Test
	void deve_validar_toString() {
		assertEquals("Cidade [codigoIbge = " + CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO + ", municipio = " + CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO + ", unidadeFederativa = "
				+ CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP + "]", cidadeConstrutor.toString());
	}
}
