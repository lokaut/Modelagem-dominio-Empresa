package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contmatic.prova.constantes.Regex.REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.CNPJ_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.NOME_FANTASIA_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.RAZAO_SOCIAL_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.ENDERECOS_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MAXIMO_LISTA_ENDERECOS;
import static br.com.contmatic.prova.constantes.model.SetorConstantes.SETORES_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.SetorConstantes.TAMANHO_MAXIMO_LISTA_SETORES;
import static br.com.contmatic.prova.constantes.model.TelefoneConstantes.TAMANHO_MAXIMO_LISTA_TELEFONES;
import static br.com.contmatic.prova.constantes.model.TelefoneConstantes.TELEFONES_ATRIBUTO;
import static br.com.contmatic.prova.utils.ValidacaoCnpj.validarCNPJ;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDataMaiorDataAtual;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEspacoDesnecessario;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.model.contato.Telefone;
import br.com.contmatic.prova.model.endereco.Endereco;

public class Empresa extends Auditoria {

    private String cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private LocalDate dataFundacao;

    private List<Setor> setores;

    private List<Telefone> telefones;

    private List<Endereco> enderecos;

    private Boolean ativo = true;

    public Empresa(String cnpj) {
        this.setCnpj(cnpj);
    }

    public Empresa(String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataFundacao, List<Setor> setores, List<Telefone> telefones, List<Endereco> enderecos) {
        this.setCnpj(cnpj);
        this.setRazaoSocial(razaoSocial);
        this.setNomeFantasia(nomeFantasia);
        this.setDataFundacao(dataFundacao);
        this.setSetores(setores);
        this.setContatos(telefones);
        this.setEnderecos(enderecos);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        verificarNulo(cnpj, CNPJ_ATRIBUTO);
        validarCNPJ(cnpj);

        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        verificarNulo(razaoSocial, RAZAO_SOCIAL_ATRIBUTO);
        validarCampoVazio(razaoSocial, RAZAO_SOCIAL_ATRIBUTO);
        validarEspacoDesnecessario(razaoSocial);
        limiteCaracteresMinimoMaximo(razaoSocial, RAZAO_SOCIAL_ATRIBUTO, TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA, TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA);
        validarCaracteresPermitidos(razaoSocial, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL, RAZAO_SOCIAL_ATRIBUTO);
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        verificarNulo(nomeFantasia, NOME_FANTASIA_ATRIBUTO);
        validarCampoVazio(nomeFantasia, NOME_FANTASIA_ATRIBUTO);
        validarEspacoDesnecessario(nomeFantasia);
        limiteCaracteresMinimoMaximo(nomeFantasia, NOME_FANTASIA_ATRIBUTO, TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA, TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA);
        validarCaracteresPermitidos(nomeFantasia, REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL, NOME_FANTASIA_ATRIBUTO);
        this.nomeFantasia = nomeFantasia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        verificarNulo(dataFundacao, TELEFONES_ATRIBUTO);
        validarDataMaiorDataAtual(dataFundacao);
        this.dataFundacao = dataFundacao;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        verificarNulo(setores, SETORES_ATRIBUTO);
        validarListaVazia(setores, SETORES_ATRIBUTO);
        validarTamanhoMaximoLista(setores, TAMANHO_MAXIMO_LISTA_SETORES, SETORES_ATRIBUTO);
        this.setores = setores;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setContatos(List<Telefone> telefones) {
        verificarNulo(telefones, TELEFONES_ATRIBUTO);
        validarListaVazia(telefones, TELEFONES_ATRIBUTO);
        validarTamanhoMaximoLista(telefones, TAMANHO_MAXIMO_LISTA_TELEFONES, TELEFONES_ATRIBUTO);
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        verificarNulo(enderecos, ENDERECOS_ATRIBUTO);
        validarListaVazia(enderecos, ENDERECOS_ATRIBUTO);
        validarTamanhoMaximoLista(enderecos, TAMANHO_MAXIMO_LISTA_ENDERECOS, ENDERECOS_ATRIBUTO);
        this.enderecos = enderecos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) obj;
        return Objects.equals(cnpj, other.cnpj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Empresa [cnpj = ");
        builder.append(cnpj);
        builder.append(", razaoSocial = ");
        builder.append(razaoSocial);
        builder.append(", nomeFantasia = ");
        builder.append(nomeFantasia);
        builder.append(", dataFundacao = ");
        builder.append(dataFundacao);
        builder.append(", setores = ");
        builder.append(setores);
        builder.append(", telefones = ");
        builder.append(telefones);
        builder.append(", enderecos = ");
        builder.append(enderecos);
        builder.append(", ativo = ");
        builder.append(ativo);
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }

}
