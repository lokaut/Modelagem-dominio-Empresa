package com.contimatic.prova.utils;

public final class ValidacaoUtils {

	private ValidacaoUtils() {
	}

	public static void verificacaoCampoNulo(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Este campo não pode ser nulo");
		}
	}

	public static void maximoSessentaCaracter(String nome) {
		if ((nome.length() < 3 || nome.length() > 60)) {
			throw new IllegalStateException(
					// deixar mensagem mais generico
					"Quantidade de carácter inválido, o campo deve estar entre 3 a 60 caracteres");
		}
	}

	public static void naoAceitarCampoEmBranco(String nome) {
		if (nome.isBlank()) {
			throw new IllegalArgumentException("campo nome não pode ter caracter com espaço");
		}
	}

	public static void naoAceitarCaracterNumerico(String nome) {
		if (!nome.matches("[a-zA-Z_ ]{1,60}")) {
			throw new IllegalStateException("O Campo Nome possui caracter númerico ou caracter especial");
		}
	}


}
