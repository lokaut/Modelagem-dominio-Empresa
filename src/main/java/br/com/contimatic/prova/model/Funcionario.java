package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_FUNCIONARIO;
import static br.com.contimatic.prova.utils.ValidacaoCpf.validarCPF;
import static br.com.contimatic.prova.utils.ValidacaoDatas.dataNascMaiorIdade;
import static br.com.contimatic.prova.utils.ValidacaoDatas.validarDataAdmissao;
import static br.com.contimatic.prova.utils.ValidacaoDatas.validarDesligamento;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {
	
	private String nome;
	
	private String cpf;

	private Contato contato;
	
	private Endereco endereco;

	private LocalDate dataAdmissao;

	private LocalDate dataNascimento;
	
	private LocalDate dataDesligamento;
	
	private Setor setor;
	
	private Cargo cargo;
	
	public Funcionario(String cpf) {
		this.setCpf(cpf);
	} 

	public Funcionario(String nome, String cpf, Contato contato, Endereco endereco, LocalDate dataAdmissao, LocalDate dataNascimento, Cargo cargo, Setor setor) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setContato(contato);
		this.setEndereco(endereco);
		this.setDataAdmissao(dataAdmissao);
		this.setDataNascimento(dataNascimento);
		this.setCargo(cargo);
		this.setSetor(setor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificarObjetoNulo(nome);
		validarCampoVazio(nome);
		limiteCaracteresMinimoMaximo(nome, TAMANHO_MINIMO_NOME_FUNCIONARIO, TAMANHO_MAXIMO_NOME_FUNCIONARIO);
		validarCaracteresPermitidos(nome, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		verificarObjetoNulo(cpf);
		validarCPF(cpf);
		this.cpf = cpf;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
		
	public void setDataAdmissao(LocalDate dataAdmissao) {
		verificarObjetoNulo(dataAdmissao);
		validarDataAdmissao(dataAdmissao);
		this.dataAdmissao = dataAdmissao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		verificarObjetoNulo(endereco);
		this.endereco = endereco;
	}
	
	public void setContato(Contato contato) {
		verificarObjetoNulo(contato);
		this.contato = contato;
	}

	public Contato getContato() {
		return contato;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		verificarObjetoNulo(dataNascimento);
		dataNascMaiorIdade(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		validarDesligamento(dataDesligamento);
		this.dataDesligamento = dataDesligamento;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		verificarObjetoNulo(setor);
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		verificarObjetoNulo(cargo);
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Funcionario)) {
			return false;
		}
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf = " + cpf + ", contato=" + contato + ", endereco = " + endereco + ", dataAdmissao = " + dataAdmissao + ", dataNascimento = " + dataNascimento
				+ ", dataDesligamento = " + dataDesligamento + ", setor = " + setor + ", Cargo = " + cargo +  "]";
	}
	
}