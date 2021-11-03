package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CNPJ_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS;
import static com.contimatic.prova.constantes.Constantes.MODULO_DIVISAO_ONZE_CPF_CNPJ;
import static com.contimatic.prova.constantes.Constantes.NUMERO_ZERO_CPF_CNPJ;
import static com.contimatic.prova.constantes.Constantes.PESO_DOZE_CNPJ;
import static com.contimatic.prova.constantes.Constantes.PESO_ONZE_CPF;
import static com.contimatic.prova.constantes.Constantes.POSICAO_ZERO_ASCII;
import static com.contimatic.prova.constantes.Constantes.TAMANHO_CNPJ;

public final class ValidacaoCnpj {
	
	private ValidacaoCnpj(){}

	public static void validarCNPJ(String cnpj) {
		validarTamanho(cnpj);
		validarSequencia(cnpj);
		verificarDigitos(cnpj);
	}
	
	private static void verificarDigitos(String cnpj) {
		char digVerificador13 = primeiroSegundoDigVerificador(cnpj, PESO_ONZE_CPF);
		char digVerificador14 = primeiroSegundoDigVerificador(cnpj, PESO_DOZE_CNPJ);
	      if (!((digVerificador13 == cnpj.charAt(12)) && (digVerificador14 == cnpj.charAt(13)))){ 
	      throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);	
	      }
	}

	private static void validarTamanho(String cnpj) {
		if(cnpj.length() != TAMANHO_CNPJ) {
			 throw new IllegalStateException(MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS);
		}
	}
	
	private static void validarSequencia(String cnpj) {
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
		    cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
		    cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
		    cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
		    cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
			throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);
		}
	}

	private static char primeiroSegundoDigVerificador(String cnpj, int pesoVerificador) {
		int num;
		int soma = 0;
		int peso = 2;
		for (int i = pesoVerificador; i >= 0; i--) {
			num = (cnpj.charAt(i) - POSICAO_ZERO_ASCII);
			soma = soma + (num * peso);
			peso = peso +1;
			if (peso == 10)
				peso = 2;
		}
		return verificarOsDoisDigitoVerificador(soma);
	}

	private static char verificarOsDoisDigitoVerificador(int soma) {
		char digito;
		int resto = soma % MODULO_DIVISAO_ONZE_CPF_CNPJ;
		if ((resto == 0) || (resto == 1))
			digito = NUMERO_ZERO_CPF_CNPJ;
		else
			digito = (char) ((MODULO_DIVISAO_ONZE_CPF_CNPJ - resto) + POSICAO_ZERO_ASCII);

		return digito;
	}
}
