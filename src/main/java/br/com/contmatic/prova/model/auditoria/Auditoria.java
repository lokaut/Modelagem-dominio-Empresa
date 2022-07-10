package br.com.contmatic.prova.model.auditoria;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_IP_INVALIDO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_IP;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDateTimeMaiorDateTimeAtual;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarSeExiste;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDateTime;

import br.com.contmatic.prova.model.contato.Contato;

public abstract class Auditoria {

    private Contato contatoCriacao;

    private Contato contatoAlteracao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String ipCriacao;

    private String ipAlteracao;

    public Contato getContatoCriacao() {
        return contatoCriacao;
    }

    public void setContatoCriacao(Contato contatoCriacao) {
        verificarNulo(contatoCriacao);
        validarSeExiste(contatoCriacao, this.contatoCriacao);
        this.contatoCriacao = contatoCriacao;
    }

    public Contato getContatoAlteracao() {
        return contatoAlteracao;
    }

    public void setContatoAlteracao(Contato contatoAlteracao) {
        verificarNulo(contatoAlteracao);
        this.contatoAlteracao = contatoAlteracao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        verificarNulo(dataCriacao);
        validarDateTimeMaiorDateTimeAtual(dataCriacao);
        validarSeExiste(dataCriacao, this.dataCriacao);
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        verificarNulo(dataCriacao);
        validarDateTimeMaiorDateTimeAtual(dataCriacao);
        this.dataAlteracao = dataAlteracao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        verificarNulo(ipCriacao);
        validarCampoVazio(ipCriacao);
        validarCaracteresPermitidos(ipCriacao, REGEX_IP, MENSAGEM_IP_INVALIDO);
        validarSeExiste(ipCriacao, this.ipCriacao);
        this.ipCriacao = ipCriacao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        verificarNulo(ipAlteracao);
        validarCampoVazio(ipAlteracao);
        validarCaracteresPermitidos(ipAlteracao, REGEX_IP, MENSAGEM_IP_INVALIDO);
        this.ipAlteracao = ipAlteracao;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" Auditoria [contatoCriacao = ");
        builder.append(contatoCriacao);
        builder.append(", contatoAltaeracao = ");
        builder.append(contatoAlteracao);
        builder.append(", dataCriacao = ");
        builder.append(dataCriacao);
        builder.append(", dataAlteracao = ");
        builder.append(dataAlteracao);
        builder.append(", ipCriacao = ");
        builder.append(ipCriacao);
        builder.append(", ipAlteracao = ");
        builder.append(ipAlteracao);
        builder.append("] ");
        return builder.toString();
    }

}
