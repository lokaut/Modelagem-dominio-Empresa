package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import br.com.contimatic.prova.utils.ValidacaoUtils;

public class Empresa {
	
	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private LocalDate dataAbertura;
	
	private List<Setor> setores; 
	
	private List<Contato> contato;
	
	private List<Endereco> endereco;

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

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		verificarObjetoNulo(contato);
		validarListaVazia(contato);
		this.contato = contato;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		verificarObjetoNulo(endereco);
		validarListaVazia(endereco);
		this.endereco = endereco;
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
				+ ", dataAbertura=" + dataAbertura + ", setores=" + setores + ", contato=" + contato + ", endereco="
				+ endereco + "]";
	}
	
}
