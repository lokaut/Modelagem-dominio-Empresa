package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Empresa {
	
	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private LocalDate dataAbertura;
	
	private List<Setor> setores; 
	
	private List<Contato> contatos;
	
	private List<Endereco> enderecos;
	
	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}
	
	public Empresa(String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataAbertura, List<Setor> setores,
			List<Contato> contatos, List<Endereco> enderecos) {
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
		this.setNomeFantasia(nomeFantasia);
		this.setDataAbertura(dataAbertura);
		this.setSetores(setores);
		this.setContatos(contatos);
		this.setEnderecos(enderecos);
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		verificarObjetoNulo(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		verificarObjetoNulo(razaoSocial);
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		verificarObjetoNulo(nomeFantasia);
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		verificarObjetoNulo(dataAbertura);
		this.dataAbertura = dataAbertura;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		verificarObjetoNulo(setores);
		validarListaVazia(setores);
		this.setores = setores;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		verificarObjetoNulo(contatos);
		validarListaVazia(contatos);
		this.contatos = contatos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		verificarObjetoNulo(enderecos);
		validarListaVazia(enderecos);
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", dataAbertura=" + dataAbertura + ", setores=" + setores + ", contato=" + contatos + ", endereco="
				+ enderecos + "]";
	}
	
}
