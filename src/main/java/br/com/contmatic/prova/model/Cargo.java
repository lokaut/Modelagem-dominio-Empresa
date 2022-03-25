package br.com.contmatic.prova.model;

import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_ALFANUMERICOS;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_CBO_CARGO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_DESCRICAO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_CARGO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_CBO_CARGO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_DESCRICAO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_CARGO;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarSalarioMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Cargo {

	private String nome;

	private String cbo;
	
	private BigDecimal salario;
	
	private List<Funcionario> funcionarios;

	private String descricao;
	
	public Cargo(String cbo) {
		this.setCbo(cbo);
	}

	public Cargo(String nome, String cbo, BigDecimal salario, String descricao, List<Funcionario> funcionarios) {
		this.setNome(nome);
		this.setCbo(cbo);
		this.setSalario(salario);
		this.setDescricao(descricao);
		this.setFuncionarios(funcionarios);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificarNulo(nome);
		validarCampoVazio(nome);
		limiteCaracteresMinimoMaximo(nome, TAMANHO_MINIMO_NOME_CARGO, TAMANHO_MAXIMO_NOME_CARGO);
		this.nome = nome;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		verificarNulo(salario);
		validarSalarioMinimo(salario);
		this.salario = salario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		verificarNulo(funcionarios);
		validarListaVazia(funcionarios);
		validarTamanhoMaximoLista(funcionarios, TAMANHO_MAXIMO_LISTA_FUNCIONARIO);
		this.funcionarios = funcionarios;
	}

	public String getCbo() {
		return cbo;
	}

	public void setCbo(String cbo) {
		verificarNulo(cbo);
		validarCampoVazio(cbo);
		limiteCaracteresMinimoMaximo(cbo, TAMANHO_MINIMO_CBO_CARGO, TAMANHO_MAXIMO_CBO_CARGO);
		validarCaracteresPermitidos(cbo, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL );
		this.cbo = cbo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		verificarNulo(descricao);
		validarCampoVazio(descricao);
		limiteCaracteresMinimoMaximo(descricao, TAMANHO_MINIMO_DESCRICAO, TAMANHO_MAXIMO_DESCRICAO);
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cbo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cargo)) {
			return false;
		}
		Cargo outro = (Cargo) obj;
		return Objects.equals(cbo, outro.cbo);
	}

	@Override
	public String toString() {
		return "Cargo [Nome do cargo  = " + nome + ", Cbo = " + cbo + ", Salário = " + salario + ", Descrição = " + descricao + ", Funcionarios = " + funcionarios + "]";
	}
	
}
