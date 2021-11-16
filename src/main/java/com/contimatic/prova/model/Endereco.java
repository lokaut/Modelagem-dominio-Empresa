 package com.contimatic.prova.model;

import java.util.Objects;

public class Endereco {
	
	private String logradouro;
	
	private String numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	public Endereco() {}
	
	public Endereco( String logradouro, String numero, String bairro, String cidade, String estado,  String cep) {
		this.setEstado(estado);
		this.setCidade(cidade);
		this.setBairro(bairro);
		this.setlogradouro(logradouro);
		this.setNumero(numero);
		this.setCep(cep);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getlogradouro() {
		return logradouro;
	}

	public void setlogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [estado = " + estado + ", cidade = " + cidade + ", bairro = " + bairro + ", logradouro = " + logradouro + 
				 ", numero = " + numero + ", cep = " + cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(logradouro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Endereco))
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(logradouro, other.logradouro);
	}

	
	
}
