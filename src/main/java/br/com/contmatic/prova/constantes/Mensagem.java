package br.com.contmatic.prova.constantes;

import static br.com.contmatic.prova.constantes.RegrasEmpresa.DATA_ATUAL;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.IDADE_MINIMA_EMPRESA;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.REGRA_DATA_ADMISSAO;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.SALARIO_MINIMO;

public class Mensagem {
	private Mensagem() {}
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
    public static final String MENSAGEM_IDADE_MINIMA_EMPRESA = "Idade para admissão tem que ser maior de " + IDADE_MINIMA_EMPRESA + " anos";
    public static final String MENSAGEM_ADMISSAO_FUTURA = "Data admissão é acima de " + REGRA_DATA_ADMISSAO + " meses da data de hoje: " + DATA_ATUAL;
    public static final String MENSAGEM_DESLIGAMENTO_ANTES_DATA_ATUAL = "Data do desligamento não pode ser antes do dia " + DATA_ATUAL;
    public static final String MENSAGEM_DATA_FUTURA = "Data fornecida é inválida";
    public static final String MENSAGEM_DDD_INCORRETO = "DDD precisa conter apenas dois números sem o zero";
    public static final String MENSAGEM_TELEFONE_INCORRETO = "Telefone precisa conter 8 números e celular precisa conter 9 números, sendo que o mesmo começando com 9";
    public static final String MENSAGEM_CELULAR_INCORRETO = "Celular precisa de 9 números";
    public static final String MENSAGEM_NUMERO_EXCEDIDO_LISTA = "Quantidade da lista excedida";
    public static final String MENSAGEM_DDI_INCORRETO = "Este DDI não é válido";
    public static final String MENSAGEM_IP_INVALIDO = "Ip é inválido";
    public static final String MENSAGEM_NUMERO_RESIDENCIAL_INVALIDO = "Número da residência não pode ser menor que zero";

}