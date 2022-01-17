package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.CODIGO_IBGE_SAO_PAULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static com.contimatic.prova.constantes.ConstantesTestes.CARACTER_ESPECIAL;
import static com.contimatic.prova.constantes.ConstantesTestes.MAIS_SESSENTA_CARACTERES_ALFABETICOS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.model.Cidade;
import com.contimatic.prova.model.Endereco;

public class EnderecoTest {

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;
	
	private Endereco enderecoCompleto, endereco, enderecoCompleto2;
	private Cidade cidade;
	
	private String codigoIbge = CODIGO_IBGE_SAO_PAULO;
	private String municipio = "Pindamonhagaba";
	private String unidadeFederativa = "SP";
	
	private String logradouro = "Rua Basto";
	private String numero = "101";
	private String outroNumero = "103";
	private String outroCep = "18321050";
	private String bairro = "Vila Olimpía";
	private String cep = "16822050";
	
	@BeforeEach
	public void instancia() {
		cidade = new Cidade(codigoIbge, municipio, unidadeFederativa);
		endereco = new Endereco(outroCep, outroNumero);
		enderecoCompleto = new Endereco(logradouro, numero, bairro, cep, cidade);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Endereco");
	}
	
	@Test
	void nao_deve_aceitar_logradouro_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setLogradouro(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void nao_deve_aceitar_logradouro_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setLogradouro("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@Test
	void nao_deve_aceitar_logradouro_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setLogradouro(MAIS_SESSENTA_CARACTERES_ALFABETICOS));
		 assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre 1 a 60 caracteres, atualmente o campo possui " + MAIS_SESSENTA_CARACTERES_ALFABETICOS.length()));

	}
	
	@Test
	void nao_deve_aceitar_logradouro_caracter_especial() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setLogradouro(CARACTER_ESPECIAL));
		 assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}
	
	@Test
	void deve_validar_logradouro_correto() {
		this.endereco.setLogradouro("Rua A");
		assertEquals(logradouro, this.enderecoCompleto.getLogradouro());
		assertThat(this.endereco.getLogradouro(), equalToIgnoringCase("rua a"));
	}
	
	@Test
	void nao_deve_aceitar_bairro_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.endereco.setBairro(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void nao_deve_aceitar_bairro_vazio() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro("  "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@Test
	void nao_deve_aceitar_bairro_fora_limite_caracteres() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro(MAIS_SESSENTA_CARACTERES_ALFABETICOS));
		 assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre 1 a 60 caracteres, atualmente o campo possui " + MAIS_SESSENTA_CARACTERES_ALFABETICOS.length()));
	}
	
	@Test
	void nao_deve_aceitar_bairro_caracter_especial() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> this.endereco.setBairro(CARACTER_ESPECIAL));
		 assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
	}
	
}
