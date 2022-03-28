package br.com.contmatic.prova.constantes;

public class Regex {
    public static final String REGEX_CARACTERES_ALFABETICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";
    public static final String REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ0-9 ]+$";
    public static final String REGEX_ALFANUMERICOS = "^[\\d]+$";
    public static final String REGEX_ALFABETICO_SEM_ACENTO = "^[A-Zaz_]+$";
    public static final String REGEX_DDD = "^([1-9]{2})$";
    public static final String REGEX_TELEFONE = "^9?[0-9]{8}$";
}