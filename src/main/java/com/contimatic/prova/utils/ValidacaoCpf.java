package com.contimatic.prova.utils;

import java.util.InputMismatchException;

public final class ValidacaoCpf {
//classe cpnj
	private ValidacaoCpf() {
	}

	public static boolean validarCPF(String Cpf) {
		validarSequencia(Cpf);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0; //numeros magicos, transformar em constantes
			peso = 10; 
			for (i = 0; i < 9; i++) {

				num = (int) (Cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (Cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == Cpf.charAt(9)) && (dig11 == Cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	private static void validarSequencia(String Cpf) {
		if (Cpf.equals("00000000000") || Cpf.equals("11111111111") || Cpf.equals("22222222222")
				|| Cpf.equals("33333333333") || Cpf.equals("44444444444") || Cpf.equals("55555555555")
				|| Cpf.equals("66666666666") || Cpf.equals("77777777777") || Cpf.equals("88888888888")
				|| Cpf.equals("99999999999") || (Cpf.length() != 11)) {
			throw new IllegalStateException("Cpf invalido");
		}

	}

}
