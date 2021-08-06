package com.contimatic.prova;

import static com.contimatic.prova.constantes.Constantes.SESSENTA_CARACTER;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contimatic.prova.entidades.Funcionario;

class TestesUnitariosFuncionario {

	private Funcionario funcionario;

	@BeforeEach
	public void instancia() {
		funcionario = new Funcionario();
	}

	@Test
	void validar_quantidades_caracteres_nome() {
		funcionario.setNome(SESSENTA_CARACTER);
	}

	@Test
	void validar_campo_nulo_nome() {
		funcionario.setNome(null);
	}

	@Test
	void validar_campo_em_branco_nome() {
		funcionario.setNome("    ");
	}

}