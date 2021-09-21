package com.contimatic.prova.model;

import static com.contimatic.prova.utils.ValidacaoUtils.limiteMaximoCaracter;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCaracterNumerico;
import static com.contimatic.prova.utils.ValidacaoUtils.verificacaoCampoNulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

//criar uma classe empresa

//campo para data futura e  menor de 18 anos data de nascimento

public class Funcionario {

	private String nome;
	
	private String email;
	
	private String cpf;

	private BigDecimal salario;

	private Endereco endereco;

	private LocalDate dataAdmissao;

	private LocalDate dataNascimento;
	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		limiteMaximoCaracter(nome, 3, 60);
		verificacaoCampoNulo(nome);
		naoAceitarCampoEmBranco(nome);
		naoAceitarCaracterNumerico(nome);
		this.nome = nome;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
		
	public void setDataAdmissao(LocalDate dataAdmissao) {
		verificacaoCampoNulo(dataAdmissao);
		this.dataAdmissao = dataAdmissao;
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
