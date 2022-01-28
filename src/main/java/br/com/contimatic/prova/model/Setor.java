package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_ALFANUMERICOS;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_CBO_SETOR;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_DESCRICAO_SETOR;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NOME_SETOR;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_CBO_SETOR;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_DESCRICAO_SETOR;
import static br.com.contimatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NOME_SETOR;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCampoEmBranco;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.util.List;
import java.util.Objects;

public class Setor {

	private String nome;
	
	private String cbo;
	
	private List<Funcionario> funcionario;
	
	private String descricao;
	
	private Empresa empresa;

	public Setor(String nome, String cbo, List<Funcionario> funcionario, String descricao, Empresa empresa) {
		this.setNome(nome);
		this.setCbo(cbo);
		this.setFuncionario(funcionario);
		this.setDescricao(descricao);
		this.setEmpresa(empresa);
	}

	public Setor(String cbo) {
		this.setCbo(cbo);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		verificarObjetoNulo(nome);
		validarCampoEmBranco(nome);
		limiteCaracteresMinimoMaximo(nome, TAMANHO_MINIMO_NOME_SETOR, TAMANHO_MAXIMO_NOME_SETOR);
		validarCaracteresPermitidos(nome, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.nome = nome;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public String getCbo() {
		return cbo;
	}

	public void setCbo(String cbo) {
		verificarObjetoNulo(cbo);
		validarCampoEmBranco(cbo);
		limiteCaracteresMinimoMaximo(cbo, TAMANHO_MINIMO_CBO_SETOR, TAMANHO_MAXIMO_CBO_SETOR);
		validarCaracteresPermitidos(cbo, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL );
		this.cbo = cbo;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		verificarObjetoNulo(funcionario);
		validarListaVazia(funcionario);
		validarTamanhoMaximoLista(funcionario, TAMANHO_MAXIMO_LISTA_FUNCIONARIO);
		this.funcionario = funcionario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		verificarObjetoNulo(descricao);
		validarCampoEmBranco(descricao);
		limiteCaracteresMinimoMaximo(descricao, TAMANHO_MINIMO_DESCRICAO_SETOR, TAMANHO_MAXIMO_DESCRICAO_SETOR);
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
		return Objects.hash(cbo);
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
		return Objects.equals(cbo, other.cbo);
	}

	@Override
	public String toString() {
		return "Setor [nome=" + nome + ", funcionario=" + funcionario + ", descricao=" + descricao + ", empresa="
				+ empresa + "]";
	}
	
}
