package br.com.contmatic.prova.model.endereco;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_ALFABETICO_SEM_ACENTO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_ALFANUMERICOS;
import static br.com.contmatic.prova.constantes.Regex.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.CODIGO_IBGE_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.MUNICIPIO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.TAMANHO_FIXO_CODIGOIBGE;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.TAMANHO_FIXO_UNIDADE_FEDERATIVA;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.TAMANHO_MAXIMO_MUNICIPIO;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.TAMANHO_MINIMO_MUNICIPIO;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.UNIDADE_FEDERATIVA_ATRIBUTO;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresFixo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEspacoDesnecessario;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Cidade extends Auditoria {

    private String codigoIbge;

    private String municipio;

    private String unidadeFederativa;

    public Cidade(String codigoIbge, String municipio, String unidadeFederativa) {
        this.setCodigoIbge(codigoIbge);
        this.setMunicipio(municipio);
        this.setUnidadeFederativa(unidadeFederativa);
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        verificarNulo(codigoIbge, CODIGO_IBGE_ATRIBUTO);
        validarCampoVazio(codigoIbge, CODIGO_IBGE_ATRIBUTO);
        validarEspacoDesnecessario(codigoIbge);
        limiteCaracteresFixo(codigoIbge, TAMANHO_FIXO_CODIGOIBGE);
        validarCaracteresPermitidos(codigoIbge, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL, CODIGO_IBGE_ATRIBUTO);
        this.codigoIbge = codigoIbge;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        verificarNulo(municipio, MUNICIPIO_ATRIBUTO);
        validarCampoVazio(municipio, MUNICIPIO_ATRIBUTO);
        validarEspacoDesnecessario(municipio);
        limiteCaracteresMinimoMaximo(municipio, MUNICIPIO_ATRIBUTO, TAMANHO_MINIMO_MUNICIPIO, TAMANHO_MAXIMO_MUNICIPIO);
        validarCaracteresPermitidos(municipio, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO, MUNICIPIO_ATRIBUTO);
        this.municipio = municipio;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        verificarNulo(unidadeFederativa, UNIDADE_FEDERATIVA_ATRIBUTO);
        validarCampoVazio(unidadeFederativa, UNIDADE_FEDERATIVA_ATRIBUTO);
        validarEspacoDesnecessario(unidadeFederativa);
        limiteCaracteresFixo(unidadeFederativa, TAMANHO_FIXO_UNIDADE_FEDERATIVA);
        validarCaracteresPermitidos(unidadeFederativa, REGEX_ALFABETICO_SEM_ACENTO, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO, UNIDADE_FEDERATIVA_ATRIBUTO);
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoIbge);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) obj;
        return Objects.equals(codigoIbge, other.codigoIbge);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cidade [codigoIbge = ");
        builder.append(codigoIbge);
        builder.append(", municipio = ");
        builder.append(municipio);
        builder.append(", unidadeFederativa = ");
        builder.append(unidadeFederativa);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }
}
