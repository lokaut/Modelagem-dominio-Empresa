package br.com.contmatic.prova.constantes.objetos;

import br.com.contmatic.prova.model.contato.Telefone;

public class TelefoneObjetosConstantes {
    public static final String DDD_CEARA = "85";
    public static final String DDD_SAO_PAULO = "11";
    public static final String NUMERO_TELEFONE = "56668057";
    public static final String NUMERO_CELULAR = "956634577";
    public static final Telefone TELEFONE_01 = gerarCelularDefault();
    public static final Telefone TELEFONE_02 = gerarTelefone();

    private static Telefone gerarCelularDefault() {
        return new Telefone(DDD_SAO_PAULO, NUMERO_CELULAR);
    }

    private static Telefone gerarTelefone() {
        return new Telefone(DDD_CEARA, NUMERO_TELEFONE);
    }
}
