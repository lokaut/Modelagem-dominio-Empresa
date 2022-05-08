package br.com.contmatic.prova.model.contato;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DDD_INCORRETO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_TELEFONE_INCORRETO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_DDD;
import static br.com.contmatic.prova.constantes.Regex.REGEX_TELEFONE;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;


public class Telefone {
	
	private String ddd;
	
	private String numeroTelefone;
	
	public Telefone(String ddd, String numeroTelefone) {
		this.setDdd(ddd);
		this.setNumeroTelefone(numeroTelefone);
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		verificarNulo(ddd);
		validarCampoVazio(ddd);
		validarCaracteresPermitidos(ddd, REGEX_DDD, MENSAGEM_DDD_INCORRETO);
		this.ddd = ddd;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		verificarNulo(numeroTelefone);
		validarCampoVazio(numeroTelefone);
		validarCaracteresPermitidos(numeroTelefone, REGEX_TELEFONE, MENSAGEM_TELEFONE_INCORRETO);
		this.numeroTelefone = numeroTelefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, numeroTelefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Telefone)) {
			return false;
		}
		Telefone outro = (Telefone) obj;
		return Objects.equals(ddd, outro.ddd) && Objects.equals(numeroTelefone, outro.numeroTelefone);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [ddd = ");
		builder.append(ddd);
		builder.append(", numeroTelefone = ");
		builder.append(numeroTelefone);
		builder.append("]");
		return builder.toString();
	}

}
