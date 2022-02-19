package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_DESCRICAO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_DESCRICAO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.util.List;
import java.util.Objects;

public class Setor {

	private String nome;
	
	private List<Funcionario> funcionarios;
	
	private String descricao;
	
	private Empresa empresa;

	public Setor(String nome, List<Funcionario> funcionario, String descricao, Empresa empresa) {
		this.setNome(nome);
		this.setFuncionarios(funcionario);
		this.setDescricao(descricao);
		this.setEmpresa(empresa);
	}
	
	public Setor(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificarObjetoNulo(nome);
		validarCampoVazio(nome);
		limiteCaracteresMinimoMaximo(nome, TAMANHO_MINIMO_NOME, TAMANHO_MAXIMO_NOME);
		validarCaracteresPermitidos(nome, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.nome = nome;
	}

	public List<Funcionario> getFuncionario() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		verificarObjetoNulo(funcionarios);
		validarListaVazia(funcionarios);
		validarTamanhoMaximoLista(funcionarios, TAMANHO_MAXIMO_LISTA_FUNCIONARIO);
		this.funcionarios = funcionarios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		verificarObjetoNulo(descricao);
		validarCampoVazio(descricao);
		limiteCaracteresMinimoMaximo(descricao, TAMANHO_MINIMO_DESCRICAO, TAMANHO_MAXIMO_DESCRICAO);
		validarCaracteresPermitidos(descricao, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.descricao = descricao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		verificarObjetoNulo(empresa);
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Setor)) {
			return false;
		}
		Setor other = (Setor) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Setor [nome=" + nome + ", funcionario=" + funcionarios + ", descricao=" + descricao + ", empresa="
				+ empresa + "]";
	}
	
}
