package com.contimatic.prova.model;

import static com.contimatic.prova.utils.ValidacaoUtils.limiteCaracteres;
import static com.contimatic.prova.utils.ValidacaoUtils.validarCampoEmBranco;
import static com.contimatic.prova.utils.ValidacaoUtils.validarEmail;
import static com.contimatic.prova.utils.ValidacaoUtils.verificarObjetoNulo;

import java.util.Objects;

public class Contato {

	private String email;

	private Telefone telefone;

	public Contato(String email, Telefone telefone) {
		this.setEmail(email);
		this.setTelefone(telefone);
	}
	
	public Contato(String email) {
		this.setEmail(email);
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		verificarObjetoNulo(telefone);
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificarObjetoNulo(email);
		validarCampoEmBranco(email);
		limiteCaracteres(email, 4, 254);
		validarEmail(email);
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contato))
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "Contato [email=" + email + ", telefone=" + telefone + "]";
	}
}
