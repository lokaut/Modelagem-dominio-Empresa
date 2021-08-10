package com.contimatic.prova.entidades;

import java.util.Objects;

import com.contimatic.prova.testes.funcionarios.FuncionarioValidacao;

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
		FuncionarioValidacao.sessantaCaracter(nome);
		FuncionarioValidacao.nomeNulo(nome);
		FuncionarioValidacao.nomeEmBranco(nome);
	}



	@Override
	public int hashCode() {
		return Objects.hash(Endereco, cpf, nome, salario);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(Endereco, other.Endereco) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}



	

	
}
