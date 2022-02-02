package br.com.contimatic.prova;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contimatic.prova.model.Cargo;
import br.com.contimatic.prova.model.Funcionario;

public class CargoTest {

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;
	
	private Cargo cargo;
	
	private String nome; 
	private String cbo;
	private String descricao;
	private BigDecimal salario, salarioAbaixoMinimo;
	private List<Funcionario> funcionarios;
	
	@BeforeEach
	public void instancia() {
		nome = "Gerente de projetos de tecnologia da informação";
		cbo = "142520";
		descricao = "Cargo de gerente";
		salarioAbaixoMinimo = valueOf(800.60);
		salario = valueOf(14000.60);
		cargo = new Cargo(nome, cbo, salario, descricao);

	}
	
	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Contato");
	}
	
	@Test
	void nao_deve_aceitar_campo_nulo_salario() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> cargo.setSalario(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_salario_menor_salario_minimo() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> cargo.setSalario(salarioAbaixoMinimo));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO));
	}
	
	@Test
	void deve_validar_salario_minimo() {
		assertEquals(salario, cargo.getSalario());
	}
	
}
