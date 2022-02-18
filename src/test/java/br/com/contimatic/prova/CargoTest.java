package br.com.contimatic.prova;

import static br.com.contimatic.prova.ConstantesTestes.CBO_CARGOS;
import static br.com.contimatic.prova.ConstantesTestes.DESCRICAO_CARGOS;
import static br.com.contimatic.prova.ConstantesTestes.DOIS_CARACTERES;
import static br.com.contimatic.prova.ConstantesTestes.FUNCIONARIOS;
import static br.com.contimatic.prova.ConstantesTestes.FUNCIONARIO_01;
import static br.com.contimatic.prova.ConstantesTestes.FUNCIONARIO_02;
import static br.com.contimatic.prova.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contimatic.prova.ConstantesTestes.NOME_CARGOS;
import static br.com.contimatic.prova.ConstantesTestes.SALARIO_CARGOS;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contimatic.prova.model.Cargo;
import br.com.contimatic.prova.model.Funcionario;

@TestMethodOrder(OrderAnnotation.class)
public class CargoTest {

	private IllegalStateException illegalState;
	
	private IllegalArgumentException illegalArgument;
	
	private Cargo cargoCompleto;
	
	private Cargo cargo;
	
	private List<Funcionario> funcionarioVazio;
	
	@BeforeEach
	public void instancia() {
		funcionarioVazio = new ArrayList<>();
		cargoCompleto = new Cargo(NOME_CARGOS, CBO_CARGOS, SALARIO_CARGOS, DESCRICAO_CARGOS, FUNCIONARIOS);
		cargo = new Cargo(CBO_CARGOS);
	}
	
	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Contato");
	}
	
	@ParameterizedTest
	@ValueSource(strings = { DOIS_CARACTERES, MAIS_CEM_CARACTERES })
	@Order(1)
	void nao_deve_aceitar_fora_limite_caracteres_nome(String nome) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cargo.setNome(nome));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NOME + " a "
						+ TAMANHO_MAXIMO_NOME + " caracteres" + ", atualmente o campo possui " + nome.length()));
	}
	
	@Test
	@Order(2)
	void nao_deve_aceitar_nome_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> cargo.setNome(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	@Order(3)
	void nao_deve_aceitar_campo_vazio_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cargo.setNome(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@Order(4)
	@Test
	void nao_deve_aceitar_campo_nulo_salario() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> cargoCompleto.setSalario(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource( doubles = {800.80, 1209.99, 0.0})
	@Order(5)
	void nao_deve_aceitar_salario_menor_salario_minimo(double valores) {
		BigDecimal salAbaixoSalMinimo = valueOf(valores);
		this.illegalState = assertThrows(IllegalStateException.class,() -> cargoCompleto.setSalario(salAbaixoSalMinimo));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO));
	}
	
	@Test
	@Order(6)
	void deve_validar_salario_minimo() {
		assertEquals(SALARIO_CARGOS, cargoCompleto.getSalario());
	}
	
	@Test
	@Order(7)
	void nao_deve_aceitar_lista_vazia() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> cargoCompleto.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));		
	}
	
	@Test
	@Order(8)
	void nao_deve_aceitar_lista_acima_limite() {
		while (funcionarioVazio.size() <= TAMANHO_MAXIMO_LISTA_FUNCIONARIO) {
			funcionarioVazio.add(FUNCIONARIO_01);
			funcionarioVazio.add(FUNCIONARIO_02);
		}
		this.illegalState = assertThrows(IllegalStateException.class, () -> cargo.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}
	
	@Test
	@Order(9)
	void deve_validar_lista_funcionario() {
		assertEquals(FUNCIONARIO_01, FUNCIONARIOS.get(0));
	}

	@Order(10)
	@Test
	void deve_validar_nome_correto() {
		assertEquals(NOME_CARGOS, cargoCompleto.getNome());
	}
}
