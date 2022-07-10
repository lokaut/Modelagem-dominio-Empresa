package br.com.contmatic.prova.constantes;

import br.com.contmatic.prova.constantes.utils.GeradorCpfCnpj;

public class EmpresaConstantes {
   private EmpresaConstantes() {}
   
    public static final String CNPJ_VALIDO = "88592632000132";
    public static final String CNPJ_VALIDO_ALEATORIO = GeradorCpfCnpj.gerarCnpj();
    public static final String RAZAO_SOCIAL = "Empresa Aleatória Comércio Ltda";
    public static final String NOME_FANTASIA = "Empresa Aleatória";
}