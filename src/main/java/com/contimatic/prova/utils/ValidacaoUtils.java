package com.contimatic.prova.utils;

public final class ValidacaoUtils {

	private ValidacaoUtils() {
	}

	public static void verificacaoCampoNulo(Object nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Este campo não pode ser nulo");
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
		if (nome.isBlank()) {
			throw new IllegalStateException("Campo está vazio ou contém apenas espaço em branco");
		}
	}

	public static void naoAceitarCaracterNumerico(String nome) {
		if (!nome.matches("[a-zA-Z_ ]{1,60}")) {
			throw new IllegalStateException("O Campo possui caracter númerico ou caracter especial");
		}
	}

}
