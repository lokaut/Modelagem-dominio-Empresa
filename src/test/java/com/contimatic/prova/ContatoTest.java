package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_EMAIL_INVALIDO;
import static com.contimatic.prova.constantes.ConstantesTestes.EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.contimatic.prova.model.Contato;
import com.contimatic.prova.model.Telefone;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContatoTest {

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;

	private Contato contato, contatoConstrutor, contatoConstrutor2;
	private Telefone telefone;

	private String email = "erick123@gmail.com";
	private String emailSecundario = "erickemail2@gmail.com";
	private String telefoneCelular = "956634577";
	private String ddd = "11";
	

	@BeforeEach
	public void instancia() {
		telefone = new Telefone(ddd, telefoneCelular);
		contato = new Contato(emailSecundario);
		contatoConstrutor = new Contato(email, telefone);
		contatoConstrutor2 = new Contato(email, telefone);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Contato");
	}

	@Test
	@Order(1)
	void nao_deve_aceitar_email_incorreto() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail("erick22@.com"));
		assertTrue(illegalState.getMessage().contains(MENSAGEM_EMAIL_INVALIDO));
	}

	@Test
	@Order(2)
	void nao_deve_aceitar_email_com_mais_254_caracteres() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail(EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS));
	}

	@Test
	@Order(3)
	void nao_deve_aceitar_email_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> contato.setEmail(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	@Order(4)
	void nao_deve_aceitar_email_em_branco() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@Test
	@Order(5)
	void deve_aceitar_email_correto() {
		assertEquals(emailSecundario, contato.getEmail());
	}

	@Test
	@Order(6)
	void deve_validar_telefone_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> contato.setTelefone(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	@Order(7)
	void deve_validar_telefone_correto() {
		assertEquals(telefone, contatoConstrutor.getTelefone());
	}

	@Test
	@Order(8)
	void nao_deve_aceitar_hashcode_diferente() {
		assertNotEquals(contato.hashCode(), contatoConstrutor.hashCode());
	}

	@Test
	@Order(9)
	void deve_validar_hashcode_igual() {
		assertEquals(contatoConstrutor.hashCode(), contatoConstrutor2.hashCode());
	}

	@Test
	@Order(10)
	void deve_validar_equals() {
		assertEquals(true, contatoConstrutor.equals(contatoConstrutor2));
		assertEquals(true, contatoConstrutor.equals(contatoConstrutor));
		assertNotEquals(true, contatoConstrutor.equals(null));
		assertNotEquals(true, contatoConstrutor.equals(new Object()));
	}
	
	@Test
	@Order(11)
	void deve_validar_toString() {
		assertEquals("Contato [email="+email+", telefone="+telefone+"]", contatoConstrutor.toString());
	}
}
