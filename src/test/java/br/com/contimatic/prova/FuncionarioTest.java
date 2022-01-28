package br.com.contimatic.prova;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_ADMISSAO_FUTURA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_INVALIDO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.Constantes.SALARIO_MINIMO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesTestes.DOIS_CARACTERES;
import static br.com.contimatic.prova.constantes.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contimatic.prova.constantes.ConstantesTestes.ONZE_NUMEROS_CARACTERES;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contimatic.prova.model.Contato;
import br.com.contimatic.prova.model.Endereco;
import br.com.contimatic.prova.model.Funcionario;
import br.com.contimatic.prova.model.Setor;

class FuncionarioTest {

	Funcionario funcionario, funcionarioCompleto, funcionarioCompleto2;
	Contato contato;

	IllegalStateException illegalState;
	IllegalArgumentException illegalArgument;

	LocalDate dataNasciIdadeMinimaInvalida = LocalDate.of(2010, 12, 05);
	LocalDate dataNascimentoValido = LocalDate.of(1994, 12, 05);
	LocalDate dataFutura = LocalDate.of(2023, 11, 04);
	LocalDate dataAdmissao = LocalDate.of(2021, 11, 04);

	BigDecimal salarioMinimo = SALARIO_MINIMO;
	BigDecimal salarioMenorSalarioMinimo;
	Endereco endereco;
	Setor setor;

	String cpfValido = "90795007809";
	String segundoCpfValido = "76899070081";
	String nomeCompleto = "Lókaut Santos";
	String cboValido = "142510";

	@BeforeEach
	public void instancia() {
		setor = new Setor(cboValido);
		salarioMenorSalarioMinimo = new BigDecimal(800.2);
		endereco = new Endereco("06824050", "381");
		contato = new Contato("erick224@gmail.com");
		funcionario = new Funcionario(segundoCpfValido);
		funcionarioCompleto = new Funcionario(nomeCompleto, cpfValido, contato, salarioMinimo, endereco,
				dataAdmissao, dataNascimentoValido, setor);
		funcionarioCompleto2 = new Funcionario(nomeCompleto, cpfValido, contato, salarioMinimo, endereco,
				dataAdmissao, dataNascimentoValido, setor);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes funcionario");
	}

	@ParameterizedTest
	@ValueSource(strings = { DOIS_CARACTERES, MAIS_CEM_CARACTERES })
	void nao_deve_aceitar_fora_limite_caracteres_nome(String nome) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(nome));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NOME_FUNCIONARIO + " a "
						+ TAMANHO_MAXIMO_NOME_FUNCIONARIO + " caracteres" + ", atualmente o campo possui " + nome.length()));
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_campo_vazio_nome() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "123456", "@@123", "Am@anda sous@", "J$ssica Cardoso", "&rick" })
	void nao_deve_aceitar_caracter_numerico_especial_nome(String nome) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(nome));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "440856", "9079500780", "907950078", "90795007", "9079500", "90795", "9079", "907", "90",
			"9", "907950078095", "9079500780990795007809" })
	void nao_deve_aceitar_numeros_diferente_onze_numeros_cpf(String cpf) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(cpf));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS));
	}

	@ParameterizedTest
	@ValueSource(strings = { "00000000000", "11111111111", "22222222222", "33333333333", "44444444444", "55555555555",
			"66666666666", "77777777777", "88888888888", "99999999999" })
	void nao_deve_aceitar_cpf_somente_numeros_iguais() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf("00000000000"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CPF_INVALIDO));
	}

	@Test
	void nao_deve_aceitar_caracter_texto_cpf() {
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(ONZE_NUMEROS_CARACTERES));
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
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> funcionario.setSalario(salarioMenorSalarioMinimo));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO));
	}

	@ParameterizedTest
	@ValueSource(ints = { 15, 14, 13, 12, 11, 10, 9, 8, 7, 5, 4, 3, 2, 1, -5 })
	void nao_deve_aceitar_funcionario_menor_dezesseis_anos(int idade) {
		LocalDate dataNascimento = now().minusYears(idade);
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataNascimento(dataNascimento));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IDADE_MINIMA_EMPRESA));
	}

	@ParameterizedTest
	@ValueSource(ints = { 3, 4, 5, 6, 7, 8 })
	void nao_deve_aceitar_data_admissao_acima_dois_meses(int meses) {
		 LocalDate mesesAposDataHoje = now().plusMonths(meses);
		illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataAdmissao(mesesAposDataHoje));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_ADMISSAO_FUTURA));
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
	void nao_deve_aceitar_campo_setor_nulo() {
		illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setSetor(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void deve_validar_data_nascimento_correto() {
		assertEquals(dataNascimentoValido, funcionarioCompleto.getDataNascimento());
	}
	
	@Test
	void deve_validar_data_setor_correto() {
		assertEquals(setor, funcionarioCompleto.getSetor());
	}
	
	@Test
	void deve_validar_data_admissao_correto() {
		assertEquals(dataAdmissao, funcionarioCompleto.getDataAdmissao());
	}
	
	@Test
	void deve_validar_salario_minimo() {
		assertEquals(salarioMinimo, funcionarioCompleto.getSalario());
	}
	
	@Test
	void deve_validar_contato_correto() {
		assertEquals(contato, funcionarioCompleto.getContato());
	}
	
	@Test
	void deve_validar_campo_nome_correto() {
		assertEquals(nomeCompleto, funcionarioCompleto.getNome());
	}
	
	@Test
	void deve_validar_cpf_correto() {
		assertEquals(segundoCpfValido, funcionario.getCpf());
	}
	
	@Test
	void deve_validar_Endereco_correto() {
		assertEquals(endereco, funcionarioCompleto.getEndereco());
	}
	
	@Test
	void nao_deve_validar_hashcode_diferente() {
		assertNotEquals(funcionario.hashCode(), funcionarioCompleto.hashCode());
	}
	
	@Test
	void deve_validar_hashcode_igual() {
		assertEquals(funcionarioCompleto.hashCode(), funcionarioCompleto2.hashCode());
	}
	
	@Test
	void deve_validar_equals_hashcode() {
		assertEquals(funcionarioCompleto,funcionarioCompleto2);
		assertEquals(funcionarioCompleto, funcionarioCompleto);
		assertNotEquals(null, funcionarioCompleto);
		assertNotEquals(true, funcionarioCompleto.equals(new Object()));
	}
	
	@Test
	void deve_validar_toString() {
		assertEquals( "Funcionario [nome=" + nomeCompleto + ", cpf = " + cpfValido + ", contato=" + contato + ", salario = " + salarioMinimo
				+ ", endereco = " + endereco + ", dataAdmissao=" + dataAdmissao + ", dataNascimento = " + dataNascimentoValido
				+ ", setor = " + setor + "]", funcionarioCompleto.toString());
	}
}
