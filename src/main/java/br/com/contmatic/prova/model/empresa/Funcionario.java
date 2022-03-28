package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_FUNCIONARIO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_FUNCIONARIO;
import static br.com.contmatic.prova.utils.ValidacaoCpf.validarCPF;
import static br.com.contmatic.prova.utils.ValidacaoDatas.dataNascMaiorIdade;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDataAdmissao;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDesligamento;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDate;
import java.util.Objects;

import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.endereco.Endereco;

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

	public Funcionario(String nome, String cpf, Contato contato, Endereco endereco, LocalDate dataAdmissao,
			LocalDate dataNascimento, Cargo cargo, Setor setor) {
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
		verificarNulo(nome);
		validarCampoVazio(nome);
		limiteCaracteresMinimoMaximo(nome, TAMANHO_MINIMO_NOME_FUNCIONARIO, TAMANHO_MAXIMO_NOME_FUNCIONARIO);
		validarCaracteresPermitidos(nome, REGEX_CARACTERES_ALFABETICOS_ACENTOS,
				MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		verificarNulo(cpf);
		validarCPF(cpf);
		this.cpf = cpf;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		verificarNulo(dataAdmissao);
		validarDataAdmissao(dataAdmissao);
		this.dataAdmissao = dataAdmissao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		verificarNulo(endereco);
		this.endereco = endereco;
	}

	public void setContato(Contato contato) {
		verificarNulo(contato);
		this.contato = contato;
	}

	public Contato getContato() {
		return contato;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		verificarNulo(dataNascimento);
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
		verificarNulo(setor);
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		verificarNulo(cargo);
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
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome = ");
		builder.append(nome);
		builder.append(", cpf = ");
		builder.append(cpf);
		builder.append(", contato = ");
		builder.append(contato);
		builder.append(", endereco = ");
		builder.append(endereco);
		builder.append(", dataAdmissao = ");
		builder.append(dataAdmissao);
		builder.append(", dataNascimento = ");
		builder.append(dataNascimento);
		builder.append(", dataDesligamento = ");
		builder.append(dataDesligamento);
		builder.append(", setor = ");
		builder.append(setor);
		builder.append(", cargo = ");
		builder.append(cargo);
		builder.append("]");
		return builder.toString();
	}
}