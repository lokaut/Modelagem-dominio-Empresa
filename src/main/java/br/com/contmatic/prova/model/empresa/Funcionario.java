package br.com.contmatic.prova.model.empresa;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_CARACTERES_ALFABETICOS_ACENTOS;
import static br.com.contmatic.prova.constantes.model.CargoConstantes.CARGO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.EMPRESA_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.NOME_EMPRESA_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.ENDERECO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.CPF_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.DATA_ADMISSAO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.FUNCIONARIO_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.TAMANHO_MAXIMO_NOME_FUNCIONARIO;
import static br.com.contmatic.prova.constantes.model.FuncionarioConstantes.TAMANHO_MINIMO_NOME_FUNCIONARIO;
import static br.com.contmatic.prova.constantes.model.SetorConstantes.SETOR_ATRIBUTO;
import static br.com.contmatic.prova.constantes.model.TelefoneConstantes.TELEFONE_ATRIBUTO;
import static br.com.contmatic.prova.utils.ValidacaoCpf.validarCPF;
import static br.com.contmatic.prova.utils.ValidacaoDatas.dataNascMaiorIdade;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDataAdmissao;
import static br.com.contmatic.prova.utils.ValidacaoDatas.validarDesligamento;
import static br.com.contmatic.prova.utils.ValidacaoUtils.limiteCaracteresMinimoMaximo;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCampoVazio;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresPermitidos;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarEspacoDesnecessario;
import static br.com.contmatic.prova.utils.ValidacaoUtils.verificarNulo;

import java.time.LocalDate;
import java.util.Objects;

import br.com.contmatic.prova.model.auditoria.Auditoria;
import br.com.contmatic.prova.model.contato.Telefone;
import br.com.contmatic.prova.model.endereco.Endereco;

public class Funcionario extends Auditoria {

    private String nome;

    private String cpf;

    private Telefone telefone;

    private Endereco endereco;

    private LocalDate dataAdmissao;

    private LocalDate dataNascimento;

    private LocalDate dataDesligamento;

    private Setor setor;

    private Cargo cargo;
    
    private Empresa empresa;
    
    public Funcionario(String cpf, Empresa empresa) {
        this.setCpf(cpf);
        this.setEmpresa(empresa);
    }
    //TODO MUDAR ORDEM, seguir ordem do primeiro construtor
    public Funcionario(String cpf, Empresa empresa, String nome, Telefone telefone, Endereco endereco, LocalDate dataAdmissao, LocalDate dataNascimento, Cargo cargo, Setor setor) {
        this.setCpf(cpf);
        this.setEmpresa(empresa);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        this.setDataAdmissao(dataAdmissao);
        this.setDataNascimento(dataNascimento);
        this.setCargo(cargo);
        this.setSetor(setor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        verificarNulo(nome, NOME_EMPRESA_ATRIBUTO);
        validarCampoVazio(nome, NOME_EMPRESA_ATRIBUTO);
        validarEspacoDesnecessario(nome);
        limiteCaracteresMinimoMaximo(nome, NOME_EMPRESA_ATRIBUTO,TAMANHO_MINIMO_NOME_FUNCIONARIO, TAMANHO_MAXIMO_NOME_FUNCIONARIO);
        validarCaracteresPermitidos(nome, REGEX_CARACTERES_ALFABETICOS_ACENTOS, MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO, NOME_EMPRESA_ATRIBUTO);
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        verificarNulo(cpf, CPF_ATRIBUTO);
        validarCPF(cpf);
        this.cpf = cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        verificarNulo(dataAdmissao, DATA_ADMISSAO_ATRIBUTO);
        validarDataAdmissao(dataAdmissao);
        this.dataAdmissao = dataAdmissao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        verificarNulo(endereco, ENDERECO_ATRIBUTO);
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
        verificarNulo(telefone, TELEFONE_ATRIBUTO);
        this.telefone = telefone;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        verificarNulo(dataNascimento, FUNCIONARIO_ATRIBUTO);
        dataNascMaiorIdade(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(LocalDate dataDesligamento) {
        validarDesligamento(dataDesligamento);
        this.dataDesligamento = dataDesligamento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        verificarNulo(setor, SETOR_ATRIBUTO);
        this.setor = setor;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        verificarNulo(cargo, CARGO_ATRIBUTO);
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        verificarNulo(empresa, EMPRESA_ATRIBUTO);
        this.empresa = empresa;
    }


    @Override
    public int hashCode() {
        return Objects.hash(cpf, empresa);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(empresa, other.empresa);
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Funcionario [nome = ");
        builder.append(nome);
        builder.append(", cpf = ");
        builder.append(cpf);
        builder.append(", telefone = ");
        builder.append(telefone);
        builder.append(", endereco = ");
        builder.append(endereco);
        builder.append(", dataAdmissao = ");
        builder.append(dataAdmissao);
        builder.append(", dataNascimento = ");
        builder.append(dataNascimento);
        builder.append(", dataDesligamento = ");
        builder.append(dataDesligamento);
        builder.append(", setor = ");
        builder.append(setor);
        builder.append(", cargo = ");
        builder.append(cargo);
        builder.append("]");
        builder.append(super.toString());
        return builder.toString();
    }
}
