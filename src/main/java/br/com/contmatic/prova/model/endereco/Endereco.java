 package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_ALFANUMERICOS;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_FIXO_CEP_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_BAIRRO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_COMPLEMENTO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_LOGRADOURO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_BAIRRO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_COMPLEMENTO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_LOGRADOURO_ENDERECO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_NUMERO_ENDERECO;
import static br.com.contmatic.prova.utils.ValidacaoUtils.campoOpcional;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresFixo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

public class Endereco {
	
	private String logradouro;
	
	//mudar para Integer
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
	
	public Endereco(String logradouro, String numero, String bairro, String complemento, String cep, Cidade cidade) {
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setComplemento(complemento);
		this.setCep(cep);
		this.setCidade(cidade);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		verificarNulo(logradouro);
		validarCampoVazio(logradouro);
		limiteCaracteresMinimoMaximo(logradouro, TAMANHO_MINIMO_LOGRADOURO_ENDERECO, TAMANHO_MAXIMO_LOGRADOURO_ENDERECO);
		validarCaracteresPermitidos(logradouro, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		verificarNulo(numero);
		validarCampoVazio(numero);
		limiteCaracteresMinimoMaximo(numero, TAMANHO_MINIMO_NUMERO_ENDERECO, TAMANHO_MAXIMO_NUMERO_ENDERECO);
		validarCaracteresPermitidos(numero, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		campoOpcional(complemento, TAMANHO_MINIMO_COMPLEMENTO_ENDERECO, TAMANHO_MAXIMO_COMPLEMENTO_ENDERECO);
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		verificarNulo(bairro);
		validarCampoVazio(bairro);
		limiteCaracteresMinimoMaximo(bairro, TAMANHO_MINIMO_BAIRRO_ENDERECO, TAMANHO_MAXIMO_BAIRRO_ENDERECO);
		validarCaracteresPermitidos(bairro, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL);
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		verificarNulo(cep);
		validarCampoVazio(cep);
		limiteCaracteresFixo(cep, TAMANHO_FIXO_CEP_ENDERECO);
		validarCaracteresPermitidos(cep, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.cep = cep;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		verificarNulo(cidade);
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
		return "Endereco [logradouro = " + logradouro + ", numero = " + numero +", complemento = "+ complemento +", bairro = " + bairro + ", cidade = " + cidade + ", cep = " + cep + "]";
	}
}
