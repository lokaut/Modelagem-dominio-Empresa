package br.com.contimatic.prova.model;

import java.util.List;
import java.util.Objects;

public class Setor {

	private String nome;
	
	private String cbo;
	
	private List<Funcionario> funcionario;
	
	private String descricao;
	
	private Empresa empresa;

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cbo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Setor)) {
			return false;
		}
		Setor other = (Setor) obj;
		return Objects.equals(cbo, other.cbo);
	}

	@Override
	public String toString() {
		return "Setor [nome=" + nome + ", funcionario=" + funcionario + ", descricao=" + descricao + ", empresa="
				+ empresa + "]";
	}
	
}
