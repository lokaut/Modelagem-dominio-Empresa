package com.contimatic.prova.entidades;

import com.contimatic.prova.testes.funcionarios.FuncionarioTeste;

public class Funcionario {

	private String nome;
	
	private String cpf;
	
	private double salario;

	private Endereco Endereco;

	public Funcionario() {
	}



	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {
		FuncionarioTeste.sessantaCaracter(nome);
		FuncionarioTeste.nomeNulo(nome);
		FuncionarioTeste.nomeEmBranco(nome);
	}



	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return Endereco;
	}

	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}

	
}
