package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DDD_INCORRETO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DDI_INCORRETO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_TELEFONE_INCORRETO;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_CEARA;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD_SAO_PAULO;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDI_BRASIL;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_CELULAR;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.NUMERO_TELEFONE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.model.contato.Telefone;

public class TelefoneTest {

    private Telefone telefone;

    private Telefone telefoneDddSaoPaulo;

    private Telefone celular;

    private Telefone celular2;

    private Telefone celularDddSaoPaulo;

    private IllegalStateException illegalState;

    private IllegalArgumentException illegalArgument;

    @BeforeEach
    public void instancia() {
        telefone = new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_TELEFONE);
        telefoneDddSaoPaulo = new Telefone(DDI_BRASIL, DDD_SAO_PAULO, NUMERO_TELEFONE);
        celular = new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_CELULAR);
        celular2 = new Telefone(DDI_BRASIL, DDD_CEARA, NUMERO_CELULAR);
        celularDddSaoPaulo = new Telefone(DDI_BRASIL, DDD_SAO_PAULO, NUMERO_CELULAR);
    }

    @AfterAll
    public static void finalizacao() {
        System.out.println("Fim dos testes Telefone");
    }

    @ParameterizedTest
    @ValueSource(strings = { "09", "0934", "3", "0", "00" })
    void nao_deve_aceitar_ddd_inexistente(String dddInexistente) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdd(dddInexistente));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DDD_INCORRETO));
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "", "      " })
    void nao_deve_aceitar_em_branco_ddd(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdd(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_ddd_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.telefone.setDdd(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "0933", "-3", "8888888" })
    void nao_deve_aceitar_ddi_inexistente(String ddiInexistente) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdi(ddiInexistente));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DDI_INCORRETO));
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "", "      " })
    void nao_deve_aceitar_em_branco_ddi(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setDdi(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_ddi_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.telefone.setDdi(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "09", "9544334", "000000", "0", "000000000", })
    void nao_deve_aceitar_telefone_inexistente(String telefone) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumero(telefone));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "", "      " })
    void nao_deve_aceitar_em_branco_numero_telefone(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumero(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "abdtt066f", "abcdefghi", "0000abbb00", "0" })
    void nao_deve_aceitar_telefone_caracteres_alfabeticos(String telefone) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.celular.setNumero(telefone));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_TELEFONE_INCORRETO));
    }

    @Test
    void deve_validar_ddi() {
        assertEquals(DDI_BRASIL, this.telefone.getDdi());
    }

    @Test
    void deve_validar_ddd() {
        assertEquals(DDD_CEARA, this.telefone.getDdd());
    }

    @Test
    void deve_validar_telefone() {
        assertEquals(NUMERO_TELEFONE, this.telefone.getNumero());
    }

    @Test
    void deve_validar_equals() {
        assertEquals(celular, celular2);
        assertEquals(celular, celular);
        assertNotEquals(celular, telefone);
        assertNotEquals(null, celular);
        assertNotEquals(true, celular.equals(new Object()));
        assertNotEquals(telefone, celularDddSaoPaulo);
    }

    @Test
    void deve_validar_hashcode() {
        assertEquals(celular.hashCode(), celular2.hashCode());
        assertNotEquals(telefoneDddSaoPaulo.hashCode(), telefone.hashCode());
        assertNotEquals(celular.hashCode(), telefone.hashCode());
        assertNotEquals(telefoneDddSaoPaulo.hashCode(), celularDddSaoPaulo.hashCode());
    }

    @Test
    void deve_validar_toString() {
        assertAll(
            () -> assertThat(telefone.toString(), containsString(telefone.getDdd())),
            () -> assertThat(celular.toString(), containsString(celular.getNumero()))
                );
    }

}
