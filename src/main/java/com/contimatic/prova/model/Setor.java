package com.contimatic.prova.model;

import java.util.List;
import java.util.Objects;

public class Setor {

	private String nome;
	
	private List<Funcionario> funcionario;
	
	private String descricao;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Setor))
			return false;
		Setor other = (Setor) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
	
	
}