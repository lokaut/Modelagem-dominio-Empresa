package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_PINDAMONHANGABA;
import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_PINDAMONHANGABA;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.EmpresaConstantes.CNPJ_VALIDO;
import static br.com.contmatic.prova.constantes.EmpresaConstantes.CNPJ_VALIDO_ALEATORIO;
import static br.com.contmatic.prova.constantes.EmpresaConstantes.NOME_FANTASIA;
import static br.com.contmatic.prova.constantes.EmpresaConstantes.RAZAO_SOCIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.BAIRRO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.BAIRRO_02;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.CEP;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.COMPLEMENTO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.LOGRADOURO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.LOGRADOURO_02;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.SEGUNDO_CEP;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.SEGUNDO_NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DATA_FUTURA;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.FUNDACAO_EMPRESA;
import static br.com.contmatic.prova.constantes.SetorConstantes.DESCRICAO_SETOR;
import static br.com.contmatic.prova.constantes.SetorConstantes.NOME_SETOR;
import static br.com.contmatic.prova.constantes.SetorConstantes.NOME_SETOR_RH;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_CEARA;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_SAO_PAULO;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDI_BRASIL;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_CELULAR;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_TELEFONE;
import static br.com.contmatic.prova.constantes.model.ContatoConstantes.TAMANHO_MAXIMO_LISTA_CONTATOS;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EmpresaConstantes.TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA;
import static br.com.contmatic.prova.constantes.model.EnderecoConstantes.TAMANHO_MAXIMO_LISTA_ENDERECOS;
import static br.com.contmatic.prova.constantes.model.SetorConstantes.TAMANHO_MAXIMO_LISTA_SETORES;
import static br.com.contmatic.prova.constantes.objetos.listas.SerializacaoListas.ENDERECOS;
import static br.com.contmatic.prova.constantes.objetos.listas.SerializacaoListas.SETORES;
import static br.com.contmatic.prova.constantes.objetos.listas.SerializacaoListas.TELEFONES;
import static br.com.contmatic.prova.constantes.utils.ConstantesTestes.DOIS_CARACTERES;
import static br.com.contmatic.prova.constantes.utils.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contmatic.prova.constantes.utils.GeradorCpfCnpj.gerarCpf;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.utils.ConstantesTestes;
import br.com.contmatic.prova.model.contato.Telefone;
import br.com.contmatic.prova.model.empresa.Empresa;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;

public class EmpresaTest {

    private List<Setor> setoresVazio;

    private List<Telefone> contatosVazio;

    private List<Endereco> telefonesVazio;

    private Empresa empresaCompleta;

    private Empresa empresa;

    private IllegalStateException illegalState;

    private IllegalArgumentException illegalArgument;

    @BeforeEach
    public void instanciar() {
        setoresVazio = new ArrayList<>();
        contatosVazio = new ArrayList<>();
        telefonesVazio = new ArrayList<>();
        empresa = new Empresa(CNPJ_VALIDO_ALEATORIO);
        empresaCompleta = new Empresa(CNPJ_VALIDO);
    }

    @AfterAll
    public static void finalizacao() {
        System.out.println("Fim dos testes Empresa");
    }

    @Test
    void nao_deve_aceitar_cnpj_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_campo_vazio_nome(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS));
    }

    @ParameterizedTest
    @ValueSource(strings = { "440856", "9079500780", "907950078", "90795007", "9079500", "90795", "9079", "907", "90", "9", "907950078095", "9079500780990795007809" })
    void nao_deve_aceitar_numeros_diferente_catorze_numeros_cnpj(String cnpj) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(cnpj));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS));
    }

    @ParameterizedTest
    @ValueSource(strings = { "00000000000000", "11111111111111", "22222222222222", "33333333333333", "44444444444444", "55555555555555", "66666666666666", "77777777777777", "88888888888888",
        "99999999999999" })
    void nao_deve_aceitar_cnpj_somente_numeros_iguais(String cnpjInvalido) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(cnpjInvalido));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CNPJ_INVALIDO));
    }

    @Test
    void nao_deve_aceitar_caracter_texto_cnpj() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(ConstantesTestes.CATORZE_NUMEROS_LETRAS));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CNPJ_INVALIDO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "56973542000102", "08068013000101", "12344459000108" })
    void nao_deve_aceitar_cnpj_invalido(String cnpjInvalido) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(cnpjInvalido));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CNPJ_INVALIDO));
    }

    @Test
    void deve_validar_cnpj_correto() {
        empresa.setCnpj(CNPJ_VALIDO_ALEATORIO);
        assertEquals(CNPJ_VALIDO_ALEATORIO, empresa.getCnpj());
    }

    @Test
    void nao_deve_aceitar_razaoSocial_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_campo_vazio_cnpj(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @ParameterizedTest
    @ValueSource(strings = { DOIS_CARACTERES, MAIS_CEM_CARACTERES })
    void nao_deve_aceitar_fora_limite_caracteres_razaoSocial(String nome) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nome));
        assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_RAZAOSOCIAL_EMPRESA + " a " +
            TAMANHO_MAXIMO_RAZAOSOCIAL_EMPRESA + " caracteres" + ", atualmente o campo possui " + nome.length()));
    }

    @ParameterizedTest
    @ValueSource(strings = { "@@123", "Am@anda sous@", "J$ssica Cardoso", "&rick" })
    void nao_deve_aceitar_caracter_numerico_especial_razaoSocial(String nomeErrado) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nomeErrado));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL));
    }

    @Test
    void deve_validar_razaoSocial_correto() {
        empresaCompleta.setRazaoSocial(RAZAO_SOCIAL);
        assertEquals(RAZAO_SOCIAL, empresaCompleta.getRazaoSocial());
    }

    @Test
    void nao_deve_aceitar_nomeFantasia_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_campo_vazio_NomeFantasia(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setNomeFantasia(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @ParameterizedTest
    @ValueSource(strings = { ConstantesTestes.DOIS_CARACTERES, ConstantesTestes.MAIS_CEM_CARACTERES })
    void nao_deve_aceitar_fora_limite_caracteres_NomeFantasia(String nome) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nome));
        assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_NOMEFANTASIA_EMPRESA + " a " +
            TAMANHO_MAXIMO_NOMEFANTASIA_EMPRESA + " caracteres" + ", atualmente o campo possui " + nome.length()));
    }

    @ParameterizedTest
    @ValueSource(strings = { "@@123", "Am@anda sous@", "J$ssica Cardoso", "&rick" })
    void nao_deve_aceitar_caracter_numerico_especial_NomeFantasia(String nomeErrado) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setRazaoSocial(nomeErrado));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL));
    }

    @Test
    void deve_validar_correto_nomeFantasia() {
        empresaCompleta.setNomeFantasia(NOME_FANTASIA);
        assertEquals(NOME_FANTASIA, empresaCompleta.getNomeFantasia());
    }

    @Test
    void nao_deve_aceitar_dataFundacao_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setDataFundacao(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(longs = { 1, 10, 30 })
    void nao_deve_aceitar_data_futura_dataFundacao(long dias) {
        LocalDate dataFutura = now().plusDays(dias);
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setDataFundacao(dataFutura));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DATA_FUTURA));
    }

    @Test
    void deve_validar_correto_dataFundacao() {
        empresaCompleta.setDataFundacao(FUNDACAO_EMPRESA);
        assertEquals(FUNDACAO_EMPRESA, empresaCompleta.getDataFundacao());
    }

    @Test
    void nao_deve_aceitar_lista_vazia_setores() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setSetores(setoresVazio));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_lista_nula_setores() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setSetores(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_lista_acima_limite_setores() {
        Setor setorObjeto = new Setor(NOME_SETOR);
        Setor setorObjeto2 = new Setor(NOME_SETOR_RH);
        while (setoresVazio.size() <= TAMANHO_MAXIMO_LISTA_SETORES) {
            setoresVazio.add(setorObjeto);
            setoresVazio.add(setorObjeto2);
        }
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setSetores(setoresVazio));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
    }

    @Test
    void deve_validar_lista_setores() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(gerarCpf()));
        setoresVazio.add(new Setor(NOME_SETOR, funcionarios, DESCRICAO_SETOR, new Empresa(CNPJ_VALIDO_ALEATORIO)));
        empresaCompleta.setSetores(setoresVazio);
        assertEquals(setoresVazio, empresaCompleta.getSetores());
    }

    @Test
    void nao_deve_aceitar_lista_vazia_contatos() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setContatos(contatosVazio));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_lista_acima_limite_contatos() {
        while (contatosVazio.size() <= TAMANHO_MAXIMO_LISTA_CONTATOS) {
            contatosVazio.add(new Telefone(DDI_BRASIL, DDD_SAO_PAULO, NUMERO_CELULAR));
            contatosVazio.add( new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_TELEFONE));

        }
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setContatos(contatosVazio));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
    }

    @Test
    void nao_deve_aceitar_lista_nulo_contatos() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setContatos(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void deve_validar_lista_contatos() {
        contatosVazio.add(new Telefone(DDI_BRASIL, DDD_SAO_PAULO, NUMERO_CELULAR));
        contatosVazio.add(new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_TELEFONE));

        empresaCompleta.setContatos(contatosVazio);
        assertEquals(contatosVazio, empresaCompleta.getTelefones());
    }

    @Test
    void nao_deve_aceitar_lista_vazia_enderecos() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setEnderecos(telefonesVazio));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_lista_acima_limite_enderecos() {
        while (telefonesVazio.size() <= TAMANHO_MAXIMO_LISTA_ENDERECOS) {
            telefonesVazio.add(new Endereco(LOGRADOURO, NUMERO_ENDERECO, BAIRRO, COMPLEMENTO, CEP, new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP)));
            telefonesVazio.add(new Endereco(LOGRADOURO_02, SEGUNDO_NUMERO_ENDERECO, BAIRRO_02, null, SEGUNDO_CEP, new Cidade(CODIGO_IBGE_PINDAMONHANGABA, MUNICIPIO_PINDAMONHANGABA, UNIDADE_FEDERATIVA_SP)));
        }
        this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setEnderecos(telefonesVazio));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_NUMERO_EXCEDIDO_LISTA));
    }

    @Test
    void nao_deve_aceitar_lista_nulo_enderecos() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setEnderecos(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void deve_validar_lista_enderecos() {
        telefonesVazio.add(new Endereco(LOGRADOURO, NUMERO_ENDERECO, BAIRRO, COMPLEMENTO, CEP, new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP)));

        empresaCompleta.setEnderecos(telefonesVazio);
        assertEquals(telefonesVazio, empresaCompleta.getEnderecos());
    }
    
    @Test
    void deve_validar_constrututor_completo() {
        empresaCompleta = new Empresa(CNPJ_VALIDO_ALEATORIO, RAZAO_SOCIAL, NOME_FANTASIA, FUNDACAO_EMPRESA, SETORES, TELEFONES, ENDERECOS);
        assertEquals(CNPJ_VALIDO_ALEATORIO, empresaCompleta.getCnpj());
        assertEquals(RAZAO_SOCIAL, empresaCompleta.getRazaoSocial());
        assertEquals(NOME_FANTASIA, empresaCompleta. getNomeFantasia());
        assertEquals(FUNDACAO_EMPRESA, empresaCompleta.getDataFundacao());
        assertEquals(SETORES, empresaCompleta.getSetores());
        assertEquals(TELEFONES, empresaCompleta.getTelefones());
        assertEquals(ENDERECOS, empresaCompleta.getEnderecos());
    }

    @Test
    void nao_deve_aceitar_hashcode_diferente() {
        assertNotEquals(empresaCompleta.hashCode(), empresa.hashCode());
    }

    @Test
    void deve_validar_hashcode_iguais() {
        assertEquals(empresaCompleta.hashCode(), empresaCompleta.hashCode());
    }

    @Test
    void deve_validar_equals() {
        assertAll(() -> assertEquals(empresaCompleta, empresaCompleta), () -> assertNotEquals(empresaCompleta, empresa), () -> assertNotNull(empresaCompleta),
            () -> assertNotEquals(true, empresaCompleta.equals(new Object())));
    }

    void deve_validar_toString() {
        assertAll(() -> assertEquals("Empresa [cnpj=" + CNPJ_VALIDO + ", razaoSocial=" + RAZAO_SOCIAL + ", nomeFantasia=" + NOME_FANTASIA + ", dataAbertura=" + FUNDACAO_EMPRESA + ", setores=" +
            SETORES + ", telefones = " + TELEFONES + ", endereco=" + ENDERECOS + "]", empresaCompleta.toString()), () -> assertNotEquals(empresa.toString(), empresaCompleta.toString()));
    }

}
