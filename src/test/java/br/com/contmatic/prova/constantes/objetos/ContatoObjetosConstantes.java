package br.com.contmatic.prova.constantes.objetos;

import static br.com.contmatic.prova.constantes.objetos.TelefoneObjetosConstantes.TELEFONE_01;
import static br.com.contmatic.prova.constantes.objetos.TelefoneObjetosConstantes.TELEFONE_02;

import br.com.contmatic.prova.model.contato.Contato;

public class ContatoObjetosConstantes {
    
    public static final String EMAIL = "erick123@gmail.com";
    public static final String EMAIL_SECUNDARIO = "erickemail2@gmail.com";
    public static Contato CONTATO_01 = new Contato(EMAIL, TELEFONE_01);
    public static final Contato CONTATO_02 = new Contato(EMAIL_SECUNDARIO, TELEFONE_02);

}
