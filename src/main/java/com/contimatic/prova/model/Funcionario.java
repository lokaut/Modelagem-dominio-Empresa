package com.contimatic.prova.model;

import static com.contimatic.prova.utils.ValidacaoUtils.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;



public class Funcionario {

	private String nome;

	private String cpf;

	private BigDecimal salario;

	private Endereco Endereco;

	Boolean validar = false;

	private LocalDate dataAdmissao;


	public Funcionario() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificacaoCampoNulo(nome);
		naoAceitarCampoEmBranco(nome);
		naoAceitarCaracterNumerico(nome);
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public String toString() {
		return "Funcionario [Nome=" + nome + ", CPF=" + cpf + ", Salário=" + salario + ", Endereço=" + Endereco + ", Data de admição= " + dataAdmissao + "]";
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

}
