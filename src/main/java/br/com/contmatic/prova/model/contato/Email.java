package br.com.contmatic.prova.model.contato;

import static br.com.contmatic.prova.constantes.model.EmailConstantes.EMAILTYPE_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.ENDERECO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.TAMANHO_MINIMO_EMAIL;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEmail;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Email {

    private String endereco;

    private Emailtype emailType;

    public Email() {
    }

    public Email(String endereco, Emailtype emailtype) {
        this.setEndereco(endereco);
        this.setEmailtype(emailtype);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        verificarNulo(endereco, ENDERECO_ATRIBUTO);
        validarCampoVazio(endereco, ENDERECO_ATRIBUTO);
        limiteCaracteresMinimoMaximo(endereco, ENDERECO_ATRIBUTO, TAMANHO_MINIMO_EMAIL, TAMANHO_MAXIMO_EMAIL);
        validarEmail(endereco);
        this.endereco = endereco;
    }

    public Emailtype getEmailtype() {
        return emailType;
    }

    public void setEmailtype(Emailtype emailtype) {
        verificarNulo(endereco, EMAILTYPE_ATRIBUTO);
        this.emailType = emailtype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Email)) {
            return false;
        }
        Email other = (Email) obj;
        return Objects.equals(endereco, other.endereco);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Email [endereco = ");
        builder.append(endereco);
        builder.append(", emailtype = ");
        builder.append(emailType);
        builder.append("]");
        return builder.toString();
    }
}
