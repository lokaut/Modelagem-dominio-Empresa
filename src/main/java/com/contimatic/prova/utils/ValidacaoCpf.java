package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.CPF_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.CPF_DIFERENTE_ONZE_NUMEROS;
import static com.contimatic.prova.constantes.Constantes.NUMERO_ZERO_CPF;
import static com.contimatic.prova.constantes.Constantes.PESO_DEZ_CPF;
import static com.contimatic.prova.constantes.Constantes.PESO_ONZE_CPF;
import static com.contimatic.prova.constantes.Constantes.POSICAO_DEZ_CPF;
import static com.contimatic.prova.constantes.Constantes.POSICAO_NOVE_CPF;
import static com.contimatic.prova.constantes.Constantes.POSICAO_ZERO_ASCII;
import static com.contimatic.prova.constantes.Constantes.TAMANHO_CPF;

public final class ValidacaoCpf {
	
	

	private  ValidacaoCpf(){}

	public static void validarCPF(String cpf) {
		validarTamanho(cpf);
		validarSequencia(cpf);
		verificarDigitos(cpf);
	}

	private static void validarTamanho(String cpf) {
		if(cpf.length() != TAMANHO_CPF) {
			 throw new IllegalStateException(CPF_DIFERENTE_ONZE_NUMEROS);
		}
	}

	private static void verificarDigitos(String cpf) {
		char digVerificador10 = primeiroSegundoDigVerificador(cpf, PESO_DEZ_CPF);
		char digVerificador11 = primeiroSegundoDigVerificador(cpf, PESO_ONZE_CPF);
		
		 if (!((digVerificador10 == cpf.charAt(POSICAO_NOVE_CPF)) && (digVerificador11 == cpf.charAt(POSICAO_DEZ_CPF)))) {
			 throw new IllegalStateException(CPF_INVALIDO);
		 }
	}

	private static void validarSequencia(String cpf) {
		if ((cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") )) {
			throw new IllegalStateException(CPF_INVALIDO);
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
		if (resto == PESO_DEZ_CPF || resto == PESO_ONZE_CPF)
			digitoVerificador = NUMERO_ZERO_CPF;
		else
			digitoVerificador = (char) (resto + POSICAO_ZERO_ASCII);
		
		return digitoVerificador;
	}
}