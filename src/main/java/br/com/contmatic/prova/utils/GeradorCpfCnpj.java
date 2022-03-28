package br.com.contmatic.prova.utils;

import static java.lang.Math.floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.contmatic.prova.constantes.RegrasCpfCnpj;

public class GeradorCpfCnpj {
	private GeradorCpfCnpj() {}

	private static Random random = new Random();

	public static String gerarCpf() {
		List<Integer> noveNumerosGerados = gerarNumerosIniciaisCpfCnpj(RegrasCpfCnpj.QUANTIDADE_NUMEROS_INICIAIS_CPF);
		/*
		 * Os noves primeiros algarismos são ordenadamente multiplicados pela sequência inversamente
		 */
		Integer primeiroDigitoVerificador = noveNumerosGerados.get(8) * 2 + noveNumerosGerados.get(7) * 3
				+ noveNumerosGerados.get(6) * 4 + noveNumerosGerados.get(5) * 5 + noveNumerosGerados.get(4) * 6
				+ noveNumerosGerados.get(3) * 7 + noveNumerosGerados.get(2) * 8 + noveNumerosGerados.get(1) * 9
				+ noveNumerosGerados.get(0) * 10;
		primeiroDigitoVerificador = validarDigitosVerificacao(primeiroDigitoVerificador);
		Integer segundoDigitoVerificador = primeiroDigitoVerificador * 2 + noveNumerosGerados.get(8) * 3
				+ noveNumerosGerados.get(7) * 4 + noveNumerosGerados.get(6) * 5 + noveNumerosGerados.get(5) * 6
				+ noveNumerosGerados.get(4) * 7 + noveNumerosGerados.get(3) * 8 + noveNumerosGerados.get(2) * 9
				+ noveNumerosGerados.get(1) * 10 + noveNumerosGerados.get(0) * 11;

		segundoDigitoVerificador = validarDigitosVerificacao(segundoDigitoVerificador);
		return cpfCnpjBuild(noveNumerosGerados, primeiroDigitoVerificador, segundoDigitoVerificador);
	}

	public static String gerarCnpj() {
		List<Integer> numerosIniciaisGerados = gerarNumerosIniciaisCpfCnpj(RegrasCpfCnpj.QUANTIDADE_NUMEROS_INICIAIS_CNPJ);
		Integer nonoDigito = 0;
		Integer decimoDigito = 0;
		Integer decimoPrimeiroDigito = 0;
		Integer decimoSegundoDigito = 1;

		/* Os oito primeiros algarismos são ordenadamente multiplicados pela sequência inversamente  */
		Integer primeiroDigitoVerificador = decimoSegundoDigito * 2 + decimoPrimeiroDigito * 3 + decimoDigito * 4
				+ nonoDigito * 5 + numerosIniciaisGerados.get(7) * 6 + numerosIniciaisGerados.get(6) * 7
				+ numerosIniciaisGerados.get(5) * 8 + numerosIniciaisGerados.get(4) * 9
				+ numerosIniciaisGerados.get(3) * 2 + numerosIniciaisGerados.get(2) * 3
				+ numerosIniciaisGerados.get(1) * 4 + numerosIniciaisGerados.get(0) * 5;
		primeiroDigitoVerificador = validarDigitosVerificacao(primeiroDigitoVerificador);
		Integer segundoDigitoVerificador = primeiroDigitoVerificador * 2 + decimoSegundoDigito * 3
				+ decimoPrimeiroDigito * 4 + decimoDigito * 5 + nonoDigito * 6 + numerosIniciaisGerados.get(7) * 7
				+ numerosIniciaisGerados.get(6) * 8 + numerosIniciaisGerados.get(5) * 9
				+ numerosIniciaisGerados.get(4) * 2 + numerosIniciaisGerados.get(3) * 3
				+ numerosIniciaisGerados.get(2) * 4 + numerosIniciaisGerados.get(1) * 5
				+ numerosIniciaisGerados.get(0) * 6;

		segundoDigitoVerificador = validarDigitosVerificacao(segundoDigitoVerificador);
		numerosIniciaisGerados.add(nonoDigito);
		numerosIniciaisGerados.add(decimoDigito);
		numerosIniciaisGerados.add(decimoPrimeiroDigito);
		numerosIniciaisGerados.add(decimoSegundoDigito);
		return cpfCnpjBuild(numerosIniciaisGerados, primeiroDigitoVerificador, segundoDigitoVerificador);
	}

	private static List<Integer> gerarNumerosIniciaisCpfCnpj(int quantidadeNumeros) {
		List<Integer> numerosAleatorios = new ArrayList<>();
		int numeroAleatorio;
		for (int i = 0; i < quantidadeNumeros; i++) {
			numeroAleatorio = randomiza();
			numerosAleatorios.add(numeroAleatorio);
		}
		return numerosAleatorios;
	}

	private static Integer randomiza() {
		return random.nextInt(9);
	}

	private static int modificador(int dividendo, double divisor) {
		return (int) Math.round(dividendo - (floor(dividendo / divisor) * divisor));
	}
	
	private static int validarDigitosVerificacao(Integer digitoVerificador) {
		digitoVerificador = RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ - (modificador(digitoVerificador, RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ));

		if (digitoVerificador >= RegrasCpfCnpj.PESO_DEZ_CPF_CNPJ) {
			digitoVerificador = 0;
		}
		return digitoVerificador;
	}
	
	private static String cpfCnpjBuild(List<Integer> numerosIniciais, Integer primeiroDigitoVerificador,	Integer segundoDigitoVerificador) {
		numerosIniciais.add(primeiroDigitoVerificador);
		numerosIniciais.add(segundoDigitoVerificador);
		return removerPontuacaoCpfCnpj(numerosIniciais.toString());
	}

	private static String removerPontuacaoCpfCnpj(String cpfNaoFormatado) {
		return cpfNaoFormatado.replace("[", "").replace(" ", "").replace(",", "").replace("]", "");
	}
}
