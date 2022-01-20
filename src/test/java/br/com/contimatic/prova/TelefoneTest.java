package br.com.contimatic.prova;

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

	private Telefone telefone, telefoneDddSaoPaulo, celular, celular2, celularDddSaoPaulo;

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;

	private String ddd = "85";
	private String dddSaoPaulo = "11";
	private String numero = "56668057";
	private String numeroCelular = "956634577";

	@BeforeEach
	public void instancia() {
		telefone = new Telefone(ddd, numero);
		telefoneDddSaoPaulo = new Telefone (dddSaoPaulo, numero);
		celular = new Telefone(ddd, numeroCelular);
		celular2 = new Telefone(ddd, numeroCelular);
		celularDddSaoPaulo = new Telefone(dddSaoPaulo, numeroCelular);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Telefone");
	}

	@ParameterizedTest
	@ValueSource(strings = { "09", "0934", "3", "0", "00" })
	void nao_deve_aceitar_ddd_inexistente(String ddd) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdd(ddd));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DDD_INCORRETO));
	}

	@Test
	void nao_deve_aceitar_em_branco_ddd() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdd("  "));
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
	@ValueSource(strings = { "abdtt066f", "abcdefghi", "0000abbb00", "0" })
	void nao_deve_aceitar_telefone_caracteres_alfabeticos(String telefone) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumeroTelefone(telefone));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
	}

	@Test
	void deve_validar_ddd() {
		assertEquals(ddd, this.telefone.getDdd());
	}
	
	@Test
	void deve_validar_telefone() {
		assertEquals(numero, this.telefone.getNumeroTelefone());
	}
	
	@Test
	void deve_validar_equals() {
		assertEquals(true, celular.equals(celular2));
		assertEquals(true, celular.equals(celular));
		assertNotEquals(true, celular.equals(telefone));
		assertNotEquals(true, celular.equals(null));
		assertNotEquals(true, celular.equals(new Object()));
		assertNotEquals(true, telefone.equals(celularDddSaoPaulo));
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
		assertEquals("Telefone [ddd = "+ddd+", numeroTelefone = "+numero+"]", telefone.toString());
		assertEquals("Telefone [ddd = "+ddd+", numeroTelefone = "+numeroCelular+"]", celular.toString());
	}
}
