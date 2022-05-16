package br.com.contmatic.prova.utils;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contmatic.prova.constantes.Regex.REGEX_EMAIL;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.SALARIO_MINIMO;
import static java.util.regex.Pattern.CASE_INSENSITIVE;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidacaoUtils {

    private ValidacaoUtils() {
    }

    public static <T> void verificarNulo(T objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException(MENSAGEM_CAMPO_NULO);
        }
    }

    public static void campoOpcional(String nome, int minimo, int maximo) {
        if (nome != null) {
            if (minimo != maximo) {
                limiteCaracteresMinimoMaximo(nome, minimo, maximo);
            } else {
                limiteCaracteresFixo(nome, minimo);
            }
        }
    } 

    public static void limiteCaracteresFixo(String nome, int tamanho) {
        if (nome.length() != tamanho) {
            StringBuilder builderIllegalState = new StringBuilder();
            builderIllegalState.append("Quantidade de carácteres inválido! O campo deve possuir apenas ");
            builderIllegalState.append(tamanho);
            builderIllegalState.append(" caracteres, atualmente o campo possui ");
            builderIllegalState.append(nome.length());
            builderIllegalState.append(" caractere(s)");
            throw new IllegalStateException(builderIllegalState.toString());
        }
    }

    public static void limiteCaracteresMinimoMaximo(String nome, int minimo, int maximo) {
        if (nome.length() < minimo || nome.length() > maximo) {
            StringBuilder builderIllegalState = new StringBuilder();
            builderIllegalState.append("Quantidade de carácter inválido, o campo deve estar entre ");
            builderIllegalState.append(minimo);
            builderIllegalState.append(" a ");
            builderIllegalState.append(maximo);
            builderIllegalState.append(" caracteres, atualmente o campo possui ");
            builderIllegalState.append(nome.length());
            throw new IllegalStateException(builderIllegalState.toString());
        }
    }

    public static void validarCampoVazio(String nome) {
        if (nome.isBlank()) {
            throw new IllegalStateException(MENSAGEM_CAMPO_VAZIO);
        }
    }

    public static void validarEmail(String email) {
        Matcher matcher = Pattern.compile(REGEX_EMAIL, CASE_INSENSITIVE).matcher(email);
        if (!matcher.matches()) {
            throw new IllegalStateException(MENSAGEM_EMAIL_INVALIDO);
        }
    }

    public static void validarSalarioMinimo(BigDecimal salario) {
        BigDecimal diferencaSalario = salario.subtract(SALARIO_MINIMO);
        if (diferencaSalario.signum() == -1) {
            throw new IllegalStateException(MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO);
        }
    }

    public static void validarCaracteresPermitidos(String campo, String regex, String mensagemErro) {
        if (!campo.matches(regex)) {
            throw new IllegalStateException(mensagemErro);
        }
    }

    public static <E> void validarListaVazia(List<E> lista) {
        if (lista.isEmpty()) {
            throw new IllegalStateException(MENSAGEM_CAMPO_VAZIO);
        }
    }

    public static <E> void validarTamanhoMaximoLista(List<E> lista, int tamanho) {
        if (lista.size() > tamanho) {
            throw new IllegalStateException(MENSAGEM_NUMERO_EXCEDIDO_LISTA);
        }
    }
}
