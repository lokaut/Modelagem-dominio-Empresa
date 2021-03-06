package br.com.contimatic.prova;

import static br.com.contimatic.prova.ConstantesTestes.DDD_CEARA;
import static br.com.contimatic.prova.ConstantesTestes.DDD_SAO_PAULO;
import static br.com.contimatic.prova.ConstantesTestes.NUMERO_TELEFONE;
import static br.com.contimatic.prova.ConstantesTestes.NUMERO_CELULAR;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_DDD_INCORRETO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_TELEFONE_INCORRETO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contimatic.prova.constantes.Constantes;
import br.com.contimatic.prova.model.Telefone;

public class TelefoneTest {

	private Telefone telefone;
	
	private Telefone telefoneDddSaoPaulo;
	
	private Telefone celular;
	
	private Telefone celular2;
	
	private Telefone celularDddSaoPaulo;
	
	private IllegalStateException illegalState;
	
	private IllegalArgumentException illegalArgument;

	@BeforeEach
	public void instancia() {
		telefone = new Telefone(DDD_CEARA, NUMERO_TELEFONE);
		telefoneDddSaoPaulo = new Telefone (DDD_SAO_PAULO, NUMERO_TELEFONE);
		celular = new Telefone(DDD_CEARA, NUMERO_CELULAR);
		celular2 = new Telefone(DDD_CEARA, NUMERO_CELULAR);
		celularDddSaoPaulo = new Telefone(DDD_SAO_PAULO, NUMERO_CELULAR);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Telefone");
	}

	@ParameterizedTest
	@ValueSource(strings = { "09", "0934", "3", "0", "00" })
	void nao_deve_aceitar_ddd_inexistente(String dddInexistente) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdd(dddInexistente));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DDD_INCORRETO));
	}

	@ParameterizedTest
	@ValueSource(strings = { " ", "", "      " })
	void nao_deve_aceitar_em_branco_ddd(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdd(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(Constantes.MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_ddd_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.telefone.setDdd(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "09", "9544334", "000000", "0", "000000000", })
	void nao_deve_aceitar_telefone_inexistente(String telefone) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumeroTelefone(telefone));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { " ", "", "      " })
	void nao_deve_aceitar_em_branco_numero_telefone(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumeroTelefone(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(Constantes.MENSAGEM_CAMPO_VAZIO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "abdtt066f", "abcdefghi", "0000abbb00", "0" })
	void nao_deve_aceitar_telefone_caracteres_alfabeticos(String telefone) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumeroTelefone(telefone));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
	}
	
	@Test
	void deve_validar_ddd() {
		assertEquals(DDD_CEARA, this.telefone.getDdd());
	}
	
	@Test
	void deve_validar_telefone() {
		assertEquals(NUMERO_TELEFONE, this.telefone.getNumeroTelefone());
	}
	
	@Test
	void deve_validar_equals() {
		assertEquals(celular, celular2);
		assertEquals(celular, celular);
		assertNotEquals(celular,telefone);
		assertNotEquals(null, celular);
		assertNotEquals(true, celular.equals(new Object()));
		assertNotEquals(telefone, celularDddSaoPaulo);
	}
	
	@Test
	void deve_validar_hashcode() {
		assertEquals(celular.hashCode(), celular2.hashCode());
		assertNotEquals (telefoneDddSaoPaulo.hashCode(), telefone.hashCode());
		assertNotEquals(celular.hashCode(), telefone.hashCode());
		assertNotEquals(telefoneDddSaoPaulo.hashCode(), celularDddSaoPaulo.hashCode());
	}
	
	@Test
	void deve_validar_toString() {
		assertEquals("Telefone [ddd = "+DDD_CEARA+", numeroTelefone = "+NUMERO_TELEFONE+"]", telefone.toString());
		assertEquals("Telefone [ddd = "+DDD_CEARA+", numeroTelefone = "+NUMERO_CELULAR+"]", celular.toString());
	}
	
}
