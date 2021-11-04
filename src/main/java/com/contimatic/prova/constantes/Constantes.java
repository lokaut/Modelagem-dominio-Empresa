package com.contimatic.prova.constantes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public  final class Constantes {
	private Constantes(){}
	
	public static final String SESSENTA_DOIS_CARACTERES = "contmatic contmatic contmatic contmatic contmatic contmaticsss";
	public static final String DOIS_CARACTER = "ac";
	public static final String NUMERO_CPF_INVALIDO = "44085620000";
	public static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1100.0);
	public static final long IDADE_MINIMA_EMPRESA = 16;
	public static final LocalDate FUNDACAO_EMPRESA = LocalDate.of(1988, 10, 05);
	public static final int REGRA_DATA_ADMISSAO = 2;
	
	/* CPF E CNPJ */
	public static final int POSICAO_ZERO_ASCII = 48;
	public static final int MODULO_DIVISAO_ONZE_CPF_CNPJ = 11;
	public static final int PESO_DEZ_CPF_CNPJ = 10;
	public static final int PESO_ONZE_CPF = 11;
	public static final int PESO_DOZE_CNPJ = 12;
	public static final int POSICAO_NOVE_CPF = 9;
	public static final int POSICAO_DEZ_CPF = 10;
	public static final int TAMANHO_CPF = 11;
	public static final int TAMANHO_CNPJ = 14;
	public static final char NUMERO_ZERO_CPF_CNPJ = '0';
	public static final String CPF_VALIDO = "90795007809"; //76899070081
	public static final String CPF_TEXTO = "44a764b7f34";
	public static final int POSICAO_DOZE_CNPJ = 12;
	public static final int POSICAO_TREZE_CNPJ = 13;
	public static final String DATA_HOJE = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	/* Mensagens */
	public static final String MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO = "O Campo possui caracter númerico ou caracter especial";
	public static final String MENSAGEM_CAMPO_NULO = "Este campo não pode ser nulo";
	public static final String MENSAGEM_CAMPO_VAZIO = "Campo está vazio ou contém apenas espaço em branco";
	public static final String MENSAGEM_CPF_INVALIDO = "CPF invalido";
	public static final String MENSAGEM_CNPJ_INVALIDO = "CNPJ invalido";
	public static final String MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS = "CPF inválido, pois não possui 11 caracteres";
	public static final String MENSAGEM_EMAIL_INVALIDO = "Email Inválido";
	public static final String MENSAGEM_CPF_INVALIDO_LETRAS = "CPF deve possuir apenas números";
	public static final String MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO = "O salário não pode ser menor do que um salario mínimo. Um salário mínimo é de: " + SALARIO_MINIMO;
	public static final String MENSAGEM_IDADE_MINIMA_EMPRESA = "Idade para admissão tem que ser maior de 16 anos";
	public static final String MENSAGEM_ADMISSAO_FUTURA = "Data admissão é acima de " + REGRA_DATA_ADMISSAO +" meses da data de hoje: " + DATA_HOJE;
	
}
