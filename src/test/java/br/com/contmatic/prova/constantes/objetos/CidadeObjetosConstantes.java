package br.com.contmatic.prova.constantes.objetos;

import br.com.contmatic.prova.model.endereco.Cidade;

public class CidadeObjetosConstantes {
    public static final String CODIGO_IBGE_SAO_PAULO = "3550308";
    public static final String CODIGO_IBGE_PINDAMONHANGABA = "3538006";
    public static final String MUNICIPIO_SAO_PAULO = "São Paulo";
    public static final String MUNICIPIO_PINDAMONHANGABA = "Pindamonhangaba";
    public static final String UNIDADE_FEDERATIVA_SP = "SP";
    public static final Cidade CIDADE = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP);
    public static final Cidade CIDADE_02 = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_PINDAMONHANGABA, UNIDADE_FEDERATIVA_SP);
}