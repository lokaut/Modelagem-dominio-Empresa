package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_ALFABETICO_SEM_ACENTO;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_ALFANUMERICOS;
import static br.com.contmatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_FIXO_CODIGOIBGE;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_FIXO_UNIDADE_FEDERATIVA;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_MUNICIPIO;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_MUNICIPIO;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresFixo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

public class Cidade {

	private String codigoIbge;

	private String municipio;

	private String unidadeFederativa;

	public Cidade(String codigoIbge) {
		this.setCodigoIbge(codigoIbge);
	}

	public Cidade(String codigoIbge, String municipio, String unidadeFederativa) {
		this.setCodigoIbge(codigoIbge);
		this.setMunicipio(municipio);
		this.setUnidadeFederativa(unidadeFederativa);
	}

	public String getCodigoIbge() {
		verificarNulo(codigoIbge);
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		verificarNulo(codigoIbge);
		validarCampoVazio(codigoIbge);
		limiteCaracteresFixo(codigoIbge, TAMANHO_FIXO_CODIGOIBGE);
		validarCaracteresPermitidos(codigoIbge, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.codigoIbge = codigoIbge;
	}

	public String getMunicipio() {
		verificarNulo(municipio);
		return municipio;
	}

	public void setMunicipio(String municipio) {
		verificarNulo(municipio);
		validarCampoVazio(municipio);
		limiteCaracteresMinimoMaximo(municipio, TAMANHO_MINIMO_MUNICIPIO, TAMANHO_MAXIMO_MUNICIPIO);
		validarCaracteresPermitidos(municipio, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.municipio = municipio;
	}

	public String getUnidadeFederativa() {
		verificarNulo(unidadeFederativa);
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(String unidadeFederativa) {
		verificarNulo(unidadeFederativa);
		validarCampoVazio(unidadeFederativa);
		limiteCaracteresFixo(unidadeFederativa, TAMANHO_FIXO_UNIDADE_FEDERATIVA);
		validarCaracteresPermitidos(unidadeFederativa, REGEX_ALFABETICO_SEM_ACENTO, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.unidadeFederativa = unidadeFederativa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIbge);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cidade)) {
			return false;
		}
		Cidade other = (Cidade) obj;
		return Objects.equals(codigoIbge, other.codigoIbge);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cidade [codigoIbge = ");
		builder.append(codigoIbge);
		builder.append(", municipio = ");
		builder.append(municipio);
		builder.append(", unidadeFederativa = ");
		builder.append(unidadeFederativa);
		builder.append("]");
		return builder.toString();
	}
}
