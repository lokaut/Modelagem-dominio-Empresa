package br.com.contmatic.prova.model.auditoria;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_IP_INVALIDO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_IP;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDateTimeMaiorDateTimeAtual;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarSeExiste;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDateTime;

import br.com.contmatic.prova.model.contato.Email;

public abstract class Auditoria {

    private Email createdBy;

    private Email lastModifiedBy;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String ipCriacao;

    private String ipAlteracao;

    public Email getcreatedBy() {
        return createdBy;
    }

    public void setContatoCriacao(Email createdBy) {
        verificarNulo(createdBy);
        validarSeExiste(createdBy, this.createdBy);
        this.createdBy = createdBy;
    }

    public Email getContatoAlteracao() {
        return lastModifiedBy;
    }

    public void setContatoAlteracao(Email lastModifiedBy) {
        verificarNulo(lastModifiedBy);
        this.lastModifiedBy = lastModifiedBy;
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
        builder.append(" Auditoria [createdBy = ");
        builder.append(createdBy);
        builder.append(", lastModifiedBy = ");
        builder.append(lastModifiedBy);
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
