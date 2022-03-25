package br.com.contmatic.prova.model;

import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova.constantes.ConstantesRegrasNegocio.TAMANHO_MINIMO_EMAIL;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEmail;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

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
		verificarNulo(telefone);
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		verificarNulo(email);
		validarCampoVazio(email);
		limiteCaracteresMinimoMaximo(email, TAMANHO_MINIMO_EMAIL, TAMANHO_MAXIMO_EMAIL);
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