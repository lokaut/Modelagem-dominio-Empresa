package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.CPF_TEXTO;
import static com.contimatic.prova.constantes.Constantes.CPF_VALIDO;
import static com.contimatic.prova.constantes.Constantes.DOIS_CARACTER;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_EMAIL_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static com.contimatic.prova.constantes.Constantes.SESSENTA_DOIS_CARACTERES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.model.Funcionario;

class TestesUnitariosFuncionario {

	private Funcionario funcionario;
	private String nome;

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;
	
	LocalDate dataNasciIdadeMinima;

	private BigDecimal salario1 = new BigDecimal(1110.0);
	private BigDecimal salario2 = new BigDecimal(800.2);

	@BeforeEach
	public void instancia() {

		funcionario = new Funcionario();
		nome = "Lókaut";
		dataNasciIdadeMinima = LocalDate.of(2010, 12, 05);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes funcionario");
	}

	@Test
	void deve_validar_mais_sessenta_caracteres_nome() {
		assertThrows(IllegalStateException.class, () -> funcionario.setNome(SESSENTA_DOIS_CARACTERES));
	}

	@Test
	void deve_validar_menos_tres_caracteres_nome() {
		assertThrows(IllegalStateException.class, () -> funcionario.setNome(DOIS_CARACTER));
	}

	@Test
	void deve_validar_campo_nome_valido() {
		funcionario.setNome(nome);
		assertEquals(nome, funcionario.getNome());
	}

	@Test
	void deve_validar_campo_nome_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_campo_em_branco_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void deve_validar_caracter_numerico_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome("123456"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void deve_validar_cpf_correto() {
		funcionario.setCpf(CPF_VALIDO);
		assertEquals(CPF_VALIDO, funcionario.getCpf());
	}

	@Test
	void deve_validar_cpf_menos_onze_numeros() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("440856"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS));
	}

	@Test
	void deve_validar_cpf_numero_igual() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("00000000000"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CPF_INVALIDO));
	}

	@Test
	void deve_validar_caracter_texto_cpf() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(CPF_TEXTO));
		assertTrue(illegalState.getMessage().contains(MENSAGEM_CPF_INVALIDO));
	}

	@Test
	void deve_validar_campo_nulo_cpf() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_email_incorreto() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setEmail("erick22@.com"));
		assertTrue(illegalState.getMessage().contains(MENSAGEM_EMAIL_INVALIDO));
	}

	@Test
	void deve_validar_email_valido() {
		funcionario.setEmail("erick224@gmail.com");
		assertEquals("erick224@gmail.com", funcionario.getEmail());
	}

	@Test
	void deve_validar_campo_nulo_email() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_campo_nulo_salario() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setSalario(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_salario_menor_salario_minimo() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setSalario(salario2));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO));
	}

	@Test
	void deve_validar_salario_valido() {
		funcionario.setSalario(salario1);
		assertEquals(salario1, funcionario.getSalario());
	}
	
	@Test
	void deve_validar_idade_minima() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataNascimento(dataNasciIdadeMinima));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IDADE_MINIMA_EMPRESA));
	}
	
	@Test
	void deve_validar_data_nascimento_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setDataNascimento(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void deve_validar_campo_endereco_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setEndereco(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	
}

