package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contimatic.prova.utils.ValidacaoCpf.validarCPF;
import static br.com.contimatic.prova.utils.ValidacaoDatas.dataNascMaiorIdade;
import static br.com.contimatic.prova.utils.ValidacaoDatas.validacaoDataAdmissao;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCampoEmBranco;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarSalarioMinimo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {
	
	private String nome;
	
	private String cpf;

	private Contato contato;
	
	private BigDecimal salario;

	private Endereco endereco;

	private LocalDate dataAdmissao;

	private LocalDate dataNascimento;
	
	private Setor setor;
	
	public Funcionario(String cpf) {
		this.setCpf(cpf);
	} 

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
		verificarObjetoNulo(nome);
		validarCampoEmBranco(nome);
		limiteCaracteresMinimoMaximo(nome, 3, 60);
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

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		verificarObjetoNulo(salario);
		validarSalarioMinimo(salario);
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
		
	public void setDataAdmissao(LocalDate dataAdmissao) {
		verificarObjetoNulo(dataAdmissao);
		validacaoDataAdmissao(dataAdmissao);
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
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
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", contato=" + contato + ", salario=" + salario
				+ ", endereco=" + endereco + ", dataAdmissao=" + dataAdmissao + ", dataNascimento=" + dataNascimento
				+ ", setor=" + setor + "]";
	}
	
}