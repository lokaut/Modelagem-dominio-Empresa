package br.com.contmatic.prova.utils;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CPF_INVALIDO;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.NUMERO_ZERO_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.PESO_DEZ_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.POSICAO_DEZ_CPF;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.POSICAO_NOVE_CPF;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.POSICAO_ZERO_ASCII;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.TAMANHO_CPF;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresRepetidos;

public final class ValidacaoCpf {

	private ValidacaoCpf(){}

	public static void validarCPF(String cpf) {
		validarTamanho(cpf, TAMANHO_CPF);
		validarSequencia(cpf);
		verificarDigitos(cpf);
	}
	
	private static void validarTamanho(String cpf, int tamanhoCNPJCPF) {
		if(cpf.length() != tamanhoCNPJCPF) {
			 throw new IllegalStateException(MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS);
		}
	}

	private static void verificarDigitos(String cpf) {
		char digVerificador10 = primeiroSegundoDigVerificador(cpf, PESO_DEZ_CPF_CNPJ);
		char digVerificador11 = primeiroSegundoDigVerificador(cpf, MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ);
		
		 if (!((digVerificador10 == cpf.charAt(POSICAO_NOVE_CPF)) && (digVerificador11 == cpf.charAt(POSICAO_DEZ_CPF)))) {
			 throw new IllegalStateException(MENSAGEM_CPF_INVALIDO);
		 }
	}

	private static void validarSequencia(String cpf) {
		if (validarCaracteresRepetidos(cpf)) {
			throw new IllegalStateException(MENSAGEM_CPF_INVALIDO);
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
		int resto = MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ - (somaTotal % MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ);
		if (resto == PESO_DEZ_CPF_CNPJ || resto == MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ)
			digitoVerificador = NUMERO_ZERO_CPF_CNPJ;
		else
			digitoVerificador = (char) (resto + POSICAO_ZERO_ASCII);
		
		return digitoVerificador;
	}
}