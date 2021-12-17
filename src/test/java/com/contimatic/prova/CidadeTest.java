package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.CODIGO_IBGE_SAO_PAULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.constantes.Constantes;
import com.contimatic.prova.model.Cidade;

public class CidadeTest {
	Cidade cidade, cidadeConstrutor, cidadeConstrutor2;

	IllegalStateException illegalState;
	IllegalArgumentException illegalArgument;

	private String codigoIbge = CODIGO_IBGE_SAO_PAULO;
	private String municipio = "São Paulo";
	private String unidadeFederativa = "SP";
	
	private String codigoErradoIbge = "123345678";

	@BeforeEach
	public void instancia() {
		cidade = new Cidade();
		cidadeConstrutor  = new Cidade(codigoIbge, municipio, unidadeFederativa);
		cidadeConstrutor2 = new Cidade(codigoIbge, municipio, unidadeFederativa);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes na classe Cidade");
	}
	
	@Test
	void nao_deve_aceitar_diferente_sete_caracteres_codigoIbge() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cidade.setCodigoIbge(codigoErradoIbge));
		assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas "+ 7 + " caracteres"
				+ ", atualmente o campo possui " + codigoErradoIbge.length() +  " caractere(s)"));
	}
	
	@Test
	void nao_deve_aceitar_campo_nome_nulo_codigoIbge() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> cidade.setCodigoIbge(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@Test
	void nao_deve_aceitar_campo_vazio_nome_codigoIbge() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cidade.setCodigoIbge(" "));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
	
	@Test
	void nao_deve_aceitar_caracter_alfabetico_codigoIbge() {
		this.illegalState = assertThrows(IllegalStateException.class, () -> cidade.setCodigoIbge("abc1221"));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO));
	}
}
