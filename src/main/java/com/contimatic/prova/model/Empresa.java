package com.contimatic.prova.model;

import java.time.LocalDate;
import java.util.List;

public class Empresa {
	
	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private LocalDate dataAbertura;
	
	private List<Setor> setor; 
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public List<Setor> getSetor() {
		return setor;
	}

	public void setSetor(List<Setor> setor) {
		this.setor = setor;
	}

}
