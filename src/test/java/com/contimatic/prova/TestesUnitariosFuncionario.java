package com.contimatic.prova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.model.Funcionario;

class TestesUnitariosFuncionario {

	private Funcionario funcionario;
	private String testes;

	@BeforeEach
	public void instancia() {
		funcionario = new Funcionario();
		//aplicação dos testes
		 testes = "erick";
	}

	@Test
	void deve_validar_quantidades_caracteres_nome() {
		funcionario.setNome(testes);
	}

	@Test
	void deve_validar_campo_nome_nulo() {
		funcionario.setNome(testes);
	}

	@Test
	void deve_validar_campo_em_branco_nome() {
		funcionario.setNome(testes);
	}
	
	@Test
	void deve_validar_caracter_numerico_nome() {
		funcionario.setNome(testes);
	}


}