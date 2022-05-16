package br.com.contmatic.prova.constantes.objetos;

import br.com.contmatic.prova.model.empresa.Setor;

public class SetorObjetosConstantes {
    
    public static final String NOME_SETOR = "Tecnologia da Informação";
    public static final String NOME_SETOR_RH = "Recursos Humanos";
    public static final String DESCRICAO_SETOR = "Setor resposável pela parte tecnológica da empresa";
    public static final Setor SETOR_01 = new Setor(NOME_SETOR);
    public static final Setor SETOR_02 = new Setor(NOME_SETOR_RH);
    
}