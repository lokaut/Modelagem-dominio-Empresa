package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.objetos.CargosObjetosConstantes.CBO_CARGOS;
import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.constantes.objetos.CidadeObjetosConstantes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.objetos.ContatoObjetosConstantes.EMAIL_SECUNDARIO;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.BAIRRO_02;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.LOGRADOURO_02;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.SEGUNDO_CEP;
import static br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes.SEGUNDO_NUMERO_ENDERECO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.CPF_VALIDO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.CPF_VALIDO_ALEATORIO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.DATA_ADMISSAO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.DATA_NASCIMENTO_VALIDO;
import static br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes.NOME_COMPLETO;
import static br.com.contmatic.prova.constantes.objetos.SetorObjetosConstantes.NOME_SETOR;
import static br.com.contmatic.prova.constantes.objetos.TelefoneObjetosConstantes.DDD_CEARA;
import static br.com.contmatic.prova.constantes.objetos.TelefoneObjetosConstantes.DDI_BRASIL;
import static br.com.contmatic.prova.constantes.objetos.TelefoneObjetosConstantes.NUMERO_TELEFONE;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.constantes.ConstantesTestes;
import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.model.FuncionarioConstantes;
import br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes;
import br.com.contmatic.prova.constantes.objetos.SetorObjetosConstantes;
import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.contato.Telefone;
import br.com.contmatic.prova.model.empresa.Cargo;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Cidade;
import br.com.contmatic.prova.model.endereco.Endereco;

class FuncionarioTest {

    Funcionario funcionario;

    Funcionario funcionarioCompleto;

    Funcionario funcionarioCompleto2;

    Contato contato;

    IllegalStateException illegalState;

    IllegalArgumentException illegalArgument;

    LocalDate dataDesligamento = null;

    Endereco endereco;

    Setor setor;

    Cargo cargo;
    
    Cidade cidade;
    
    Telefone telefone;

    @BeforeEach
    public void instancia() {
        telefone = new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_TELEFONE);
        cidade = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP);
        endereco = new Endereco(LOGRADOURO_02, SEGUNDO_NUMERO_ENDERECO, BAIRRO_02, null, SEGUNDO_CEP, cidade);
        cargo = new Cargo(CBO_CARGOS);
        setor = new Setor(NOME_SETOR);
        contato =  new Contato(EMAIL_SECUNDARIO, telefone);
        funcionario = new Funcionario(CPF_VALIDO_ALEATORIO);
        funcionarioCompleto = new Funcionario(NOME_COMPLETO, CPF_VALIDO, contato, endereco, DATA_ADMISSAO, DATA_NASCIMENTO_VALIDO, cargo, setor);
        funcionarioCompleto2 = new Funcionario(NOME_COMPLETO, CPF_VALIDO, contato, endereco, DATA_ADMISSAO, DATA_NASCIMENTO_VALIDO, cargo, setor);
    }

    @AfterAll
    public static void finalizacao() {
        System.out.println("Fim dos testes funcionario");
    }

    @ParameterizedTest
    @ValueSource(strings = { ConstantesTestes.DOIS_CARACTERES, ConstantesTestes.MAIS_CEM_CARACTERES })
    void nao_deve_aceitar_fora_limite_caracteres_nome(String nome) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(nome));
        assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre " + FuncionarioConstantes.TAMANHO_MINIMO_NOME_FUNCIONARIO + " a " +
            FuncionarioConstantes.TAMANHO_MAXIMO_NOME_FUNCIONARIO + " caracteres" + ", atualmente o campo possui " + nome.length()));
    }

    @Test
    void nao_deve_aceitar_nome_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome(null));
        assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_campo_vazio_nome() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(" "));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CAMPO_VAZIO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "123456", "@@123", "Am@anda sous@", "J$ssica Cardoso", "&rick" })
    void nao_deve_aceitar_caracter_numerico_especial_nome(String nomeErrado) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setNome(nomeErrado));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "440856", "9079500780", "907950078", "90795007", "9079500", "90795", "9079", "907", "90", "9", "907950078095", "9079500780990795007809" })
    void nao_deve_aceitar_numeros_diferente_onze_numeros_cpf(String cpf) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(cpf));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CPF_DIFERENTE_ONZE_NUMEROS));
    }

    @ParameterizedTest
    @ValueSource(strings = { "00000000000", "11111111111", "22222222222", "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999" })
    void nao_deve_aceitar_cpf_somente_numeros_iguais(String cpfInvalido) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(cpfInvalido));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_CPF_INVALIDO));
    }

    @Test
    void nao_deve_aceitar_caracter_texto_cpf() {
        illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setCpf(ConstantesTestes.ONZE_NUMEROS_CARACTERES));
        assertTrue(illegalState.getMessage().contains(Mensagem.MENSAGEM_CPF_INVALIDO));
    }

    @Test
    void nao_deve_aceitar_campo_nulo_cpf() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf(null));
        assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_campo_contato_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setContato(null));
        assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(ints = { 15, 14, 13, 12, 11, 10, 9, 8, 7, 5, 4, 3, 2, 1, -5 })
    void nao_deve_aceitar_funcionario_menor_dezesseis_anos(int idade) {
        LocalDate dataNascimento = now().minusYears(idade);
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataNascimento(dataNascimento));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_IDADE_MINIMA_EMPRESA));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 })
    void nao_deve_aceitar_data_admissao_acima_dois_meses(int meses) {
        LocalDate mesesAposDataHoje = now().plusMonths(meses);
        illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataAdmissao(mesesAposDataHoje));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_ADMISSAO_FUTURA));
    }

    @Test
    void nao_deve_aceitar_data_nascimento_nulo() {
        illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setDataNascimento(null));
        assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_endereco_nulo() {
        illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setEndereco(null));
        assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_setor_nulo() {
        illegalArgument = assertThrows(IllegalArgumentException.class, () -> funcionario.setSetor(null));
        assertTrue(this.illegalArgument.getMessage().contains(Mensagem.MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void nao_deve_aceitar_dataDesligamento_antes_data_hoje(int dias) {
        LocalDate dataAnteriorAoDiaAtual = now().minusDays(dias);
        this.illegalState = assertThrows(IllegalStateException.class, () -> funcionario.setDataDesligamento(dataAnteriorAoDiaAtual));
        assertTrue(this.illegalState.getMessage().contains(Mensagem.MENSAGEM_DESLIGAMENTO_ANTES_DATA_ATUAL));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5 })
    void deve_validar_dataDesligamento_depois_data_hoje(int dias) {
        LocalDate dataPosteriorAoDiaAtual = now().plusDays(dias);
        funcionario.setDataDesligamento(dataPosteriorAoDiaAtual);
        assertEquals(funcionario.getDataDesligamento(), dataPosteriorAoDiaAtual);
    }

    @Test
    void deve_aceitar_dataDesligamento_nulo() {
        assertNull(funcionario.getDataDesligamento());
    }

    @Test
    void deve_validar_data_nascimento_correto() {
        assertEquals(FuncionarioObjetosConstantes.DATA_NASCIMENTO_VALIDO, funcionarioCompleto.getDataNascimento());
    }

    @Test
    void deve_validar_data_setor_correto() {
        funcionario.setSetor(new Setor(SetorObjetosConstantes.NOME_SETOR));
        assertEquals(setor, funcionarioCompleto.getSetor());
    }

    @Test
    void deve_validar_data_admissao_correto() {
        assertEquals(FuncionarioObjetosConstantes.DATA_ADMISSAO, funcionarioCompleto.getDataAdmissao());
    }

    @Test
    void deve_validar_contato_correto() {
        assertEquals(contato, funcionarioCompleto.getContato());
    }

    @Test
    void deve_validar_campo_nome_correto() {
        assertEquals(FuncionarioObjetosConstantes.NOME_COMPLETO, funcionarioCompleto.getNome());
    }

    @Test
    void deve_validar_cpf_correto() {
        assertEquals(FuncionarioObjetosConstantes.CPF_VALIDO_ALEATORIO, funcionario.getCpf());
    }

    @Test
    void deve_validar_endereco_correto() {
        assertEquals(endereco, funcionarioCompleto.getEndereco());
    }

    @Test
    void deve_validar_cargo_correto() {
        assertEquals(cargo, funcionarioCompleto.getCargo());
    }

    @Test
    void nao_deve_validar_hashcode_diferente() {
        assertNotEquals(funcionario.hashCode(), funcionarioCompleto.hashCode());
    }

    @Test
    void deve_validar_hashcode_igual() {
        assertEquals(funcionarioCompleto.hashCode(), funcionarioCompleto2.hashCode());
    }

    @Test
    void deve_validar_equals() {
        assertEquals(funcionarioCompleto, funcionarioCompleto2);
        assertEquals(funcionarioCompleto, funcionarioCompleto);
        assertNotEquals(null, funcionarioCompleto);
        assertNotEquals(true, funcionarioCompleto.equals(new Object()));
    }

    @Test
    void deve_validar_toString() {
        assertEquals("Funcionario [nome = " + FuncionarioObjetosConstantes.NOME_COMPLETO + ", cpf = " + FuncionarioObjetosConstantes.CPF_VALIDO + ", contato = " + contato + ", endereco = " +
            endereco + ", dataAdmissao = " + FuncionarioObjetosConstantes.DATA_ADMISSAO + ", dataNascimento = " + FuncionarioObjetosConstantes.DATA_NASCIMENTO_VALIDO + ", dataDesligamento = " +
            dataDesligamento + ", setor = " + setor + ", cargo = " + cargo + "]", funcionarioCompleto.toString());
    }
}