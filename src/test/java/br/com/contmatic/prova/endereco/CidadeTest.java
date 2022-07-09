package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constantes.AuditoriaConstantes.IP_VALIDO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_PINDAMONHANGABA;
import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_PINDAMONHANGABA;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_CEARA;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDI_BRASIL;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_TELEFONE;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.TAMANHO_FIXO_CODIGOIBGE;
import static br.com.contmatic.prova.constantes.model.CidadeConstantes.TAMANHO_FIXO_UNIDADE_FEDERATIVA;
import static br.com.contmatic.prova.constantes.utils.ConstantesTestes.CARACTER_ESPECIAL;
import static br.com.contmatic.prova.constantes.utils.ConstantesTestes.MAIS_CEM_CARACTERES;
import static br.com.contmatic.prova.constantes.utils.ConstantesTestes.TRES_CARACTERES_ALFABETICOS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.constantes.utils.ConstantesTestes;
import br.com.contmatic.prova.constantes.utils.GeradorCaracteres;
import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.contato.Telefone;
import br.com.contmatic.prova.model.endereco.Cidade;

public class CidadeTest {

    private Cidade cidadeConstrutor;

    private IllegalStateException illegalState;

    private IllegalArgumentException illegalArgument;

    private Cidade cidadeConstrutor2;

    @BeforeEach
    public void montarObjetos() {
        cidadeConstrutor = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP);
        cidadeConstrutor2 = new Cidade(CODIGO_IBGE_PINDAMONHANGABA, MUNICIPIO_PINDAMONHANGABA, UNIDADE_FEDERATIVA_SP);
        gerarAuditoria(cidadeConstrutor);
        gerarAuditoria(cidadeConstrutor2);
    }

    private void gerarAuditoria(Cidade cidade) {
        Contato contato = new Contato(GeradorCaracteres.gerarEmail(4), new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_TELEFONE));
        cidadeConstrutor.setContatoCriacao(contato);
        cidadeConstrutor.setContatoAlteracao(contato);
        cidadeConstrutor.setDataCriacao(LocalDateTime.now());
        cidadeConstrutor.setDataAlteracao(LocalDateTime.now());
        cidadeConstrutor.setIpCriacao(IP_VALIDO);
        cidadeConstrutor.setIpAlteracao(IP_VALIDO);

    }

    @AfterAll
    public static void finalizacao() {
        System.out.println("Fim dos testes Cidade");
    }

    @Test
    void nao_deve_aceitar_campo_nome_nulo_codigoIbge() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setCodigoIbge(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_campo_vazio_nome_codigoIbge(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCodigoIbge(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @ParameterizedTest
    @ValueSource(strings = { ConstantesTestes.MAIS_CIQUENTA_NUMEROS, "224" })
    void nao_deve_aceitar_caracteres_diferente_sete_codigoIbge(String codigoErrado) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCodigoIbge(codigoErrado));
        assertTrue(illegalState.getMessage().contains(
            "Quantidade de carácteres inválido! O campo deve possuir apenas " + TAMANHO_FIXO_CODIGOIBGE + " caracteres" + ", atualmente o campo possui " + codigoErrado.length() + " caractere(s)"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc1221", "35380O6", "35E8006", "3538@06", "35$8006" })
    void nao_deve_aceitar_caracter_diferente_numerico_codigoIbge(String codigoErrado) {
        illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCodigoIbge(codigoErrado));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ALFABETICO_ESPECIAL));
    }

    @Test
    void nao_deve_aceitar_campo_nome_nulo_municipio() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setMunicipio(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_campo_vazio_nome_municipio(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_mais_cem_caracteres_municipio() {
        assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(MAIS_CEM_CARACTERES));
    }

    @ParameterizedTest
    @ValueSource(strings = { "a", "ab", "@" })
    void nao_deve_aceitar_menos_tres_caracteres_municipio(String caracterInvalido) {
        assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(caracterInvalido));
    }

    @ParameterizedTest
    @ValueSource(strings = { "cidade2", "São Pau1o" })
    void nao_deve_aceitar_caracter_numerico_municipio(String municioErrado) {
        illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(municioErrado));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
    }

    @Test
    void nao_deve_aceitar_caracter_especial_municipio() {
        illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setMunicipio(CARACTER_ESPECIAL));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
    }

    @Test
    void nao_deve_aceitar_campo_nome_nulo_unidadeFederativa() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_campo_vazio_unidadeFederativa(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_diferente_sete_caracteres_unidadeFederativa() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(TRES_CARACTERES_ALFABETICOS));
        assertTrue(illegalState.getMessage().contains("Quantidade de carácteres inválido! O campo deve possuir apenas " + TAMANHO_FIXO_UNIDADE_FEDERATIVA + " caracteres" +
            ", atualmente o campo possui " + TRES_CARACTERES_ALFABETICOS.length() + " caractere(s)"));
    }

    @Test
    void nao_deve_aceitar_caracter_numerico_unidadeFederativa() {
        illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa("11"));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "2&", "a!", "@3" })
    void nao_deve_aceitar_caracter_especial_unidadeFederativa(String caracterInvalido) {
        illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setUnidadeFederativa(caracterInvalido));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_POSSUI_CARACTER_ESPECIAL_NUMERICO));
    }

    @Test
    void nao_deve_aceitar_nulo_municipio() {
        illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setMunicipio(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void deve_validar_codigoIbge() {
        assertEquals(CODIGO_IBGE_SAO_PAULO, this.cidadeConstrutor.getCodigoIbge());
    }

    @Test
    void deve_validar_municio() {
        assertEquals(MUNICIPIO_SAO_PAULO, this.cidadeConstrutor.getMunicipio());
    }

    @Test
    void deve_validar_unidadeFederativa() {
        assertEquals(UNIDADE_FEDERATIVA_SP, this.cidadeConstrutor.getUnidadeFederativa());
    }

    @Test
    void nao_deve_aceitar_hashcode_diferente() {
        assertThat(cidadeConstrutor2.hashCode(), is(not(this.cidadeConstrutor.hashCode())));
    }

    /* Auditoria */

    @Test
    void deve_validar_hashcode_iguais() {
        assertThat(cidadeConstrutor.hashCode(), is(this.cidadeConstrutor.hashCode()));
    }

    @Test
    void deve_validar_equals() {
        assertEquals(this.cidadeConstrutor, this.cidadeConstrutor);
        assertEquals(this.cidadeConstrutor, this.cidadeConstrutor);
        assertNotNull(this.cidadeConstrutor);
        assertNotEquals(cidadeConstrutor, new Object());
    }

    @Test
    void deve_validar_toString() {
        assertEquals("Cidade [codigoIbge = " + CODIGO_IBGE_SAO_PAULO + ", municipio = " + MUNICIPIO_SAO_PAULO + ", unidadeFederativa = " + UNIDADE_FEDERATIVA_SP + "]", cidadeConstrutor.toString());
    }
}
