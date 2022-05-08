package br.com.contmatic.prova.constantes.objetos;

import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.CIDADE_01;

import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;

public class EnderecoObjetosConstantes {
    public static final String LOGRADOURO = "Rua Bastos";
    public static final String LOGRADOURO_02 = "Rua Iguape";
    public static final String NUMERO_ENDERECO = "101";
    public static final String SEGUNDO_NUMERO_ENDERECO = "103";
    public static final String SEGUNDO_CEP = "18321050";
    public static final String BAIRRO = "Vila Olímpia";
    public static final String BAIRRO_02 = "Jardim Angela";
    public static final String CEP = "03757040";
    public static final String COMPLEMENTO = "predio A, apartamento 23";
    public static final Endereco ENDERECO_01 = gerarEndereco(LOGRADOURO, NUMERO_ENDERECO, BAIRRO, COMPLEMENTO, CEP, CIDADE_01);
    public static final Endereco ENDERECO_02 = gerarEndereco(LOGRADOURO_02, SEGUNDO_NUMERO_ENDERECO, BAIRRO_02, null, SEGUNDO_CEP, CIDADE_01);

    private static Endereco gerarEndereco(String logradouro, String numero, String bairro, String complemento, String cep, Cidade cidade) {
        return new Endereco(logradouro, numero, bairro, complemento, cep, cidade);
    }
}
