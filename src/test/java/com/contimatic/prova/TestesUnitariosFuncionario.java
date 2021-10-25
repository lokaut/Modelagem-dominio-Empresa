package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.CPF_DIFERENTE_ONZE_NUMEROS;
import static com.contimatic.prova.constantes.Constantes.CPF_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.CPF_VALIDO;
import static com.contimatic.prova.constantes.Constantes.DOIS_CARACTER;
import static com.contimatic.prova.constantes.Constantes.EMAIL_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static com.contimatic.prova.constantes.Constantes.SESSENTA_CARACTER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.model.Funcionario;

class TestesUnitariosFuncionario {

	private Funcionario funcionario;
	private String nome;
	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;

	@BeforeEach
	public void instancia() {
		funcionario = new Funcionario();
		// aplicação dos testes
		nome = "Lokaut";
	}
	
	@AfterAll
	public static void finalização() {
		System.out.println("Fim dos testes funcionario");
	}

	@Test
	void deve_validar_mais_sessenta_caracteres_nome() {
		assertThrows(IllegalStateException.class,() -> funcionario.setNome(SESSENTA_CARACTER));
	}
	
	@Test
	void deve_validar_menos_tres_caracteres_nome() {
		 assertThrows(IllegalStateException.class,() -> funcionario.setNome(DOIS_CARACTER));
	}	

	@Test
	void deve_validar_campo_nome_valido() {
		funcionario.setNome(nome);
		assertEquals(nome, funcionario.getNome());
	}

	@Test
	void deve_validar_campo_nome_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome(null));
        assertTrue(illegalArgument.getMessage().contains(CAMPO_NULO));
	}

	@Test
	void deve_validar_campo_em_branco_nome() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(" "));
		assertTrue(illegalState.getMessage().contains(CAMPO_VAZIO));
	}

	@Test
	void deve_validar_caracter_numerico_nome() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome("123456"));
		assertTrue(illegalState.getMessage().contains(POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}
	
	@Test
	void deve_validar_cpf_invalido() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("40000000000"));
		assertTrue(illegalState.getMessage().contains(CPF_INVALIDO));
	}
	
	@Test
	void deve_validar_cpf_correto() {
		funcionario.setCpf(CPF_VALIDO);
		assertEquals(CPF_VALIDO, funcionario.getCpf());
	}

	@Test
	void deve_validar_cpf_menos_onze_numeros() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("440856"));
		assertTrue(illegalState.getMessage().contains(CPF_DIFERENTE_ONZE_NUMEROS));
	}
	
	@Test
	void deve_validar_cpf_numero_igual() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("00000000000"));
		assertTrue(illegalState.getMessage().contains(CPF_INVALIDO));
	}
	
	@Test
	void deve_validar_email_incorreto() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setEmail("erick22@.com"));
		assertTrue(illegalState.getMessage().contains(EMAIL_INVALIDO));
	}
	
	@Test
	void deve_validar_email_valido() {
		funcionario.setEmail("erick224@gmail.com");
		assertEquals("erick224@gmail.com", funcionario.getEmail());
	}
}