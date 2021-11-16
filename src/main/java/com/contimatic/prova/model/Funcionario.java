package com.contimatic.prova.model;

import static com.contimatic.prova.utils.ValidacaoCpf.validarCPF;
import static com.contimatic.prova.utils.ValidacaoUtils.dataNascMaiorIdade;
import static com.contimatic.prova.utils.ValidacaoUtils.limiteMaximoCaracter;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCaracterNumerico;
import static com.contimatic.prova.utils.ValidacaoUtils.validacaoDataAdmissao;
import static com.contimatic.prova.utils.ValidacaoUtils.validarSalarioMinimo;
import static com.contimatic.prova.utils.ValidacaoUtils.verificarCampoNulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.contimatic.prova.utils.ValidacaoUtils;


public class Funcionario {
	
	private String nome;
	
	private String cpf;

	private Contato contato;
	
	private BigDecimal salario;

	private Endereco endereco;

	private LocalDate dataAdmissao;

	private LocalDate dataNascimento;
	
	
	public Funcionario() {} 

	public Funcionario(String nome, String cpf, Contato contato, BigDecimal salario, Endereco endereco, LocalDate dataAdmissao, LocalDate dataNascimento) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setContato(contato);
		this.setEndereco(endereco);
		this.setSalario(salario);
		this.setDataAdmissao(dataAdmissao);
		this.setDataNascimento(dataNascimento);
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificarCampoNulo(nome);
		naoAceitarCampoEmBranco(nome);
		limiteMaximoCaracter(nome, 3, 60);
		naoAceitarCaracterNumerico(nome);
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		verificarCampoNulo(cpf);
		validarCPF(cpf);
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		verificarCampoNulo(salario);
		validarSalarioMinimo(salario);
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
		
	public void setDataAdmissao(LocalDate dataAdmissao) {
		verificarCampoNulo(dataAdmissao);
		validacaoDataAdmissao(dataAdmissao);
		this.dataAdmissao = dataAdmissao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		verificarCampoNulo(endereco);
		this.endereco = endereco;
	}
	
	public void setContato(Contato contato) {
		verificarCampoNulo(contato);
		this.contato = contato;
	}

	public Contato getContato() {
		return contato;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		verificarCampoNulo(dataNascimento);
		dataNascMaiorIdade(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		
		return Objects.equals(cpf, other.cpf);			
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", contato=");
		builder.append(contato);
		builder.append(", salario=");
		builder.append(salario);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", dataAdmissao=");
		builder.append(dataAdmissao);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append("]");
		return builder.toString();
	}

}