package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.EMAIL_SETENTA_DOIS_CARACTRES;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_DDD_INCORRETO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_EMAIL_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_TELEFONE_INCORRETO;
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestesUnitariosContato {

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;

	private Contato contato, contatoConstrutor, contatoConstrutor2;

	private String email = "erick224@gmail.com";
	private String ddd = "11";
	private String telefone = "56668057";
	private String telefoneCelular = "956634577";

	@BeforeEach
	public void instancia() {
		contato = new Contato();
		contatoConstrutor = new Contato(email, ddd, telefone);
		contatoConstrutor2 = new Contato(email, ddd, telefone);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Endereco");
	}

	@Test
	@Order(1)
	void nao_deve_aceitar_email_incorreto() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail("erick22@.com"));
		assertTrue(illegalState.getMessage().contains(MENSAGEM_EMAIL_INVALIDO));
	}

	@Test
	@Order(2)
	void nao_deve_aceitar_email_com_mais_sessenta_caracteres() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail(EMAIL_SETENTA_DOIS_CARACTRES));
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
	void deve_validar_campo_nome_correto() {
		assertEquals(email, contatoConstrutor.getEmail());
	}

	@Test
	@Order(3)
	void nao_deve_aceitar_ddd_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> contato.setDdd(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	@Order(4)
	void nao_deve_aceitar_ddd_vazio() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setDdd(""));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	@Order(5)
	void nao_deve_aceitar_ddd_incorreto() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setDdd("00"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DDD_INCORRETO));
	}

	@Test
	@Order(6)
	void deve_validar_ddd_correto() {
		assertEquals(ddd, contatoConstrutor.getDdd());
	}

	@Test
	@Order(7)
	void nao_deve_aceitar_telefone_menos_oito_numeros() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setTelefone("4140667"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
	}

	@Test
	@Order(8)
	void nao_deve_aceitar_celular_mais_nove_numeros() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setTelefone("9414106689"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
	}

	@Test
	@Order(9)
	void nao_deve_aceitar_telefone_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> contato.setTelefone(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	@Order(10)
	void nao_deve_aceitar_telefone_vazio() {
		illegalState = assertThrows(IllegalStateException.class, () -> contato.setTelefone(""));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	@Order(11)
	void deve_validar_telefone_correto() {
		assertEquals(telefone, contatoConstrutor.getTelefone());
	}

	@Test
	@Order(12)
	void deve_validar_celular_correto() {
		contato.setTelefone(telefoneCelular);
		assertEquals(telefoneCelular, contato.getTelefone());
	}

	@Test
	@Order(13)
	void nao_deve_aceitar_hashcode_diferente() {
		assertNotEquals(contato.hashCode(), contatoConstrutor.hashCode());
	}

	@Test
	@Order(14)
	void deve_validar_hashcode_igual() {
		assertEquals(contatoConstrutor.hashCode(), contatoConstrutor2.hashCode());
	}

	@Test
	@Order(15)
	void deve_validar_equals_hashcode() {
		assertEquals(true, contatoConstrutor.equals(contatoConstrutor2));
		assertEquals(true, contatoConstrutor.equals(contatoConstrutor));
		assertNotEquals(true, contatoConstrutor.equals(null));
		assertNotEquals(true, contatoConstrutor.equals(new Object()));
	}
	
	@Test
	@Order(16)
	void deve_validar_toString() {
		assertEquals("Contato [E-mail = "+ email + ", Telefone = "+ ddd+telefone +"]", contatoConstrutor.toString());
	}
}
