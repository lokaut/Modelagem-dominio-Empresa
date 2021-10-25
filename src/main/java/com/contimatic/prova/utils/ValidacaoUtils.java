package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static com.contimatic.prova.constantes.Constantes.CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.EMAIL_INVALIDO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidacaoUtils {

	private ValidacaoUtils() {}

	public static void verificarCampoNulo(Object nome) {
		if (nome == null) {
			throw new IllegalArgumentException(CAMPO_NULO);
		}
	}

	public static void limiteMaximoCaracter(String nome, int minimo, int maximo) {
		if (nome.length() < minimo || nome.length() > maximo) {
			throw new IllegalStateException(
					"Quantidade de carácter inválido, o campo deve estar entre "+ minimo + " a " + maximo + " caracteres"
							+ ", atualmente o campo possui " + nome.length());
		}
	}

	public static void naoAceitarCampoEmBranco(String nome) {
		if (nome.trim().isBlank()) {
			throw new IllegalStateException(CAMPO_VAZIO);
		}
	}

	public static void naoAceitarCaracterNumerico(String nome) {
		if (!nome.matches("[a-zA-Z_ ]{1,60}")) {
			throw new IllegalStateException(POSSUI_CARACTER_ESPECIAL_NUMERICO);
		}
	}
	
	public static void validarEmail(String email) {
			String expression = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (!matcher.matches()) {
				throw new IllegalStateException(EMAIL_INVALIDO);
			}
	}
}
