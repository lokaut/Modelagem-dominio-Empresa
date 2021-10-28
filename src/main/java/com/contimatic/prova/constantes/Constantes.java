package com.contimatic.prova.constantes;

import java.math.BigDecimal;

public  final class Constantes {
	private  Constantes(){}
	//criar uma classe constante do teste unitario
	public static final String SESSENTA_CARACTER = "contmatic contmatic contmatic contmatic contmatic contmaticsss";
	public static final String DOIS_CARACTER = "ac";
	public static final String NUMERO_CPF_INVALIDO = "44085620000";
	public static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1100.0);
	
	/* CPF */
	public static final int POSICAO_ZERO_ASCII = 48;
	public static final int PESO_ONZE_CPF = 11;
	public static final int PESO_DEZ_CPF = 10;
	public static final int POSICAO_NOVE_CPF = 9;
	public static final int POSICAO_DEZ_CPF = 10;
	public static final int TAMANHO_CPF = 11;
	public static final char NUMERO_ZERO_CPF = '0';
	public static final String CPF_VALIDO = "90795007809"; //76899070081
	public static final String CPF_TEXTO = "44a764b7f34";
	
	/* Mensagens */
	public static final String POSSUI_CARACTER_ESPECIAL_NUMERICO = "O Campo possui caracter númerico ou caracter especial";
	public static final String CAMPO_NULO = "Este campo não pode ser nulo";
	public static final String CAMPO_VAZIO = "Campo está vazio ou contém apenas espaço em branco";
	public static final String CPF_INVALIDO = "CPF invalido";
	public static final String CPF_DIFERENTE_ONZE_NUMEROS = "CPF inválido, pois não possui 11 caracteres";
	public static final String EMAIL_INVALIDO = "Email Inválido";
	public static final String CPF_INVALIDO_LETRAS = "CPF deve possuir apenas números";
	public static final String SALARIO_MENOR_SALARIO_MINIMO = "O salário não pode ser menor do que um salario mínimo. Um salário mínimo é de: " + SALARIO_MINIMO;
}
