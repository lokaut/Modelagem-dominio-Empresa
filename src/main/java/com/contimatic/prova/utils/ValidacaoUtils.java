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

import com.contimatic.prova.constantes.Constantes;

public final class ValidacaoUtils {

	private ValidacaoUtils() {
	}

	public static void verificarCampoNulo(Object campo) {
		if (campo == null)
			throw new IllegalArgumentException(MENSAGEM_CAMPO_NULO);
	}

	public static void limiteCaracteres(String nome, int minimo, int maximo) {
		if (minimo == maximo && nome.length() != minimo) {
			throw new IllegalStateException("Quantidade de carácteres inválido! O campo deve possuir apenas " + minimo
					+ " caracteres" + ", atualmente o campo possui " + nome.length() + " caractere(s)");
		}

		else if (nome.length() < minimo || nome.length() > maximo) {
			throw new IllegalStateException("Quantidade de carácter inválido, o campo deve estar entre " + minimo
					+ " a " + maximo + " caracteres" + ", atualmente o campo possui " + nome.length());
		}
	}

	public static void naoAceitarCampoEmBranco(String nome) {
		if (nome.trim().isBlank()) {
			throw new IllegalStateException(MENSAGEM_CAMPO_VAZIO);
		}
	}
//	public static void naoAceitarCaracterNumerico(String nome) {
//		if (!nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")) {
//			throw new IllegalStateException(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
//		}
//	}

	public static void validarEmail(String email) {
		String expression = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
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
