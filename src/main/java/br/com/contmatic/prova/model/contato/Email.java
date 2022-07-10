package br.com.contmatic.prova.model.contato;

import java.util.Objects;

public class Email {

    private String endereco;

    private Emailtype emailtype;
    
    public Email() {}
    
    public Email(String endereco, Emailtype emailtype) {
        this.setEndereco(endereco);
        this.setEmailtype(emailtype);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Emailtype getEmailtype() {
        return emailtype;
    }

    public void setEmailtype(Emailtype emailtype) {
        this.emailtype = emailtype;
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
        builder.append(emailtype);
        builder.append("]");
        return builder.toString();
    }
}
