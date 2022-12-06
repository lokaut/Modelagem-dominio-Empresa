package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contmatic.prova.constantes.Regex.REGEX_ALFANUMERICOS;
import static br.com.contmatic.prova.constantes.Regex.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.CIDADE_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.BAIRRO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.CEP_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.COMPLEMENTO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.LOGRADOURO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.NUMERO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_FIXO_CEP_ENDERECO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MAXIMO_BAIRRO_ENDERECO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MAXIMO_COMPLEMENTO_ENDERECO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MAXIMO_LOGRADOURO_ENDERECO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MINIMO_BAIRRO_ENDERECO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MINIMO_COMPLEMENTO_ENDERECO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MINIMO_LOGRADOURO_ENDERECO;
import static br.com.contmatic.prova.utils.ValidacaoUtils.campoOpcional;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresFixo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEspacoDesnecessario;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarNumeroResidencial;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Endereco extends Auditoria {

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String cep;

    private Cidade cidade;

    public Endereco(String logradouro, Integer numero, String bairro, String cep, Cidade cidade) {
        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCep(cep);
        this.setCidade(cidade);
    }

    public Endereco(String logradouro, Integer numero, String bairro, String complemento, String cep, Cidade cidade) {
        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setComplemento(complemento);
        this.setCep(cep);
        this.setCidade(cidade);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        verificarNulo(logradouro, LOGRADOURO_ATRIBUTO);
        validarCampoVazio(logradouro, LOGRADOURO_ATRIBUTO);
        validarEspacoDesnecessario(logradouro);
        limiteCaracteresMinimoMaximo(logradouro, LOGRADOURO_ATRIBUTO, TAMANHO_MINIMO_LOGRADOURO_ENDERECO, TAMANHO_MAXIMO_LOGRADOURO_ENDERECO);
        validarCaracteresPermitidos(logradouro, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL, LOGRADOURO_ATRIBUTO);
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    /* Se for uma residencia sem número, então o numero será zero */
    public void setNumero(Integer numero) {
        verificarNulo(numero, NUMERO_ATRIBUTO);
        validarNumeroResidencial(numero);
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        campoOpcional(complemento, TAMANHO_MINIMO_COMPLEMENTO_ENDERECO, TAMANHO_MAXIMO_COMPLEMENTO_ENDERECO, COMPLEMENTO_ATRIBUTO);
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        verificarNulo(bairro, BAIRRO_ATRIBUTO);
        validarCampoVazio(bairro, BAIRRO_ATRIBUTO);
        validarEspacoDesnecessario(bairro);
        limiteCaracteresMinimoMaximo(bairro, BAIRRO_ATRIBUTO, TAMANHO_MINIMO_BAIRRO_ENDERECO, TAMANHO_MAXIMO_BAIRRO_ENDERECO);
        validarCaracteresPermitidos(bairro, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL, BAIRRO_ATRIBUTO);
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        verificarNulo(cep, CEP_ATRIBUTO);
        validarCampoVazio(cep, CEP_ATRIBUTO);
        limiteCaracteresFixo(cep, TAMANHO_FIXO_CEP_ENDERECO);
        validarCaracteresPermitidos(cep, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL, CEP_ATRIBUTO);
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        verificarNulo(cidade, CIDADE_ATRIBUTO);
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) obj;
        return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Endereco [logradouro = ");
        builder.append(logradouro);
        builder.append(", numero = ");
        builder.append(numero);
        builder.append(", complemento = ");
        builder.append(complemento);
        builder.append(", bairro = ");
        builder.append(bairro);
        builder.append(", cep = ");
        builder.append(cep);
        builder.append(", cidade = ");
        builder.append(cidade);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }
}
