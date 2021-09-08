package com.contimatic.prova.utils;

public final class ValidacaoUtils {

	private ValidacaoUtils() {
	}

	public static void campoNulo(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("campo não pode ser nulo");
		}
	}
}
