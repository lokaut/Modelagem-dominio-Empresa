package br.com.contmatic.prova.utils;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_NULO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CAMPO_VAZIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_EMAIL_INVALIDO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_ESPACO_DESNECESSARIO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_MENOR_SALARIO_SALARIO_MINIMO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_NUMERO_EXCEDIDO_LISTA;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_NUMERO_RESIDENCIAL_INVALIDO;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_OBJETO_CRIADO;
import static br.com.contmatic.prova.constantes.Regex.REGEX_EMAIL;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.SALARIO_MINIMO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.regex.Pattern.CASE_INSENSITIVE;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidacaoUtils {

    private ValidacaoUtils() {
    }

    public static <T> void verificarNulo(T objeto, String nomeAtributo) {
        if (isNull(objeto)) {
            throw new IllegalArgumentException(nomeAtributo + MENSAGEM_CAMPO_NULO);
        }
    }

    public static void campoOpcional(String nome, int minimo, int maximo, String atributo) {
        if (nonNull(nome) && minimoMaximo(minimo, maximo)) {
            limiteCaracteresMinimoMaximo(nome, atributo, minimo, maximo);
        }
    }

    private static boolean minimoMaximo(int minimo, int maximo) {
        return minimo != maximo;
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

    public static void limiteCaracteresMinimoMaximo(String nome, String atributo, int minimo, int maximo) {
        if (nome.length() < minimo || nome.length() > maximo) {
            StringBuilder builderIllegalState = new StringBuilder();
            builderIllegalState.append("Quantidade de carácter inválido, o campo ");
            builderIllegalState.append(atributo);
            builderIllegalState.append(" deve possuir ");
            builderIllegalState.append(minimo);
            builderIllegalState.append(" a ");
            builderIllegalState.append(maximo);
            builderIllegalState.append(" caracteres, atualmente o campo possui ");
            builderIllegalState.append(nome.length());
            throw new IllegalStateException(builderIllegalState.toString());
        }
    }

    public static void validarCampoVazio(String nome, String nomeAtributo) {
        if (nome.isBlank()) {
            throw new IllegalStateException(nomeAtributo + MENSAGEM_CAMPO_VAZIO);
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

    public static void validarCaracteresPermitidos(String campo, String regex, String mensagemErro, String atributo) {
        if (!campo.matches(regex)) {
            throw new IllegalStateException(atributo + mensagemErro);
        }
    }

    public static <E> void validarListaVazia(List<E> lista, String atributos) {
        if (lista.isEmpty()) {
            throw new IllegalStateException(atributos + MENSAGEM_CAMPO_VAZIO);
        }
    }

    public static <E> void validarTamanhoMaximoLista(List<E> lista, int tamanho, String atributos) {
        if (lista.size() > tamanho) {
            throw new IllegalStateException(atributos + MENSAGEM_NUMERO_EXCEDIDO_LISTA);
        }
    }

    public static void validarCaracteresRepetidos(String texto, String mensagem) {
        char primeiroCaracter = texto.charAt(1);
        String textoRepetido = Character.toString(primeiroCaracter).repeat(texto.length());
        if (textoRepetido.equals(texto)) {
            throw new IllegalStateException(mensagem);
        }
    }

    public static <T> void validarSeExiste(T existente) {
        if (nonNull(existente)) {
            throw new IllegalStateException(MENSAGEM_OBJETO_CRIADO);
        }
    }

    public static void validarNumeroResidencial(Integer numero) {
        if (numero < 0) {
            throw new IllegalStateException(MENSAGEM_NUMERO_RESIDENCIAL_INVALIDO);
        }
    }

    public static void validarEspacoDesnecessario(String nome) {
        int tamanhoAtributoFormatado = nome.strip().length();
        if (nome.length() != tamanhoAtributoFormatado) {
            throw new IllegalStateException(nome + MENSAGEM_ESPACO_DESNECESSARIO);
        }
    }

}
