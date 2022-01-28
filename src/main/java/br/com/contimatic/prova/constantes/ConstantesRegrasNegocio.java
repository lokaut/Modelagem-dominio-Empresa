package br.com.contimatic.prova.constantes;

public final class ConstantesRegrasNegocio {
	
	private ConstantesRegrasNegocio() {}
	
	/* CIDADE */
	public static final Integer TAMANHO_FIXO_CODIGOIBGE = 7;
	public static final Integer TAMANHO_FIXO_UNIDADE_FEDERATIVA = 2;
	public static final Integer TAMANHO_MINIMO_MUNICIPIO = 3;
	public static final Integer TAMANHO_MAXIMO_MUNICIPIO = 100;
	
	/*CONTATO */
	public static final Integer TAMANHO_MINIMO_EMAIL = 4;
	public static final Integer TAMANHO_MAXIMO_EMAIL = 254;
	
	/* ENDERECO */
	public static final Integer TAMANHO_MINIMO_LOGRADOURO_ENDERECO = 1;
	public static final Integer TAMANHO_MAXIMO_LOGRADOURO_ENDERECO = 60;
	public static final Integer TAMANHO_FIXO_CEP_ENDERECO = 8;
	public static final Integer TAMANHO_MINIMO_NUMERO_ENDERECO = 1;
	public static final Integer TAMANHO_MAXIMO_NUMERO_ENDERECO = 20;
	public static final Integer TAMANHO_MINIMO_BAIRRO_ENDERECO = 1;
	public static final Integer TAMANHO_MAXIMO_BAIRRO_ENDERECO = 60;
	public static final Integer TAMANHO_MINIMO_COMPLEMENTO_ENDERECO = 0;
	public static final Integer TAMANHO_MAXIMO_COMPLEMENTO_ENDERECO = 254;
	
	/* FUNCIONARIO */
	public static final Integer TAMANHO_MINIMO_NOME_FUNCIONARIO = 3;
	public static final Integer TAMANHO_MAXIMO_NOME_FUNCIONARIO = 60;
	
	/* SETOR */
	public static final Integer TAMANHO_MINIMO_NOME_SETOR = 3;
	public static final Integer TAMANHO_MAXIMO_NOME_SETOR = 60;
	public static final Integer TAMANHO_MINIMO_CBO_SETOR = 1;
	public static final Integer TAMANHO_MAXIMO_CBO_SETOR = 8;
	public static final Integer TAMANHO_MAXIMO_LISTA_FUNCIONARIO = 999;
	public static final Integer TAMANHO_MINIMO_DESCRICAO_SETOR = 3;
	public static final Integer TAMANHO_MAXIMO_DESCRICAO_SETOR = 254;
}
