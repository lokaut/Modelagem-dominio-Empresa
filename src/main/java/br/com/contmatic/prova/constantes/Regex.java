package br.com.contmatic.prova.constantes;

public class Regex {
    private Regex() {}
    
    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String REGEX_CARACTERES_ALFABETICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";
    public static final String REGEX_CARACTERES_ALFABETICOS_NUMERICOS_ACENTOS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ0-9 ]+$";
    public static final String REGEX_ALFANUMERICOS = "^[\\d]+$";
    public static final String REGEX_ALFABETICO_SEM_ACENTO = "^[A-Zaz_]+$";
    public static final String REGEX_DDD = "^([1-9]{2})$";
    public static final String REGEX_DDI = "^([0-9]{1,3})$";
    public static final String REGEX_TELEFONE = "^9?[0-9]{8}$";
    public static final String REGEX_IP = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
}