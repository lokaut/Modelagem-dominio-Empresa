package br.com.contmatic.prova.constantes.objetos.listas;

import static br.com.contmatic.prova.constantes.CargosConstantes.CBO_CARGOS;
import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.ContatoConstantes.EMAIL;
import static br.com.contmatic.prova.constantes.ContatoConstantes.EMAIL_SECUNDARIO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.BAIRRO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.BAIRRO_02;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.CEP;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.COMPLEMENTO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.LOGRADOURO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.LOGRADOURO_02;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.SEGUNDO_CEP;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.SEGUNDO_NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.FuncionarioConstantes.CPF_VALIDO;
import static br.com.contmatic.prova.constantes.FuncionarioConstantes.DATA_ADMISSAO;
import static br.com.contmatic.prova.constantes.FuncionarioConstantes.DATA_NASCIMENTO_VALIDO;
import static br.com.contmatic.prova.constantes.FuncionarioConstantes.NOME_COMPLETO;
import static br.com.contmatic.prova.constantes.SetorConstantes.NOME_SETOR;
import static br.com.contmatic.prova.constantes.SetorConstantes.NOME_SETOR_RH;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_CEARA;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_SAO_PAULO;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDI_BRASIL;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_CELULAR;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_TELEFONE;
import static br.com.contmatic.prova.constantes.utils.GeradorCpfCnpj.gerarCpf;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.contato.Telefone;
import br.com.contmatic.prova.model.empresa.Cargo;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;

public class SerializacaoListas {

    private SerializacaoListas() {
    }

    /* Serialização para gerar listas */
    public static final List<Funcionario> FUNCIONARIOS = new ArrayList<>() {
        public static final long serialVersionUID = 1L;
        {
            add(new Funcionario(NOME_COMPLETO, CPF_VALIDO, new Contato(EMAIL, new Telefone(DDI_BRASIL, DDD_SAO_PAULO, NUMERO_CELULAR)),
                new Endereco(LOGRADOURO, NUMERO_ENDERECO, BAIRRO, COMPLEMENTO, CEP, new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP)), DATA_ADMISSAO,
                DATA_NASCIMENTO_VALIDO, new Cargo(CBO_CARGOS), new Setor(NOME_SETOR_RH)));

            add(new Funcionario(gerarCpf()));
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
            add(new Contato(EMAIL, new Telefone(DDI_BRASIL, DDD_SAO_PAULO, NUMERO_CELULAR)));
            add(new Contato(EMAIL_SECUNDARIO, new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_TELEFONE)));
        }
    };
}
