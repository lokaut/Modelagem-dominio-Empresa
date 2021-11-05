package com.contimatic.prova.model;

import static com.contimatic.prova.utils.ValidacaoCpf.validarCPF;
import static com.contimatic.prova.utils.ValidacaoData.dataNascMaiorIdade;
import static com.contimatic.prova.utils.ValidacaoData.validacaoDataAdmissao;
import static com.contimatic.prova.utils.ValidacaoUtils.limiteMaximoCaracter;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCaracterNumerico;
import static com.contimatic.prova.utils.ValidacaoUtils.validarEmail;
import static com.contimatic.prova.utils.ValidacaoUtils.validarSalarioMinimo;
import static com.contimatic.prova.utils.ValidacaoUtils.verificarCampoNulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class Funcionario {
	
	private String nome;
	
	private String email;
	
	private String cpf;

	private BigDecimal salario;

	private Endereco endereco;

	private LocalDate dataAdmissao;

	private LocalDate dataNascimento;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String email, String cpf, BigDecimal salario, Endereco endereco,
			LocalDate dataAdmissao, LocalDate dataNascimento) {

		setNome(nome);
		setEmail(email);
		setCpf(cpf);
		setSalario(salario);
		setEndereco(endereco);
		setDataAdmissao(dataAdmissao);
		setDataNascimento(dataNascimento);
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		verificarCampoNulo(dataNascimento);
		dataNascMaiorIdade(dataNascimento);
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificarCampoNulo(email);
		naoAceitarCampoEmBranco(email);
		validarEmail(email);
		this.email = email;
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
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", endereco=" + endereco
				+ ", dataAdmissao=" + dataAdmissao + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
}
