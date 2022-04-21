package br.com.contmatic.prova.empresa;


import br.com.contmatic.prova.constantes.ConstantesTestes;
import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.model.CargoConstantes;
import br.com.contmatic.prova.constantes.model.FuncionarioConstantes;
import br.com.contmatic.prova.constantes.objetos.CargosObjetosConstantes;
import br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes;
import br.com.contmatic.prova.model.empresa.Cargo;
import br.com.contmatic.prova.model.empresa.Funcionario;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.prova.constantes.objetos.listas.SerializacaoListas.*;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.*;

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
		cargoCompleto = new Cargo(CargosObjetosConstantes.NOME_CARGOS, CargosObjetosConstantes.CBO_CARGOS, CargosObjetosConstantes.SALARIO_CARGOS, CargosObjetosConstantes.DESCRICAO_CARGOS, FUNCIONARIOS);
		cargo = new Cargo(CargosObjetosConstantes.CBO_ANALISTA_TI);
	}
	
	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Contato");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {ConstantesTestes.DOIS_CARACTERES, ConstantesTestes.MAIS_CEM_CARACTERES})
	@Order(1)
	void nao_deve_aceitar_fora_limite_caracteres_nome(String nome) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cargo.setNome(nome));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + CargoConstantes.TAMANHO_MINIMO_NOME_CARGO + " a "
						+ CargoConstantes.TAMANHO_MAXIMO_NOME_CARGO + " caracteres" + ", atualmente o campo possui " + nome.length()));
	}
	
	@Test
	@Order(2)
	void nao_deve_aceitar_nome_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> cargo.setNome(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	@Order(3)
	void nao_deve_aceitar_campo_vazio_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cargo.setNome(" "));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}
	
	@Order(4)
	@Test
	void nao_deve_aceitar_campo_nulo_salario() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> cargoCompleto.setSalario(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@ParameterizedTest
	@ValueSource( doubles = {800.80, 1209.99, 0.0})
	@Order(5)
	void nao_deve_aceitar_salario_menor_salario_minimo(double valores) {
		BigDecimal salAbaixoSalMinimo = valueOf(valores);
		this.illegalState = assertThrows(IllegalStateException.class,() -> cargoCompleto.setSalario(salAbaixoSalMinimo));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO));
	}
	
	@Test
	@Order(6)
	void deve_validar_salario_minimo() {
		assertEquals(CargosObjetosConstantes.SALARIO_CARGOS, cargoCompleto.getSalario());
	}
	
	@Test
	@Order(7)
	void nao_deve_aceitar_lista_vazia() {
		this.illegalState = assertThrows(IllegalStateException.class,() -> cargoCompleto.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}
	
	@Test
	@Order(8)
	void nao_deve_aceitar_lista_acima_limite() {
		while (funcionarioVazio.size() <= FuncionarioConstantes.TAMANHO_MAXIMO_LISTA_FUNCIONARIO) {
			funcionarioVazio.add(FuncionarioObjetosConstantes.FUNCIONARIO_01);
			funcionarioVazio.add(FuncionarioObjetosConstantes.FUNCIONARIO_02);
		}
		this.illegalState = assertThrows(IllegalStateException.class, () -> cargo.setFuncionarios(funcionarioVazio));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_NUMERO_EXCEDIDO_LISTA));
	}
	
	@Test
	@Order(9)
	void deve_validar_lista_funcionario() {
		assertEquals(FuncionarioObjetosConstantes.FUNCIONARIO_01, FUNCIONARIOS.get(0));
	}

	@Order(10)
	@Test
	void deve_validar_nome_correto() {
		assertEquals(CargosObjetosConstantes.NOME_CARGOS, cargoCompleto.getNome());
	}
	
	@Order(11)
	@Test
	void deve_validar_funcionario_correto() {
		assertEquals(FUNCIONARIOS, cargoCompleto.getFuncionarios());
	}
	
	@Order(12)
	@Test
	void deve_validar_cbo_correto() {
		assertAll(
				() -> assertNotEquals(CargosObjetosConstantes.CBO_CARGOS, cargo.getCbo()),
				() -> assertEquals(CargosObjetosConstantes.CBO_ANALISTA_TI, cargo.getCbo())
			);
	}
	
	@Order(13)
	@Test
	void deve_validar_descricao_correto() {
		assertEquals(CargosObjetosConstantes.DESCRICAO_CARGOS, cargoCompleto.getDescricao());
	}
	
	@Test
	@Order(14)
	void nao_deve_aceitar_hashcode_diferente() {
		assertNotEquals(cargoCompleto.hashCode(), cargo.hashCode());
	}

	@Test
	@Order(15)
	void deve_validar_hashcode_iguais() {
		assertEquals(cargoCompleto.hashCode(), cargoCompleto.hashCode());
	}
	
	@Test
	@Order(16)
	void deve_validar_equals() {
		assertAll(
				() -> assertEquals(cargoCompleto, cargoCompleto),
				() -> assertNotEquals(cargoCompleto, cargo),
				() -> assertNotNull(cargoCompleto),
				() -> assertNotEquals(true, cargoCompleto.equals(new Object()))
			);
	}

	@Test
	@Order(11)
	void deve_validar_toString() {
		assertAll(
				() -> assertEquals("Cargo [nome = " + CargosObjetosConstantes.NOME_CARGOS + ", cbo = " + CargosObjetosConstantes.CBO_CARGOS + ", salario = " + CargosObjetosConstantes.SALARIO_CARGOS + ", funcionarios = " + FUNCIONARIOS + ", descricao = " + CargosObjetosConstantes.DESCRICAO_CARGOS + "]", cargoCompleto.toString()),
				() -> assertEquals("Cargo [nome = " + null + ", cbo = " + CargosObjetosConstantes.CBO_ANALISTA_TI + ", salario = " + null + ", funcionarios = " + null + ", descricao = " + null+ "]", cargo.toString()),
				() -> assertNotEquals(cargo.toString(), cargoCompleto.toString())
		);
	}
	
}
