package com.contimatic.prova.model;

import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static com.contimatic.prova.constantes.Constantes.REGEX_ALFABETICO_SEM_ACENTO;
import static com.contimatic.prova.constantes.Constantes.REGEX_ALFANUMERICOS;
import static com.contimatic.prova.constantes.Constantes.REGEX_CARACTERES_ALFABETICOS_E_ESPECIAL;
import static com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteres;
import static com.contimatic.prova.utils.ValidacaoUtils.validarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

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
		verificarObjetoNulo(codigoIbge);
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		verificarObjetoNulo(codigoIbge);
		validarCampoEmBranco(codigoIbge);
		limiteCaracteres(codigoIbge, 7, 7);
		validarCaracteresPermitidos(codigoIbge, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.codigoIbge = codigoIbge;
	}

	public String getMunicipio() {
		verificarObjetoNulo(municipio);
		return municipio;
	}

	public void setMunicipio(String municipio) {
		verificarObjetoNulo(municipio);
		validarCampoEmBranco(municipio);
		limiteCaracteres(municipio, 3, 100);
		validarCaracteresPermitidos(municipio, REGEX_CARACTERES_ALFABETICOS_E_ESPECIAL, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.municipio = municipio;
	}

	public String getUnidadeFederativa() {
		verificarObjetoNulo(unidadeFederativa);
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(String unidadeFederativa) {
		verificarObjetoNulo(unidadeFederativa);
		validarCampoEmBranco(unidadeFederativa);
		limiteCaracteres(unidadeFederativa, 2, 2);
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
		return "Cidade [ codigoIbge = " + codigoIbge + " , municipio = " + municipio + ", uf = " + unidadeFederativa + " ]";
	}

}
