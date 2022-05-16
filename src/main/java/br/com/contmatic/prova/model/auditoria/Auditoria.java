package br.com.contmatic.prova.model.auditoria;

import java.time.LocalDateTime;

import br.com.contmatic.prova.model.contato.Contato;

public class Auditoria {

    private Contato contatoCriacao;

    private Contato contatoAltaeracao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String ipCriacao;

    private String ipAlteracao;

    public Contato getContatoCriacao() {
        return contatoCriacao;
    }

    public void setContatoCriacao(Contato contatoCriacao) {
        this.contatoCriacao = contatoCriacao;
    }

    public Contato getContatoAltaeracao() {
        return contatoAltaeracao;
    }

    public void setContatoAltaeracao(Contato contatoAltaeracao) {
        this.contatoAltaeracao = contatoAltaeracao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        this.ipCriacao = ipCriacao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        this.ipAlteracao = ipAlteracao;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Auditoria [contatoCriacao = ");
        builder.append(contatoCriacao);
        builder.append(", contatoAltaeracao = ");
        builder.append(contatoAltaeracao);
        builder.append(", dataCriacao = ");
        builder.append(dataCriacao);
        builder.append(", dataAlteracao = ");
        builder.append(dataAlteracao);
        builder.append(", ipCriacao = ");
        builder.append(ipCriacao);
        builder.append(", ipAlteracao = ");
        builder.append(ipAlteracao);
        builder.append("]");
        return builder.toString();
    }

}
