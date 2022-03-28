package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresFixo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.Regex;
import br.com.contmatic.prova.constantes.model.CidadeConstantes;

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
		limiteCaracteresFixo(codigoIbge, CidadeConstantes.TAMANHO_FIXO_CODIGOIBGE);
		validarCaracteresPermitidos(codigoIbge, Regex.REGEX_ALFANUMERICOS, Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL);
		this.codigoIbge = codigoIbge;
	}

	public String getMunicipio() {
		verificarNulo(municipio);
		return municipio;
	}

	public void setMunicipio(String municipio) {
		verificarNulo(municipio);
		validarCampoVazio(municipio);
		limiteCaracteresMinimoMaximo(municipio, CidadeConstantes.TAMANHO_MINIMO_MUNICIPIO, CidadeConstantes.TAMANHO_MAXIMO_MUNICIPIO);
		validarCaracteresPermitidos(municipio, Regex.REGEX_CARACTERES_ALFABETICOS_ACENTOS, Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		this.municipio = municipio;
	}

	public String getUnidadeFederativa() {
		verificarNulo(unidadeFederativa);
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(String unidadeFederativa) {
		verificarNulo(unidadeFederativa);
		validarCampoVazio(unidadeFederativa);
		limiteCaracteresFixo(unidadeFederativa, CidadeConstantes.TAMANHO_FIXO_UNIDADE_FEDERATIVA);
		validarCaracteresPermitidos(unidadeFederativa, Regex.REGEX_ALFABETICO_SEM_ACENTO, Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
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
