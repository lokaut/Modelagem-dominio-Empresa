package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_NUMERICO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_ALFANUMERICOS;
import static br.com.contmatic.prova.constantes.Regex.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.CBO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.DESCRICAO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.NOME_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.SALARIO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.TAMANHO_MAXIMO_CBO_CARGO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.TAMANHO_MAXIMO_NOME_CARGO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.TAMANHO_MINIMO_CBO_CARGO;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.TAMANHO_MINIMO_NOME_CARGO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.FUNCIONARIOS_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova.constantes.model.SetorConstantes.TAMANHO_MAXIMO_DESCRICAO;
import static br.com.contmatic.prova.constantes.model.SetorConstantes.TAMANHO_MINIMO_DESCRICAO;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEspacoDesnecessario;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarListaVazia;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarSalarioMinimo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarTamanhoMaximoLista;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;

public class Cargo extends Auditoria {

    private String nome;

    private String cbo;

    private BigDecimal salario;

    private List<Funcionario> funcionarios;

    private String descricao;

    public Cargo(String cbo) {
        this.setCbo(cbo);
    }

    public Cargo(String nome, String cbo, BigDecimal salario, String descricao, List<Funcionario> funcionarios) {
        this.setNome(nome);
        this.setCbo(cbo);
        this.setSalario(salario);
        this.setDescricao(descricao);
        this.setFuncionarios(funcionarios);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        verificarNulo(nome, NOME_ATRIBUTO);
        validarCampoVazio(nome, NOME_ATRIBUTO);
        validarEspacoDesnecessario(nome);
        limiteCaracteresMinimoMaximo(nome, NOME_ATRIBUTO, TAMANHO_MINIMO_NOME_CARGO, TAMANHO_MAXIMO_NOME_CARGO);
        validarCaracteresPermitidos(nome, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_NUMERICO, NOME_ATRIBUTO);
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        verificarNulo(salario, SALARIO_ATRIBUTO);
        validarSalarioMinimo(salario);
        this.salario = salario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        verificarNulo(funcionarios, FUNCIONARIOS_ATRIBUTO);
        validarListaVazia(funcionarios, FUNCIONARIOS_ATRIBUTO);
        validarTamanhoMaximoLista(funcionarios, TAMANHO_MAXIMO_LISTA_FUNCIONARIO, FUNCIONARIOS_ATRIBUTO);
        this.funcionarios = funcionarios;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        verificarNulo(cbo, CBO_ATRIBUTO);
        validarCampoVazio(cbo, CBO_ATRIBUTO);
        validarEspacoDesnecessario(cbo);
        limiteCaracteresMinimoMaximo(cbo, CBO_ATRIBUTO, TAMANHO_MINIMO_CBO_CARGO, TAMANHO_MAXIMO_CBO_CARGO);
        validarCaracteresPermitidos(cbo, REGEX_ALFANUMERICOS, MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL, CBO_ATRIBUTO);
        this.cbo = cbo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        verificarNulo(descricao, DESCRICAO_ATRIBUTO);
        validarCampoVazio(descricao, DESCRICAO_ATRIBUTO);
        validarEspacoDesnecessario(descricao);
        limiteCaracteresMinimoMaximo(descricao, DESCRICAO_ATRIBUTO, TAMANHO_MINIMO_DESCRICAO, TAMANHO_MAXIMO_DESCRICAO);
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cbo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cargo)) {
            return false;
        }
        Cargo outro = (Cargo) obj;
        return Objects.equals(cbo, outro.cbo);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cargo [nome = ");
        builder.append(nome);
        builder.append(", cbo = ");
        builder.append(cbo);
        builder.append(", salario = ");
        builder.append(salario);
        builder.append(", funcionarios = ");
        builder.append(funcionarios);
        builder.append(", descricao = ");
        builder.append(descricao);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }
}
