package br.com.contmatic.prova.endereco;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.contmatic.prova.constantes.ConstantesTestes;
import br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes;
import br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.model.EnderecoConstantes;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;

public class EnderecoTest {

	private IllegalStateException illegalState;
	
	private IllegalArgumentException illegalArgument;

	private Endereco enderecoCompleto;
	
	private Endereco enderecoCompleto2;
	
	private Endereco endereco;
	
	private Endereco enderecoHash2;
	
	private Endereco enderecoHash3;
	
	private Cidade cidade;

	@BeforeEach
	public void instanciar() {
		cidade = new Cidade(CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO, CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO, CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP);
		endereco = new Endereco(EnderecoObjetosConstantes.LOGRADOURO, EnderecoObjetosConstantes.NUMERO_ENDERECO, EnderecoObjetosConstantes.BAIRRO, null, EnderecoObjetosConstantes.CEP, cidade);
		enderecoHash2 = new Endereco(EnderecoObjetosConstantes.LOGRADOURO_02, EnderecoObjetosConstantes.NUMERO_ENDERECO, EnderecoObjetosConstantes.BAIRRO, EnderecoObjetosConstantes.SEGUNDO_CEP, CidadeObjetosConstantes.CIDADE);
		enderecoHash3 = new Endereco(EnderecoObjetosConstantes.LOGRADOURO, EnderecoObjetosConstantes.SEGUNDO_NUMERO_ENDERECO, EnderecoObjetosConstantes.BAIRRO_02, EnderecoObjetosConstantes.CEP, CidadeObjetosConstantes.CIDADE_02);
		enderecoCompleto = new Endereco(EnderecoObjetosConstantes.LOGRADOURO, EnderecoObjetosConstantes.NUMERO_ENDERECO, EnderecoObjetosConstantes.BAIRRO, EnderecoObjetosConstantes.CEP, CidadeObjetosConstantes.CIDADE);
		enderecoCompleto2 = new Endereco(EnderecoObjetosConstantes.LOGRADOURO, EnderecoObjetosConstantes.NUMERO_ENDERECO, EnderecoObjetosConstantes.BAIRRO, EnderecoObjetosConstantes.COMPLEMENTO, EnderecoObjetosConstantes.CEP, cidade);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Endereco");
	}

	@Test
	void nao_deve_aceitar_logradouro_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setLogradouro(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_logradouro_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setLogradouro("  "));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_logradouro_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> this.endereco.setLogradouro(ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS));
		assertTrue(this.illegalState.getMessage().contains(
				"Quantidade de carácter inválido, o campo deve estar entre "+ EnderecoConstantes.TAMANHO_MINIMO_LOGRADOURO_ENDERECO +" a "+ EnderecoConstantes.TAMANHO_MAXIMO_LOGRADOURO_ENDERECO +" caracteres, atualmente o campo possui "
						+ ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS.length()));
	}

	@Test
	void nao_deve_aceitar_logradouro_caracter_especial() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> this.endereco.setLogradouro(ConstantesTestes.CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}

	@Test
	void deve_validar_logradouro_correto() {
		this.endereco.setLogradouro("Rua A");
		assertEquals(EnderecoObjetosConstantes.LOGRADOURO, this.enderecoCompleto.getLogradouro());
		assertThat(this.endereco.getLogradouro(), equalToIgnoringCase("rua a"));
	}

	@Test
	void nao_deve_aceitar_bairro_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setBairro(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_bairro_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro("  "));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_bairro_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class,
				() -> this.endereco.setBairro(ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + EnderecoConstantes.TAMANHO_MINIMO_BAIRRO_ENDERECO + " a "
						+ EnderecoConstantes.TAMANHO_MAXIMO_BAIRRO_ENDERECO + " caracteres, atualmente o campo possui "
						+ ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS.length()));
	}

	@Test
	void nao_deve_aceitar_bairro_caracter_especial() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro(ConstantesTestes.CARACTER_ESPECIAL));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}

	@Test
	void deve_validar_bairro_correto() {
		this.endereco.setBairro("Vila das belezas");
		assertThat(endereco.getBairro(), is(equalToIgnoringCase("vila das belezas")));
	}

	@Test
	void nao_deve_aceitar_numero_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setNumero(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_numero_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setNumero("  "));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@Test
	void nao_deve_aceitar_numero_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setNumero(ConstantesTestes.MAIS_CIQUENTA_NUMEROS));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + EnderecoConstantes.TAMANHO_MINIMO_NUMERO_ENDERECO
						+ " a " + EnderecoConstantes.TAMANHO_MAXIMO_NUMERO_ENDERECO + " caracteres, atualmente o campo possui "
						+ ConstantesTestes.MAIS_CIQUENTA_NUMEROS.length()));
	}

	@Test
	void nao_deve_aceitar_caracter_alfabetico_em_numero_endereco() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setNumero("onze"));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void deve_validar_numero_correto() {
		this.endereco.setNumero(ConstantesTestes.ONZE_NUMEROS);
		assertNotEquals(EnderecoObjetosConstantes.SEGUNDO_NUMERO_ENDERECO, endereco.getNumero());
		assertEquals(ConstantesTestes.ONZE_NUMEROS, endereco.getNumero());
	}

	@Test
	void nao_deve_aceitar_cidade_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setCidade(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void deve_validar_cidade_correta() {
		assertEquals(cidade, this.enderecoCompleto.getCidade());
	}

	@Test
	void nao_deve_aceitar_cep_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setCep(null));
		assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
	}

	@Test
	void nao_deve_aceitar_cep_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setCep("  "));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
	}

	@ParameterizedTest
	@ValueSource(strings = { "00", "123", "1234567", "0455105", "045510504551050455105", "0000000" })
	void nao_deve_aceitar_cep_fora_limite_caracteres(String cepLimite) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setCep(cepLimite));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácteres inválido! O campo deve possuir apenas " + EnderecoConstantes.TAMANHO_FIXO_CEP_ENDERECO
						+ " caracteres, atualmente o campo possui " + cepLimite.length() + " caractere(s)"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abcdefgh", "abc2345h", "@b4def@@", "04551@59", "abc#´%g3" })
	void nao_deve_aceitar_caracter_alfabetico_cep(String cepAlfabetico) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setCep(cepAlfabetico));
		assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
	}

	@Test
	void deve_aceitar_cep_correto() {
		assertEquals(EnderecoObjetosConstantes.CEP, enderecoCompleto.getCep());
	}
	
	@Test
	void deve_aceitar_complemento_nulo() {
		assertNull(endereco.getComplemento());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"   ", "", "       "})
	void deve_aceitar_complemento_vazio(String complementoVazio) {
		this.endereco.setComplemento(complementoVazio);
		assertTrue(endereco.getComplemento().isBlank());
	}
	
	@Test
	void nao_deve_aceitar_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setComplemento(ConstantesTestes.EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS));
		assertTrue(this.illegalState.getMessage()
				.contains("Quantidade de carácter inválido, o campo deve estar entre " + EnderecoConstantes.TAMANHO_MINIMO_COMPLEMENTO_ENDERECO
						+ " a " + EnderecoConstantes.TAMANHO_MAXIMO_COMPLEMENTO_ENDERECO + " caracteres, atualmente o campo possui "
						+ ConstantesTestes.EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS.length()));
	}
	
	@Test
	void deve_validar_hashcode_endereco() {
		assertEquals(enderecoCompleto.hashCode(), enderecoCompleto2.hashCode());
		assertNotEquals(enderecoHash2.hashCode(), enderecoHash3.hashCode());
		assertNotEquals(enderecoHash3, endereco.hashCode());
		assertNotEquals(enderecoHash2.hashCode(), enderecoCompleto.hashCode());
	}

	@Test
	void deve_validar_equals() {
		assertEquals(enderecoCompleto,enderecoCompleto2);
		assertEquals(enderecoCompleto,enderecoCompleto);
		assertNotEquals(null, enderecoCompleto);
		assertNotEquals(true, enderecoCompleto.equals(new Object()));
		assertNotEquals(enderecoHash2, enderecoHash3);
		assertNotEquals(enderecoHash2, endereco);
	}

	@Test
	void deve_validar_toString() {
		assertEquals("Endereco [logradouro = " + EnderecoObjetosConstantes.LOGRADOURO + ", numero = " + EnderecoObjetosConstantes.NUMERO_ENDERECO +", complemento = "+ EnderecoObjetosConstantes.COMPLEMENTO +", bairro = " + EnderecoObjetosConstantes.BAIRRO + ", cidade = " + cidade + ", cep = " + EnderecoObjetosConstantes.CEP + "]", enderecoCompleto2.toString());
		assertNotEquals("Endereco [logradouro = " + EnderecoObjetosConstantes.LOGRADOURO + ", numero = " + EnderecoObjetosConstantes.NUMERO_ENDERECO +", complemento = "+ EnderecoObjetosConstantes.COMPLEMENTO +", bairro = " + EnderecoObjetosConstantes.BAIRRO + ", cidade = " + cidade + ", cep = " + EnderecoObjetosConstantes.CEP + "]", enderecoCompleto.toString());
	}
}
