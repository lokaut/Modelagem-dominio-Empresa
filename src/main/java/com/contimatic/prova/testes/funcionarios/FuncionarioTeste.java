package com.contimatic.prova.testes.funcionarios;

import com.contimatic.prova.entidades.Funcionario;

/**
 * Hello world!
 *
 */
public class FuncionarioTeste {

	Funcionario funcionario = new Funcionario();

	public static void sessantaCaracter(String nome) {
		if (nome != null) {
			if ((nome.length() <= 2 || nome.length() >= 60)) {
				//illegalstatt
				throw new IllegalArgumentException("Quantidade de carácter inválido, o Nome deve estar entre 2 a 60 caracteres");
			}
		}
	}
	
	//nonNull
	public static void nomeNulo(String nome) {
		if(nome == null) {
			throw new IllegalArgumentException("campo não pode ser nulo" );
		}

	}

	public static void nomeEmBranco(String nome) {
		if(nome.isBlank()) {
			throw new IllegalArgumentException("campo nome não pode ter caracter com espaço" );			
		}
		
	}
}