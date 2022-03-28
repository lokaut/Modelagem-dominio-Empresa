package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.utils.ValidacaoCnpj.validarCNPJ;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDataMaiorDataAtual;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.Regex;
import br.com.contmatic.prova.constantes.model.ContatoConstantes;
import br.com.contmatic.prova.constantes.model.EmpresaConstantes;
import br.com.contmatic.prova.constantes.model.EnderecoConstantes;
import br.com.contmatic.prova.constantes.model.SetorConstantes;
import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.endereco.Endereco;

public class Empresa {
	
	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private LocalDate dataFundacao;
	
	private List<Setor> setores; 
	
	private List<Contato> contatos;
	
	private List<Endereco> enderecos;
	
	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}
	
	public Empresa(String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataFundacao, List<Setor> setores,
			List<Contato> contatos, List<Endereco> enderecos) {
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
		this.setNomeFantasia(nomeFantasia);
		this.setDataFundacao(dataFundacao);
		this.setSetores(setores);
		this.setContatos(contatos);
		this.setEnderecos(enderecos);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		verificarNulo(cnpj);
		validarCNPJ(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		verificarNulo(razaoSocial);
		validarCampoVazio(razaoSocial);
		limiteCaracteresMinimoMaximo(razaoSocial, EmpresaConstantes.TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA, EmpresaConstantes.TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA);
		validarCaracteresPermitidos(razaoSocial, Regex.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		verificarNulo(nomeFantasia);
		validarCampoVazio(nomeFantasia);
		limiteCaracteresMinimoMaximo(nomeFantasia, EmpresaConstantes.TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA, EmpresaConstantes.TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA);
		validarCaracteresPermitidos(nomeFantasia, Regex.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		verificarNulo(dataFundacao);
		validarDataMaiorDataAtual(dataFundacao);
		this.dataFundacao = dataFundacao;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		verificarNulo(setores);
		validarListaVazia(setores);
		validarTamanhoMaximoLista(setores, SetorConstantes.TAMANHO_MAXIMO_LISTA_SETORES);
		this.setores = setores;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		verificarNulo(contatos);
		validarListaVazia(contatos);
		validarTamanhoMaximoLista(contatos, ContatoConstantes.TAMANHO_MAXIMO_LISTA_CONTATOS);
		this.contatos = contatos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		verificarNulo(enderecos);
		validarListaVazia(enderecos);
		validarTamanhoMaximoLista(enderecos, EnderecoConstantes.TAMANHO_MAXIMO_LISTA_ENDERECOS);
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empresa [cnpj = ");
		builder.append(cnpj);
		builder.append(", razaoSocial = ");
		builder.append(razaoSocial);
		builder.append(", nomeFantasia = ");
		builder.append(nomeFantasia);
		builder.append(", dataFundacao = ");
		builder.append(dataFundacao);
		builder.append(", setores = ");
		builder.append(setores);
		builder.append(", contatos = ");
		builder.append(contatos);
		builder.append(", enderecos = ");
		builder.append(enderecos);
		builder.append("]");
		return builder.toString();
	}

}
