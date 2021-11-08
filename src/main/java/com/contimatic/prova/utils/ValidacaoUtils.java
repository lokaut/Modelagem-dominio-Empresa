package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_ADMISSAO_FUTURA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_EMAIL_INVALIDO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static com.contimatic.prova.constantes.Constantes.REGRA_DATA_ADMISSAO;
import static com.contimatic.prova.constantes.Constantes.SALARIO_MINIMO;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidacaoUtils {

	private ValidacaoUtils() {}

	public static void verificarCampoNulo(Object nome) {
		if (nome == null) {
			throw new IllegalArgumentException(MENSAGEM_CAMPO_NULO);
		}
	}

	public static void limiteMaximoCaracter(String nome, int minimo, int maximo) {
		if (nome.length() < minimo || nome.length() > maximo) {
			throw new IllegalStateException(
					"Quantidade de carácter inválido, o campo deve estar entre "+ minimo + " a " + maximo + " caracteres"
							+ ", atualmente o campo possui " + nome.length());
		}
	}

	public static void naoAceitarCampoEmBranco(String nome) {
		if (nome.trim().isBlank()) {
			throw new IllegalStateException(MENSAGEM_CAMPO_VAZIO);
		}
	}

	public static void naoAceitarCaracterNumerico(String nome) {
		if (!nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")) {
			throw new IllegalStateException(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO);
		}
	}
	
	public static void validarEmail(String email) {
			String expression = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (!matcher.matches()) {
				throw new IllegalStateException(MENSAGEM_EMAIL_INVALIDO);
			}
	}
	
	public static void validarSalarioMinimo(BigDecimal salario) {
		BigDecimal diferencaSalario = salario.subtract(SALARIO_MINIMO);
		if (diferencaSalario.signum() == - 1) {
			throw new IllegalStateException(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO);
		}
	}
	
	public static void dataNascMaiorIdade(LocalDate idade) {
		long anos = ChronoUnit.YEARS.between(idade, LocalDate.now());
		
		if(anos < IDADE_MINIMA_EMPRESA) {
			throw new IllegalStateException(MENSAGEM_IDADE_MINIMA_EMPRESA);
		}
	}
	
	public static void validacaoDataAdmissao(LocalDate dataAdmissao){
		if(dataAdmissao.isAfter(LocalDate.now().plusMonths(REGRA_DATA_ADMISSAO))) {
			throw new IllegalArgumentException(MENSAGEM_ADMISSAO_FUTURA);
		}
	}
}
