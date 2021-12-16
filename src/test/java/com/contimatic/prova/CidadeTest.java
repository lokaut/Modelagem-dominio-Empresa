package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.CODIGO_IBGE_SAO_PAULO;
import static com.contimatic.prova.constantes.Constantes.SESSENTA_DOIS_CARACTERES;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.model.Cidade;

public class CidadeTest {
	Cidade cidade, cidadeConstrutor, cidadeConstrutor2;

	IllegalStateException illegalState;
	IllegalArgumentException illegalArgument;

	private String codigoIbge = CODIGO_IBGE_SAO_PAULO;
	private String municipio = "São Paulo";
	private String unidadeFederativa = "SP";

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
	void nao_deve_aceitar_diferente_sete_caracteres() {
		assertThrows(IllegalStateException.class, () -> cidade.setCodigoIbge("12345678"));
		
	}
	
}
