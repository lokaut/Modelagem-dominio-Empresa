 package br.com.contimatic.prova.model;

import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_ALFANUMERICOS;
import static br.com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_FIXO_CEP;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_MAXIMO_BAIRRO;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_MAXIMO_LOGRADOURO;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_MAXIMO_NUMERO_ENDERECO;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_MINIMO_BAIRRO;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_MINIMO_LOGRADOURO;
import static br.com.contimatic.prova.constantes.ContantesRegrasNegocio.TAMANHO_MINIMO_NUMERO_ENDERECO;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresFixo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCampoEmBranco;
import static br.com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.util.Objects;

public class Endereco {
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;

	private Cidade cidade; 
	
	
	public Endereco(String cep, String numero) {
		this.setCep(cep);
		this.setNumero(numero);
	}
	
	public Endereco(String logradouro, String numero, String bairro, String cep, Cidade cidade) {
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setCidade(cidade);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		verificarObjetoNulo(logradouro);
		validarCampoEmBranco(logradouro);
		limiteCaracteresMinimoMaximo(logradouro, TAMANHO_MINIMO_LOGRADOURO, TAMANHO_MAXIMO_LOGRADOURO);
		validarCaracteresPermitidos(logradouro, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		verificarObjetoNulo(numero);
		validarCampoEmBranco(numero);
		limiteCaracteresMinimoMaximo(numero, TAMANHO_MINIMO_NUMERO_ENDERECO, TAMANHO_MAXIMO_NUMERO_ENDERECO);
		validarCaracteresPermitidos(numero, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		verificarObjetoNulo(bairro);
		validarCampoEmBranco(bairro);
		limiteCaracteresMinimoMaximo(bairro, TAMANHO_MINIMO_BAIRRO, TAMANHO_MAXIMO_BAIRRO);
		validarCaracteresPermitidos(bairro, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		verificarObjetoNulo(cep);
		validarCampoEmBranco(cep);
		limiteCaracteresFixo(cep, TAMANHO_FIXO_CEP);
		validarCaracteresPermitidos(cep, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.cep = cep;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		verificarObjetoNulo(cidade);
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}
	
	@Override
	public String toString() {
		return "Endereco [logradouro = " + logradouro + ", numero = " + numero + ", bairro = " + bairro + ", cidade = " + cidade + ", cep = " + cep + "]";
	}
}
