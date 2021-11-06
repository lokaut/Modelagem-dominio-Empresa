 package com.contimatic.prova.model;

public class Endereco {
	
	private String estado;
	
	private String cidade;
		
	private String bairro;
	
	private String rua;
	
	private String cep;
	
	private String numero;
	
	public Endereco() {}
	
	public Endereco(String estado, String cidade, String bairro, String rua, String numero, String cep) {
		this.setEstado(estado);
		this.setCidade(cidade);
		this.setBairro(bairro);
		this.setRua(rua);
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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
		return "Endereco [estado = " + estado + ", cidade = " + cidade + ", bairro = " + bairro + ", rua = " + rua + 
				 ", numero = " + numero + ", cep = " + cep + "]";
	}


	
}
