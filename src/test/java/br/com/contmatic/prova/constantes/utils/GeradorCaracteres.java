package br.com.contmatic.prova.constantes.utils;

import java.util.Random;

public final class GeradorCaracteres {

    public static Integer gerarNumeros(Integer numeroLimite, Boolean positivo) {
        Random gerador = new Random();
        return positivo ? gerador.nextInt(numeroLimite) : gerador.nextInt(numeroLimite) * -1;
    }

    public static String gerarEmail(int quantidadeLetras) {
        Random random = new Random();
        StringBuffer string = new StringBuffer();
        for(int i = 0 ; i < quantidadeLetras ; i++) {
            char randomizedCharacter = (char) (random.nextInt(26) + 'a'); 
            string.append(randomizedCharacter);
        }
        string.append("@gmail.com");
        return string.toString();
    }

}
