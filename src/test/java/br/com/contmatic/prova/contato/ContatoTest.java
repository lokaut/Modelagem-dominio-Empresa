package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_EMAIL;
import static br.com.contmatic.prova.constantes.ConstantesTestes.DDD_SAO_PAULO;
import static br.com.contmatic.prova.constantes.ConstantesTestes.EMAIL;
import static br.com.contmatic.prova.constantes.ConstantesTestes.EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS;
import static br.com.contmatic.prova.constantes.ConstantesTestes.EMAIL_SECUNDARIO;
import static br.com.contmatic.prova.constantes.ConstantesTestes.NUMERO_CELULAR;
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

import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.contato.Telefone;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContatoTest {

	private IllegalStateException illegalState;
	
	private IllegalArgumentException illegalArgument;

	private Contato contato;
	
	private Contato contatoConstrutor;
	
	private Contato contatoConstrutor2;
	
	private Telefone telefone;

	@BeforeEach
	public void instancia() {
		telefone = new Telefone(DDD_SAO_PAULO, NUMERO_CELULAR);
		contato = new Contato(EMAIL_SECUNDARIO);
		contatoConstrutor = new Contato(EMAIL, telefone);
		contatoConstrutor2 = new Contato(EMAIL, telefone);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Contato");
	}

	@Test
	@Order(1)
	void nao_deve_aceitar_email_incorreto() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail("erick22@.com"));
		assertTrue(illegalState.getMessage().contains(MENSAGEM_EMAIL_INVALIDO));
	}

	@Test
	@Order(2)
	void nao_deve_aceitar_email_com_mais_254_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> contato.setEmail(EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_EMAIL + " a "
						+ TAMANHO_MAXIMO_EMAIL + " caracteres, atualmente o campo possui "
						+ EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS.length()));
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
		assertEquals(EMAIL_SECUNDARIO, contato.getEmail());
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
	void deve_validar_hashcode_iguais() {
		assertEquals(contatoConstrutor.hashCode(), contatoConstrutor2.hashCode());
	}

	@Test
	@Order(10)
	void deve_validar_equals() {
		assertEquals(contatoConstrutor, contatoConstrutor2);
		assertEquals(contatoConstrutor, contatoConstrutor);
		assertNotEquals(null, contatoConstrutor);
		assertNotEquals(true, contatoConstrutor.equals(new Object()));
	}
	
	@Test
	@Order(11)
	void deve_validar_toString() {
		assertEquals("Contato [email="+EMAIL+", telefone="+telefone+"]", contatoConstrutor.toString());
	}
}
