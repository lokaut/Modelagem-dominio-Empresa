package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_EMAIL_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static com.contimatic.prova.constantes.Constantes.SALARIO_MINIMO;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidacaoUtils {

	private ValidacaoUtils() {
	}

	public static void verificarObjetoNulo(Object campo) {
		if (campo == null)
			throw new IllegalArgumentException(MENSAGEM_CAMPO_NULO);
	}

	public static void limiteCaracteresFixo(String nome, int tamanho) {
		if  (nome.length() != tamanho) {
			throw new IllegalStateException("Quantidade de carácteres inválido! O campo deve possuir apenas " + tamanho
					+ " caracteres" + ", atualmente o campo possui " + nome.length() + " caractere(s)");
		}

	}
	public static void limiteCaracteresMinimoMaximo(String nome, int minimo, int maximo) {
		if (nome.length() < minimo || nome.length() > maximo) {
			throw new IllegalStateException("Quantidade de carácter inválido, o campo deve estar entre " + minimo
					+ " a " + maximo + " caracteres" + ", atualmente o campo possui " + nome.length());
		}
	}

	public static void validarCampoEmBranco(String nome) {
		if (nome.trim().isBlank()) {
			throw new IllegalStateException(MENSAGEM_CAMPO_VAZIO);
		}
	}

	public static void validarEmail(String email) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches())
			throw new IllegalStateException(MENSAGEM_EMAIL_INVALIDO);
	}

	public static void validarSalarioMinimo(BigDecimal salario) {
		BigDecimal diferencaSalario = salario.subtract(SALARIO_MINIMO);
		if (diferencaSalario.signum() == - 1)
			throw new IllegalStateException(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO);
	}

	public static void validarCaracteresPermitidos(String campo, String regex, String mensagemErro) {
		if (!campo.matches(regex))
			throw new IllegalStateException(mensagemErro);
	}

	public static <T> void validarListaVazia(List<T> lista) {
		if (lista.isEmpty()) {
			throw new IllegalStateException(MENSAGEM_CAMPO_VAZIO);
		}
	}
}
