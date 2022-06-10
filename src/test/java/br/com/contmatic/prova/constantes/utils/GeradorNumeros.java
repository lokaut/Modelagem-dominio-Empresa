package br.com.contmatic.prova.constantes.utils;

import java.util.Random;

public final class GeradorNumeros {

    public static Integer gerarNumeros(Integer numeroLimite, Boolean positivo) {
        Random gerador = new Random();
        if (positivo) {
            return gerador.nextInt(numeroLimite);
        } else {
            return gerador.nextInt(numeroLimite) * -1;
        }

    }
}
