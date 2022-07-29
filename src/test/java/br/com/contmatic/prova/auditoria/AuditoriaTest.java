package br.com.contmatic.prova.auditoria;

import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_PINDAMONHANGABA;
import static br.com.contmatic.prova.constantes.CidadeConstantes.CODIGO_IBGE_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_PINDAMONHANGABA;
import static br.com.contmatic.prova.constantes.CidadeConstantes.MUNICIPIO_SAO_PAULO;
import static br.com.contmatic.prova.constantes.CidadeConstantes.UNIDADE_FEDERATIVA_SP;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DATA_FUTURA;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_IP_INVALIDO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_OBJETO_CRIADO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.IP_FORMATADO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.IP_NAO_FORMATADO;
import static br.com.contmatic.prova.constantes.utils.GeradorCaracteres.gerarEmail;
import static br.com.contmatic.prova.model.contato.Emailtype.PESSOAL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.model.contato.Email;
import br.com.contmatic.prova.model.endereco.Cidade;

public class AuditoriaTest {

    private IllegalStateException illegalState;

    private IllegalArgumentException illegalArgument;

    private Cidade cidadeConstrutor;

    private Cidade cidadeAuditoria;

    private Email email;

    @BeforeEach
    public void montarObjetos() {
        email = new Email(gerarEmail(4), PESSOAL);
        cidadeConstrutor = new Cidade(CODIGO_IBGE_SAO_PAULO, MUNICIPIO_SAO_PAULO, UNIDADE_FEDERATIVA_SP);
        cidadeAuditoria = new Cidade(CODIGO_IBGE_PINDAMONHANGABA, MUNICIPIO_PINDAMONHANGABA, UNIDADE_FEDERATIVA_SP);
        cidadeAuditoria.setCreateBy(email);
        cidadeAuditoria.setIpCriacao(IP_FORMATADO);
    }

    @AfterAll
    public static void finalizacao() {
        System.out.println("Fim dos testes Auditoria");
    }

    @Test
    void nao_deve_aceitar_nulo_creatby() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setCreateBy(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_creatby_mais_uma_vez() {
        this.cidadeConstrutor.setCreateBy(new Email(gerarEmail(4), PESSOAL));
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setCreateBy(email));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_OBJETO_CRIADO));
    }

    @Test
    void deve_validar_creatby() {
        this.cidadeConstrutor.setCreateBy(email);
        assertEquals(email, cidadeConstrutor.getcreatedBy());
    }

    @Test
    void nao_deve_aceitar_nulo_lastModifiedBy() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setLastModifiedBy(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void deve_validar_lastModifiedBy() {
        this.cidadeConstrutor.setLastModifiedBy(email);
        assertEquals(email, cidadeConstrutor.getLastModifiedBy());
    }

    @Test
    void nao_deve_aceitar_nulo_dataCriacao() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setDataCriacao(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_dataCriacao_mais_uma_vez() {
        this.cidadeConstrutor.setDataCriacao(LocalDateTime.now());
        LocalDateTime agora = LocalDateTime.now();
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setDataCriacao(agora));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_OBJETO_CRIADO));
    }

    @Test
    void nao_deve_aceitar_dataCriacao_maior_que_dia_hoje() {
        LocalDateTime futuro = LocalDateTime.now().plusDays(1);
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setDataCriacao(futuro));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DATA_FUTURA));
    }

    @Test
    void deve_validar_dataCriacao() {
        LocalDateTime agora = LocalDateTime.now();
        this.cidadeConstrutor.setDataCriacao(agora);
        assertEquals(agora, cidadeConstrutor.getDataCriacao());
    }

    @Test
    void nao_deve_aceitar_dataAlteracao_maior_que_dia_hoje() {
        LocalDateTime futuro = LocalDateTime.now().plusDays(1);
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setDataAlteracao(futuro));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_DATA_FUTURA));
    }

    @Test
    void nao_deve_aceitar_nulo_dataAlteracao() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setDataAlteracao(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void deve_validar_dataAltercao() {
        LocalDateTime agora = LocalDateTime.now();
        this.cidadeConstrutor.setDataAlteracao(agora);
        assertEquals(agora, cidadeConstrutor.getDataAlteracao());
    }

    @Test
    void nao_deve_aceitar_Ip_nulo_Ipcriacao() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setIpCriacao(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_Ip_sem_formatacao_IpCriacao() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpCriacao(IP_NAO_FORMATADO));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IP_INVALIDO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_Ip_vazio_Ipcriacao(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpCriacao(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    void nao_deve_aceitar_IpCriacao_mais_uma_vez() {
        this.cidadeConstrutor.setIpCriacao(IP_FORMATADO);
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpCriacao("127.87.171.98"));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_OBJETO_CRIADO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "192.168.3.888.888", "192.168.888" })
    void nao_deve_aceitar_IpCriacao_fora_range(String ip) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpCriacao(ip));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IP_INVALIDO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "256.255.3.255", "256.256.256.257" })
    void nao_deve_aceitar_IpCriacao_acima_255(String ip) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpCriacao(ip));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IP_INVALIDO));
    }

    @Test
    void deve_validar_IpCriacao() {
        this.cidadeConstrutor.setIpCriacao(IP_FORMATADO);
        assertEquals(IP_FORMATADO, cidadeConstrutor.getIpCriacao());
    }

    /* IpAlteracao */
    @Test
    void nao_deve_aceitar_Ip_nulo_IpAlteracao() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> this.cidadeConstrutor.setIpAlteracao(null));
        assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @Test
    void nao_deve_aceitar_Ip_sem_formatacao_IpAlteracao() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpAlteracao(IP_NAO_FORMATADO));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IP_INVALIDO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void nao_deve_aceitar_Ip_vazio_IpAlteracao(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpAlteracao(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "192.168.3.888.888", "192.168.888" })
    void nao_deve_aceitar_IpAlteracao_fora_range(String ip) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpAlteracao(ip));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IP_INVALIDO));
    }

    @ParameterizedTest
    @ValueSource(strings = { "256.255.3.255", "256.256.256.257" })
    void nao_deve_aceitar_IpAlteracao_acima_255(String ip) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.cidadeConstrutor.setIpAlteracao(ip));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_IP_INVALIDO));
    }

    @Test
    void deve_validar_IpAlteracao() {
        this.cidadeConstrutor.setIpAlteracao(IP_FORMATADO);
        assertEquals(IP_FORMATADO, cidadeConstrutor.getIpAlteracao());
    }

    @Test
    void deve_validar_toString() {
        assertAll(() -> assertThat(cidadeAuditoria.toString(), containsString(cidadeAuditoria.getcreatedBy().toString())),
            () -> assertThat(cidadeAuditoria.toString(), containsString(cidadeAuditoria.getIpCriacao())));
    }

}
