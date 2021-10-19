package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.PESO_DEZ_CPF;
import static com.contimatic.prova.constantes.Constantes.PESO_ONZE_CPF;
import static com.contimatic.prova.constantes.Constantes.POSICAO_ZERO_ASCII;

public final class ValidacaoCpf {
	
	private  ValidacaoCpf(){}

	public static boolean validarCPF(String cpf) {
		validarSequencia(cpf);
		char digVerificador10 = primeiroSegundoDigVerificador(cpf, PESO_DEZ_CPF);
		char digVerificador11 = primeiroSegundoDigVerificador(cpf, PESO_ONZE_CPF);
		return (digVerificador10 == cpf.charAt(9)) && (digVerificador11 == cpf.charAt(10));
	}

	private static void validarSequencia(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11)) {
			throw new IllegalStateException("Cpf invalido");
		}
	}

	private static char primeiroSegundoDigVerificador(String cpf, int pesoVerificador) {
		int num;
		int somaTotal = 0;
		int peso = pesoVerificador;
		for (int i = 0; i < pesoVerificador - 1; i++) {
			num = (cpf.charAt(i) - POSICAO_ZERO_ASCII);
			somaTotal = somaTotal + (num * peso);
			peso--;
		}
		return verificarOsDoisDigitoVerificador(somaTotal);
	}

	private static char verificarOsDoisDigitoVerificador(int somaTotal) {
		char digitoVerificador;
		int resto = PESO_ONZE_CPF - (somaTotal % PESO_ONZE_CPF);
		if ((resto == PESO_DEZ_CPF) || (resto == PESO_ONZE_CPF))
			digitoVerificador = '0';
		else
			digitoVerificador = (char) (resto + POSICAO_ZERO_ASCII);
		return digitoVerificador;
	}
}