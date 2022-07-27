package br.com.contmatic.prova.model.contato;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DDD_INCORRETO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DDI_INCORRETO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_TELEFONE_INCORRETO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_DDD;
import static br.com.contmatic.prova.constantes.Regex.REGEX_DDI;
import static br.com.contmatic.prova.constantes.Regex.REGEX_TELEFONE;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Telefone extends Auditoria {

    private String ddi;

    private String ddd;

    private String numero;

    public Telefone(String ddi, String ddd, String numero) {
        this.setDdi(ddi);
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        verificarNulo(ddi);
        validarCampoVazio(ddi);
        validarCaracteresPermitidos(ddi, REGEX_DDI, MENSAGEM_DDI_INCORRETO);
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        verificarNulo(ddd);
        validarCampoVazio(ddd);
        validarCaracteresPermitidos(ddd, REGEX_DDD, MENSAGEM_DDD_INCORRETO);
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        verificarNulo(numero);
        validarCampoVazio(numero);
        validarCaracteresPermitidos(numero, REGEX_TELEFONE, MENSAGEM_TELEFONE_INCORRETO);
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Telefone)) {
            return false;
        }
        Telefone outro = (Telefone) obj;
        return Objects.equals(ddd, outro.ddd) && Objects.equals(numero, outro.numero);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Telefone [ddi = ");
        builder.append(ddi);
        builder.append(", ddd = ");
        builder.append(ddd);
        builder.append(", numeroTelefone = ");
        builder.append(numero);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }

}
