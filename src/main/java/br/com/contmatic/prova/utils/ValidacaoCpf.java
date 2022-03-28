package br.com.contmatic.prova.utils;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.RegrasCpfCnpj;

public final class ValidacaoCpf {

	private ValidacaoCpf(){}

	public static void validarCPF(String cpf) {
		validarTamanho(cpf, RegrasCpfCnpj.TAMANHO_CPF);
		validarSequencia(cpf);
		verificarDigitos(cpf);
	}
	
	private static void validarTamanho(String cpf, int tamanhoCNPJCPF) {
		if(cpf.length() != tamanhoCNPJCPF) {
			 throw new IllegalStateException(Mensagem.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS);
		}
	}

	private static void verificarDigitos(String cpf) {
		char digVerificador10 = primeiroSegundoDigVerificador(cpf, RegrasCpfCnpj.PESO_DEZ_CPF_CNPJ);
		char digVerificador11 = primeiroSegundoDigVerificador(cpf, RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ);
		
		 if (!((digVerificador10 == cpf.charAt(RegrasCpfCnpj.POSICAO_NOVE_CPF)) && (digVerificador11 == cpf.charAt(RegrasCpfCnpj.POSICAO_DEZ_CPF)))) {
			 throw new IllegalStateException(Mensagem.MENSAGEM_CPF_INVALIDO);
		 }
	}

	private static void validarSequencia(String cpf) {
		if ((cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") )) {
			throw new IllegalStateException(Mensagem.MENSAGEM_CPF_INVALIDO);
		}
	}

	private static char primeiroSegundoDigVerificador(String cpf, int pesoVerificador) {
		int num;
		int somaTotal = 0;
		int peso = pesoVerificador;
		for (int i = 0; i < pesoVerificador - 1; i++) {
			num = (cpf.charAt(i) - RegrasCpfCnpj.POSICAO_ZERO_ASCII);
			somaTotal = somaTotal + (num * peso);
			peso--;
		}
		return verificarOsDoisDigitoVerificador(somaTotal);
	}

	private static char verificarOsDoisDigitoVerificador(int somaTotal) {
		char digitoVerificador;
		int resto = RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ - (somaTotal % RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ);
		if (resto == RegrasCpfCnpj.PESO_DEZ_CPF_CNPJ || resto == RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ)
			digitoVerificador = RegrasCpfCnpj.NUMERO_ZERO_CPF_CNPJ;
		else
			digitoVerificador = (char) (resto + RegrasCpfCnpj.POSICAO_ZERO_ASCII);
		
		return digitoVerificador;
	}
}