package com.contimatic.prova.model;

import static com.contimatic.prova.utils.ValidacaoUtils.limiteMaximoCaracter;
import static com.contimatic.prova.utils.ValidacaoUtils.naoAceitarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.validarEmail;
import static com.contimatic.prova.utils.ValidacaoUtils.validarTelefone;
import static com.contimatic.prova.utils.ValidacaoUtils.verificarCampoNulo;

import java.util.Objects;

import com.contimatic.prova.utils.ValidacaoUtils;

public class Contato {
	
	private String email;
	
	private String ddd;
	
	private String telefone;
	
	public  Contato() {}
	
	public Contato(String email, String ddd, String telefone) {
		this.setEmail(email);
		this.setDdd(ddd);
		this.setTelefone(telefone);
	}
	
	public void setEmail(String email) {
		verificarCampoNulo(email);
		naoAceitarCampoEmBranco(email);
		validarEmail(email);
		limiteMaximoCaracter(email, 5, 60);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		verificarCampoNulo(ddd);
		naoAceitarCampoEmBranco(ddd);
		ValidacaoUtils.validarDDD(ddd);
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		verificarCampoNulo(telefone);
		naoAceitarCampoEmBranco(telefone);
		validarTelefone(telefone);
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Contato [E-mail = " + email + ", Telefone = " + ddd  + telefone + "]";
	}
}
