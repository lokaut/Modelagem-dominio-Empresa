package br.com.contmatic.prova.constantes;

import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Constantes {
	
	private Constantes(){}
	
	/* REGRAS DA EMPRESAS */	
	public static final BigDecimal SALARIO_MINIMO = valueOf(1210.0);
	public static final long IDADE_MINIMA_EMPRESA = 16;
	public static final LocalDate FUNDACAO_EMPRESA = of(1988, 10, 05);
	public static final int REGRA_DATA_ADMISSAO = 2;
	public static final String DATA_ATUAL = now().format(ofPattern("dd/MM/yyyy"));
	
	/* CPF E CNPJ */
	public static final int POSICAO_ZERO_ASCII = 48;
	public static final int MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ = 11;
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
	public static final int QUANTIDADE_NUMEROS_INICIAIS_CPF = 9;
	public static final int QUANTIDADE_NUMEROS_INICIAIS_CNPJ = 8;

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
	public static final String MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS = "CPF não possui 11 caracteres";
	public static final String MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS = "CNPJ não possui 14 caracteres";
	public static final String MENSAGEM_EMAIL_INVALIDO = "Email Inválido";
	public static final String MENSAGEM_CPF_INVALIDO_LETRAS = "CPF deve possuir apenas números";
	public static final String MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO = "O salário não pode ser menor do que um salario mínimo. O salário mínimo é de: " + SALARIO_MINIMO;
	public static final String MENSAGEM_IDADE_MINIMA_EMPRESA = "Idade para admissão tem que ser maior de "+IDADE_MINIMA_EMPRESA+" anos";
	public static final String MENSAGEM_ADMISSAO_FUTURA = "Data admissão é acima de " + REGRA_DATA_ADMISSAO +" meses da data de hoje: " + DATA_ATUAL;
	public static final String MENSAGEM_DESLIGAMENTO_ANTES_DATA_ATUAL = "Data do desligamento não pode ser antes do dia " + DATA_ATUAL;
	public static final String MENSAGEM_DATA_FUTURA = "Data fornecida é inválida";
	public static final String MENSAGEM_DDD_INCORRETO = "DDD precisa conter apenas dois números sem o zero";
	public static final String MENSAGEM_TELEFONE_INCORRETO = "Telefone precisa conter 8 números e celular precisa conter 9 números, sendo que o mesmo começando com 9";
	public static final String MENSAGEM_CELULAR_INCORRETO = "Celular precisa de 9 números";
	public static final String MENSAGEM_NUMERO_EXCEDIDO_LISTA = "Quantidade da lista excedida";
	
	/* REGEX */
	public static final String REGEX_CARACTERES_ALFABETICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";
	public static final String REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ0-9 ]+$";
	public static final String REGEX_ALFANUMERICOS = "^[\\d]+$";
	public static final String REGEX_ALFABETICO_SEM_ACENTO = "^[A-Zaz_]+$";
	public static final String REGEX_DDD = "^([1-9]{2})$";
	public static final String REGEX_TELEFONE = "^9?[0-9]{8}$";
}	
