package br.com.contmatic.prova.model.empresa;


import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.Regex;
import br.com.contmatic.prova.constantes.model.FuncionarioConstantes;
import br.com.contmatic.prova.constantes.model.SetorConstantes;

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
		verificarNulo(nome);
		validarCampoVazio(nome);
		limiteCaracteresMinimoMaximo(nome, SetorConstantes.TAMANHO_MINIMO_NOME_SETOR, SetorConstantes.TAMANHO_MAXIMO_NOME_SETOR);
		validarCaracteresPermitidos(nome, Regex.REGEX_CARACTERES_ALFABETICOS_ACENTOS, Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.nome = nome;
	}

	public List<Funcionario> getFuncionario() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		verificarNulo(funcionarios);
		validarListaVazia(funcionarios);
		validarTamanhoMaximoLista(funcionarios, FuncionarioConstantes.TAMANHO_MAXIMO_LISTA_FUNCIONARIO);
		this.funcionarios = funcionarios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		verificarNulo(descricao);
		validarCampoVazio(descricao);
		limiteCaracteresMinimoMaximo(descricao, SetorConstantes.TAMANHO_MINIMO_DESCRICAO, SetorConstantes.TAMANHO_MAXIMO_DESCRICAO);
		validarCaracteresPermitidos(descricao, Regex.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.descricao = descricao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		verificarNulo(empresa);
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
		StringBuilder builder = new StringBuilder();
		builder.append("Setor [nome = ");
		builder.append(nome);
		builder.append(", funcionarios = ");
		builder.append(funcionarios);
		builder.append(", descricao = ");
		builder.append(descricao);
		builder.append(", empresa = ");
		builder.append(empresa);
		builder.append("]");
		return builder.toString();
	}
	
}
