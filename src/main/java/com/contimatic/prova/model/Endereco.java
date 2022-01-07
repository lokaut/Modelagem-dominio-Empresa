 package com.contimatic.prova.model;

import java.util.Objects;

public class Endereco {
	
	private String logradouro;
	
	private String numero;
	
	private String bairro;
	
	private Cidade cidade; 
	
	private String cep;
	
	public Endereco() {}
	
	public Endereco( String logradouro, String numero, String bairro, String cep) {
	//	this.setEstado(estado);
		//this.setCidade(cidade);
		this.setBairro(bairro);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setCep(cep);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [estado = " + ", cidade = " + cidade + ", bairro = " + bairro + ", logradouro = " + logradouro + 
				 ", numero = " + numero + ", cep = " + cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}
}
