package br.com.contmatic.prova.utils;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_CNPJ_INVALIDO;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.NUMERO_ZERO_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.PESO_DEZ_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.PESO_DOIS_CPF_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.PESO_DOZE_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.PESO_ONZE_CPF;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.POSICAO_DOZE_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.POSICAO_TREZE_CNPJ;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.POSICAO_ZERO_ASCII;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.RESTO_UM;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.RESTO_ZERO;
import static br.com.contmatic.prova.constantes.RegrasCpfCnpj.TAMANHO_CNPJ;
import static br.com.contmatic.prova.utils.ValidacaoUtils.validarCaracteresRepetidos;

public final class ValidacaoCnpj {

    private ValidacaoCnpj() {
    }

    public static void validarCNPJ(String cnpj) {
        validarTamanho(cnpj);
        validarCaracteresRepetidos(cnpj, MENSAGEM_CNPJ_INVALIDO);
        verificarDigitos(cnpj);
    }

    private static void verificarDigitos(String cnpj) {
        char digVerificador13 = primeiroSegundoDigVerificador(cnpj, PESO_ONZE_CPF);
        char digVerificador14 = primeiroSegundoDigVerificador(cnpj, PESO_DOZE_CNPJ);
        if (!((digVerificador13 == cnpj.charAt(POSICAO_DOZE_CNPJ)) && (digVerificador14 == cnpj.charAt(POSICAO_TREZE_CNPJ)))) {
            throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);
        }
    }

    private static void validarTamanho(String cnpj) {
        if (cnpj.length() != TAMANHO_CNPJ) {
            throw new IllegalStateException(MENSAGEM_CNPJ_DIFERENTE_CATORZE_NUMEROS);
        }
    }

    private static char primeiroSegundoDigVerificador(String cnpj, int pesoVerificador) {
        int num = 0;
        int soma = 0;
        int peso = PESO_DOIS_CPF_CNPJ;
        for(int i = pesoVerificador ; i >= 0 ; i--) {
            num = (cnpj.charAt(i) - POSICAO_ZERO_ASCII);
            soma = soma + (num * peso);
            peso++;
            if (peso == PESO_DEZ_CPF_CNPJ) {
                peso = PESO_DOIS_CPF_CNPJ;
            }
        }
        return verificarOsDoisDigitosVerificador(soma);
    }

    private static char verificarOsDoisDigitosVerificador(int soma) {
        char digito;
        int resto = soma % MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ;
        if (resto == RESTO_ZERO || resto == RESTO_UM) {
            digito = NUMERO_ZERO_CPF_CNPJ;
        } else {
            digito = (char) ((MODULO_DIVISAO_VERIFICACAO_ONZE_CPF_CNPJ - resto) + POSICAO_ZERO_ASCII);
        }

        return digito;
    }
}
