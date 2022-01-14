package com.contimatic.prova.model;

import static com.contimatic.prova.constantes.Constantes.MENSAGEM_DDD_INCORRETO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_TELEFONE_INCORRETO;
import static com.contimatic.prova.constantes.Constantes.REGEX_DDD;
import static com.contimatic.prova.constantes.Constantes.REGEX_TELEFONE;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

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
		verificarObjetoNulo(ddd);
		naoAceitarCampoEmBranco(ddd);
		validarCaracteresPermitidos(ddd, REGEX_DDD, MENSAGEM_DDD_INCORRETO);
		this.ddd = ddd;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		verificarObjetoNulo(numeroTelefone);
		naoAceitarCampoEmBranco(numeroTelefone);
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
		return "Telefone [ddd = " + ddd + ", numeroTelefone = " + numeroTelefone + "]";
	}
}
