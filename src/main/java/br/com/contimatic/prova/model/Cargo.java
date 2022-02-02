package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_CBO_CARGO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_DESCRICAO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_CBO_CARGO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_DESCRICAO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarSalarioMinimo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

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

	public Cargo(String nome, String cbo, BigDecimal salario, String descricao) {
		this.setNome(nome);
		this.setCbo(cbo);
		this.setSalario(salario);
		this.setDescricao(descricao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificarObjetoNulo(nome);
		validarCampoVazio(nome);
		limiteCaracteresMinimoMaximo(nome, TAMANHO_MINIMO_NOME, TAMANHO_MAXIMO_NOME);
		this.nome = nome;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		verificarObjetoNulo(salario);
		validarSalarioMinimo(salario);
		this.salario = salario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		validarListaVazia(funcionarios);
		validarTamanhoMaximoLista(funcionarios, TAMANHO_MAXIMO_LISTA_FUNCIONARIO);
		this.funcionarios = funcionarios;
	}

	public String getCbo() {
		return cbo;
	}

	public void setCbo(String cbo) {
		verificarObjetoNulo(cbo);
		validarCampoVazio(cbo);
		limiteCaracteresMinimoMaximo(cbo, TAMANHO_MINIMO_CBO_CARGO, TAMANHO_MAXIMO_CBO_CARGO);
		this.cbo = cbo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		verificarObjetoNulo(descricao);
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
		Cargo other = (Cargo) obj;
		return Objects.equals(cbo, other.cbo);
	}

	@Override
	public String toString() {
		return "Cargo [nome = " + nome + ", cbo = " + cbo + ", salário = " + salario + ", descrição = " + descricao + "]";
	}
	
}
