package br.com.contimatic.prova;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import br.com.contimatic.prova.model.Setor;

public class SetorTest {
 
	private IllegalStateException illegalState;
	private IllegalArgumentException illegalArgument;
	
	private Setor setor, setorCompleto;
	//private String nome = 

	@BeforeEach
	public void instancia() {
		
	}
	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Setor");
	}


}

