package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.CPF_TEXTO;
import static com.contimatic.prova.constantes.Constantes.DOIS_CARACTER;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_ADMISSAO_FUTURA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static com.contimatic.prova.constantes.Constantes.SESSENTA_DOIS_CARACTERES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.model.Contato;
import com.contimatic.prova.model.Endereco;
import com.contimatic.prova.model.Funcionario;

class TestesUnitariosFuncionario {

	 Funcionario funcionario, funcionarioConstrutor, funcionarioConstrutor2;
	 Contato contato;
	
	 IllegalStateException illegalState;
	 IllegalArgumentException illegalArgument;
	
	 LocalDate dataNasciIdadeMinimaInvalida = LocalDate.of(2010, 12, 05);
	 LocalDate dataNascimentoValido = LocalDate.of(1994, 12, 05);
	 LocalDate dataFutura = LocalDate.of(2023, 11, 04);
	 LocalDate dataAdmissao = LocalDate.of(2021, 11, 04);

	 BigDecimal salario = new BigDecimal(1110.0);
	 BigDecimal salario2 = new BigDecimal(800.2);
	 Endereco endereco;
	
	 String cpfValido = "90795007809"; //76899070081

	@BeforeEach
	public void instancia() {
		endereco = new Endereco("Rua iguape", "381", "Jardim Paulista", "Itapevi", "São Paulo", "06824060");
		contato = new Contato("erick224@gmail.com", "11", "9566680577");
		funcionario = new Funcionario();
		funcionarioConstrutor = new Funcionario("Lókaut", cpfValido, contato, 
				salario, endereco, dataAdmissao, dataNascimentoValido);
		
		funcionarioConstrutor2 = new Funcionario("Lókaut", cpfValido, contato, 
				salario, endereco, dataAdmissao, dataNascimentoValido);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes funcionario");
	}

	@Order(1)
	@Test
	void nao_deve_aceitar_mais_sessenta_caracteres_nome() {
		assertThrows(IllegalStateException.class, () -> funcionario.setNome(SESSENTA_DOIS_CARACTERES));
	}

	@Test
	void nao_deve_aceitar_menos_tres_caracteres_nome() {
		assertThrows(IllegalStateException.class, () -> funcionario.setNome(DOIS_CARACTER));
	}

	@Test
	void nao_deve_aceitar_campo_nome_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_vazio_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_caracter_numerico_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome("123456"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@Test
	void nao_deve_aceitar_cpf_menos_onze_numeros() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("440856"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS));
	}

	@Test
	void nao_deve_aceitar_cpf_somente_numeros_iguais() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("00000000000"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CPF_INVALIDO));
	}

	@Test
	void nao_deve_aceitar_caracter_texto_cpf() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(CPF_TEXTO));
		assertTrue(illegalState.getMessage().contains(MENSAGEM_CPF_INVALIDO));
	}

	@Test
	void nao_deve_aceitar_campo_nulo_cpf() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}



	@Test
	void nao_deve_aceitar_campo_contato_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setContato(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_nulo_salario() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setSalario(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_salario_menor_salario_minimo() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setSalario(salario2));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO));
	}

	@Test
	void nao_deve_aceitar_funcionario_doze_anos() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataNascimento(dataNasciIdadeMinimaInvalida));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IDADE_MINIMA_EMPRESA));
	}
	
	@Test
	void nao_deve_aceitar_data_admissao_acima_dois_meses() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setDataAdmissao(dataFutura));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_ADMISSAO_FUTURA));
	}
	
	@Test
	void nao_deve_aceitar_data_nascimento_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setDataNascimento(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void nao_deve_aceitar_campo_endereco_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setEndereco(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void deve_validar_data_nascimento_correto() {
		assertEquals(dataNascimentoValido, funcionarioConstrutor.getDataNascimento());
	}
	
	@Test
	void deve_validar_data_admissao_correto() {
		assertEquals(dataAdmissao, funcionarioConstrutor.getDataAdmissao());
	}
	
	@Test
	void deve_validar_salario_correto() {
		assertEquals(salario, funcionarioConstrutor.getSalario());
	}
	
	@Test
	void deve_validar_contato_correto() {
		assertEquals(contato, funcionarioConstrutor.getContato());
	}
	
	@Test
	void deve_validar_campo_nome_correto() {
		assertEquals("Lókaut", funcionarioConstrutor.getNome());
	}
	
	@Test
	void deve_validar_cpf_correto() {
		assertEquals(cpfValido, funcionarioConstrutor.getCpf());
	}
	
	@Test
	void deve_validar_Endereco_correto() {
		assertEquals(endereco, funcionarioConstrutor.getEndereco());
	}
	
	@Test
	void nao_deve_validar_hashcode_diferente() {
		assertNotEquals(funcionario.hashCode(), funcionarioConstrutor.hashCode());
	}
	
	@Test
	void deve_validar_hashcode_igual() {
		assertEquals(funcionarioConstrutor.hashCode(), funcionarioConstrutor2.hashCode());
	}
	
	@Test
	void deve_validar_equals_hashcode() {
		assertEquals(true, funcionarioConstrutor.equals(funcionarioConstrutor2));
		assertEquals(true, funcionarioConstrutor.equals(funcionarioConstrutor));
		assertNotEquals(true, funcionarioConstrutor.equals(null));
		assertNotEquals(true, funcionarioConstrutor.equals(new Object()));
	}
	
//	@Test
//	void deve_validar_toString() {
//		assertEquals(,
//					funcionarioConstrutor.toString());
//	}
}
