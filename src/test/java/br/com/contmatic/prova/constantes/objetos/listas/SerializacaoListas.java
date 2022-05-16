package br.com.contmatic.prova.constantes.objetos.listas;

import static br.com.contmatic.prova.constantes.objetos.CargosObjetosConstantes.CBO_CARGOS;
import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.objetos.ContatoObjetosConstantes.CONTATO_01;
import static br.com.contmatic.prova.constantes.objetos.ContatoObjetosConstantes.CONTATO_02;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.BAIRRO;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.BAIRRO_02;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.CEP;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.COMPLEMENTO;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.LOGRADOURO;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.LOGRADOURO_02;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.SEGUNDO_CEP;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.SEGUNDO_NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.CPF_VALIDO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.DATA_ADMISSAO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.DATA_NASCIMENTO_VALIDO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.NOME_COMPLETO;
import static br.com.contmatic.prova.constantes.objetos.SetorObjetosConstantes.NOME_SETOR;
import static br.com.contmatic.prova.constantes.objetos.SetorObjetosConstantes.NOME_SETOR_RH;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.empresa.Cargo;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;
import br.com.contmatic.prova.utils.GeradorCpfCnpj;

public  class SerializacaoListas {

    private SerializacaoListas() {
    }

    /* Serialização para gerar listas */
    public static final List<Funcionario> FUNCIONARIOS = new ArrayList<>() {
        public static final long serialVersionUID = 1L;{
            add(new Funcionario(NOME_COMPLETO, CPF_VALIDO, CONTATO_01, new Endereco(LOGRADOURO, NUMERO_ENDERECO, BAIRRO, COMPLEMENTO, CEP, new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP)), 
                DATA_ADMISSAO, DATA_NASCIMENTO_VALIDO, new Cargo(CBO_CARGOS), new Setor(NOME_SETOR_RH)));

            add(new Funcionario(GeradorCpfCnpj.gerarCpf()));
        }
    };

    public static final List<Endereco> ENDERECOS = new ArrayList<>() {
        private static final long serialVersionUID = 1L;
        {
            add(new Endereco(LOGRADOURO, NUMERO_ENDERECO, BAIRRO, COMPLEMENTO, CEP, new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP)));
            add(new Endereco(LOGRADOURO_02, SEGUNDO_NUMERO_ENDERECO, BAIRRO_02, null, SEGUNDO_CEP, new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP)));
        }
    };

    public static final List<Setor> SETORES = new ArrayList<>() {
        private static final long serialVersionUID = 1L;
        {
            add(new Setor(NOME_SETOR));
            add(new Setor(NOME_SETOR_RH));
        }
    };

    public static final List<Contato> CONTATOS = new ArrayList<>() {
        private static final long serialVersionUID = 1L;
        {
            add(CONTATO_01);
            add(CONTATO_02);
        }
    };
}
