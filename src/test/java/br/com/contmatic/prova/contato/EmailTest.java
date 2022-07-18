package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova.constantes.model.EmailConstantes.TAMANHO_MINIMO_EMAIL;
import static br.com.contmatic.prova.model.contato.Emailtype.PESSOAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contmatic.prova.constantes.utils.GeradorCaracteres;
import br.com.contmatic.prova.model.contato.Email;
import br.com.contmatic.prova.model.contato.Emailtype;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailTest {

    private IllegalStateException illegalState;

    private IllegalArgumentException illegalArgument;

    private Email email;

    private Email emailPessoal;

    private Email emailConstrutor2;

    private String enderecoEmail;

    @BeforeEach
    public void instancia() {
        email = new Email();
        enderecoEmail = GeradorCaracteres.gerarEmail(3);
        emailPessoal = new Email(enderecoEmail, PESSOAL);
        emailConstrutor2 = new Email(GeradorCaracteres.gerarEmail(6), Emailtype.COMERCIAL);
    }

    @AfterAll
    public static void finalizacao() {
        System.out.println("Fim dos testes E-mail");
    }

    @Test
    @Order(1)
    void nao_deve_aceitar_email_incorreto() {
        this.illegalState = assertThrows(IllegalStateException.class, () -> email.setEndereco("erick22@.com"));
        assertTrue(illegalState.getMessage().contains(MENSAGEM_EMAIL_INVALIDO));
    }

    @Test
    @Order(2)
    void nao_deve_aceitar_email_nulo() {
        this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> email.setEndereco(null));
        assertTrue(illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
    }

    @ParameterizedTest
    @Order(3)
    @ValueSource(strings = { " ", "", "      " })
    void nao_deve_aceitar_email_vazio(String stringVazia) {
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.email.setEndereco(stringVazia));
        assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
    }

    @Test
    @Order(4)
    void nao_deve_aceitar_email_mais_254_caracteres() {
        String email254 = GeradorCaracteres.gerarEmail(254);
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.email.setEndereco(email254));
        assertTrue(this.illegalState.getMessage().contains(
            "Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_EMAIL + " a " + TAMANHO_MAXIMO_EMAIL + " caracteres, atualmente o campo possui " + email254.length()));
    }

    @Test
    @Order(5)
    void nao_deve_aceitar_email_menos_4_caracteres() {
        String emailQuatroCaracteres = "e@r";
        this.illegalState = assertThrows(IllegalStateException.class, () -> this.email.setEndereco(emailQuatroCaracteres));
        assertTrue(this.illegalState.getMessage().contains("Quantidade de carácter inválido, o campo deve estar entre " + TAMANHO_MINIMO_EMAIL + " a " + TAMANHO_MAXIMO_EMAIL +
            " caracteres, atualmente o campo possui " + emailQuatroCaracteres.length()));
    }

    @Test
    @Order(6)
    void deve_aceitar_email_tipo_comercial() {
        emailPessoal.setEmailtype(Emailtype.COMERCIAL);
        assertEquals(Emailtype.COMERCIAL, emailPessoal.getEmailtype());
    }

    @Test
    @Order(7)
    void deve_aceitar_email_tipo_pessoal() {
        emailPessoal.setEmailtype(Emailtype.PESSOAL);
        assertEquals(Emailtype.PESSOAL, emailPessoal.getEmailtype());
    }

    @Test
    @Order(8)
    void deve_aceitar_email_correto() {
        assertEquals(enderecoEmail, emailPessoal.getEndereco());
    }

    @Test
    @Order(9)
    void deve_validar_hashcode_email() {
        email.setEndereco(enderecoEmail);
        assertEquals(emailPessoal.hashCode(), email.hashCode());
    }

    @Test
    @Order(10)
    void deve_validar_equals() {
        email.setEndereco(enderecoEmail);
        assertEquals(emailPessoal, email);
        assertEquals(emailPessoal, emailPessoal);
        assertNotEquals(null, emailPessoal);
        assertNotEquals(true, emailPessoal.equals(new Object()));
        assertNotEquals(emailPessoal, emailConstrutor2);
    }

    @Test
    @Order(11)
    void deve_validar_Tostring() {
        assertEquals("Email [endereco = " + enderecoEmail + ", emailtype = " + Emailtype.PESSOAL.name() + "]", emailPessoal.toString());
    }

}
