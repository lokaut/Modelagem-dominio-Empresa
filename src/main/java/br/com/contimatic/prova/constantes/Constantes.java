package br.com.contimatic.prova.constantes;

import static java.time.LocalDate.now;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Constantes {
	private Constantes(){}
	
	/* REGRA DE NEGOCIO */	
	public static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1210.0);
	public static final long IDADE_MINIMA_EMPRESA = 16;
	public static final LocalDate FUNDACAO_EMPRESA = LocalDate.of(1988, 10, 05);
	public static final int REGRA_DATA_ADMISSAO = 2;
	public static final String DATA_HOJE = now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	/*Classe Cidade */
	public static final String CODIGO_IBGE_SAO_PAULO = "3550308";
	
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

	public static final int POSICAO_DOZE_CNPJ = 12;
	public static final int POSICAO_TREZE_CNPJ = 13;

	/* MENSAGENS */
	public static final String MENSAGEM_POSSUI_CARACTER_NUMERICO = "O Campo possui caracter númerico";
	public static final String MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO = "O Campo possui caracter númerico ou caracter especial";
	public static final String MENSAGEM_POSSUI_CARACTER_ALFABETICO = "O Campo possui caracter alfabético";
	public static final String MENSAGEM_POSSUI_CARACTER_ESPECIAL = "O Campo possui caracter especial";
	public static final String MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL = "O Campo possui caracter alfabético ou caracter especial";
	public static final String MENSAGEM_CAMPO_NULO = "Este campo não pode ser nulo";
	public static final String MENSAGEM_CAMPO_VAZIO = "Campo está vazio ou contém apenas espaço em branco";
	public static final String MENSAGEM_CPF_INVALIDO = "CPF inválido";
	public static final String MENSAGEM_CNPJ_INVALIDO = "CNPJ inválido";
	public static final String MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS = "CPF inválido, pois não possui 11 caracteres";
	public static final String MENSAGEM_EMAIL_INVALIDO = "Email Inválido";
	public static final String MENSAGEM_CPF_INVALIDO_LETRAS = "CPF deve possuir apenas números";
	public static final String MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO = "O salário não pode ser menor do que um salario mínimo. Um salário mínimo é de: " + SALARIO_MINIMO;
	public static final String MENSAGEM_IDADE_MINIMA_EMPRESA = "Idade para admissão tem que ser maior de 16 anos";
	public static final String MENSAGEM_ADMISSAO_FUTURA = "Data admissão é acima de " + REGRA_DATA_ADMISSAO +" meses da data de hoje: " + DATA_HOJE;
	public static final String MENSAGEM_DDD_INCORRETO = "DDD precisa conter apenas dois números sem o zero";
	public static final String MENSAGEM_TELEFONE_INCORRETO = "Telefone precisa conter 8 números e celular precisa conter 9 números, sendo que o mesmo começando com 9";
	public static final String MENSAGEM_CELULAR_INCORRETO = "Celular precisa de 9 números";
	
	/* REGEX */
	public static final String REGEX_CARACTERES_ALFABETICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";
	public static final String REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ0-9 ]+$";
	public static final String REGEX_ALFANUMERICOS = "^[\\d]+$";
	public static final String REGEX_ALFABETICO_SEM_ACENTO = "^[A-Zaz_]+$";
	public static final String REGEX_DDD = "^([1-9]{2})$";
	public static final String REGEX_TELEFONE = "^9?[0-9]{8}$";
}	
