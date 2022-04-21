package br.com.contmatic.prova.constantes.objetos;

import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.contato.Telefone;

public class ContatoObjetosConstantes {/*	CONTATO	*/
    public static final String EMAIL = "erick123@gmail.com";
    public static final String EMAIL_SECUNDARIO = "erickemail2@gmail.com";
    public static Contato CONTATO_01;
    public static final Contato CONTATO_02 = new Contato(EMAIL_SECUNDARIO);

    public ContatoObjetosConstantes() {
        this.CONTATO_01 = new Contato(EMAIL, (new Telefone(TelefoneObjetosConstantes.DDD_CEARA, TelefoneObjetosConstantes.NUMERO_TELEFONE)));
    }
}