package br.com.contmatic.prova.model.contato;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_EMAIL;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.TAMANHO_MINIMO_EMAIL;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

public class Email {

    private String endereco;

    private Emailtype emailType;
    
    public Email() {}
    
    public Email(String endereco, Emailtype emailtype) {
        this.setEndereco(endereco);
        this.setEmailtype(emailtype);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        verificarNulo(endereco);
        validarCampoVazio(endereco);
        limiteCaracteresMinimoMaximo(endereco, TAMANHO_MINIMO_EMAIL, TAMANHO_MAXIMO_EMAIL);
        validarCaracteresPermitidos(endereco, REGEX_EMAIL, MENSAGEM_EMAIL_INVALIDO);
        this.endereco = endereco;
    }

    public Emailtype getEmailtype() {
        return emailType;
    }

    public void setEmailtype(Emailtype emailtype) {
        verificarNulo(endereco);
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
