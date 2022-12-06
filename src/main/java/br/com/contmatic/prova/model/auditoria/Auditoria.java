package br.com.contmatic.prova.model.auditoria;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_IP_INVALIDO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_IP;
import static br.com.contmatic.prova.constantes.model.AuditoriaConstantes.CRIADOPOR_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.AuditoriaConstantes.DATA_ALTERACAO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.AuditoriaConstantes.DATA_CRIACAO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.AuditoriaConstantes.IP_ALTERACAO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.AuditoriaConstantes.IP_CRIACAO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.AuditoriaConstantes.MODIFICADOPOR_ATRIBUTO;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDateTimeMaiorDateTimeAtual;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarSeExiste;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDateTime;

import br.com.contmatic.prova.model.contato.Email;

public abstract class Auditoria {

    private Email criadoPor;

    private Email modificadoPor;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String ipCriacao;

    private String ipAlteracao;

    public Email getcreatedBy() {
        return criadoPor;
    }

    public void setCreateBy(Email criadoPor) {
        verificarNulo(criadoPor, CRIADOPOR_ATRIBUTO);
        validarSeExiste(this.criadoPor);
        this.criadoPor = criadoPor;
    }

    public Email getLastModifiedBy() {
        return modificadoPor;
    }

    public void setLastModifiedBy(Email modificadoPor) {
        verificarNulo(modificadoPor, MODIFICADOPOR_ATRIBUTO);
        this.modificadoPor = modificadoPor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        verificarNulo(dataCriacao, DATA_CRIACAO_ATRIBUTO);
        validarDateTimeMaiorDateTimeAtual(dataCriacao);
        validarSeExiste(this.dataCriacao);
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        verificarNulo(dataAlteracao, DATA_ALTERACAO_ATRIBUTO);
        validarDateTimeMaiorDateTimeAtual(dataAlteracao);
        this.dataAlteracao = dataAlteracao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        verificarNulo(ipCriacao, IP_CRIACAO_ATRIBUTO);
        validarCampoVazio(ipCriacao, IP_CRIACAO_ATRIBUTO);
        validarCaracteresPermitidos(ipCriacao, REGEX_IP, MENSAGEM_IP_INVALIDO, IP_CRIACAO_ATRIBUTO);
        validarSeExiste(this.ipCriacao);
        this.ipCriacao = ipCriacao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        verificarNulo(ipAlteracao, IP_ALTERACAO_ATRIBUTO);
        validarCampoVazio(ipAlteracao, IP_ALTERACAO_ATRIBUTO);
        validarCaracteresPermitidos(ipAlteracao, REGEX_IP, MENSAGEM_IP_INVALIDO, IP_ALTERACAO_ATRIBUTO);
        this.ipAlteracao = ipAlteracao;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Auditoria [criadoPor = ");
        builder.append(criadoPor);
        builder.append(", modificadoPor = ");
        builder.append(modificadoPor);
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
