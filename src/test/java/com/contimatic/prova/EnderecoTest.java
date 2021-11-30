package com.contimatic.prova;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import com.contimatic.prova.model.Contato;
import com.contimatic.prova.model.Endereco;

public class EnderecoTest {

	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;
	
	private Endereco endereco, enderecoConstrutor, enderecoConstrutor2;
	
	private String logradouro = "Rua Basto";
	private String numero = "101";
	private String bairro = "Vila Olimpía";
	private String cidade = "São Paulo";
	private String estado = "SP";
	private String cep = "06822050";
 	
	@BeforeEach
	public void instancia() {
		endereco = new Endereco();
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Endereco");
	}
	
}
