package br.com.contmatic.prova.constantes;

import java.time.LocalDate;

import br.com.contmatic.prova.constantes.utils.GeradorCpfCnpj;

public class FuncionarioConstantes {
    public static final String CPF_VALIDO = "76899070081";
    public static final String CPF_VALIDO_ALEATORIO = GeradorCpfCnpj.gerarCpf();
    public static final String NOME_COMPLETO = "Lókaut Santos";
    public static final LocalDate DATA_NASCIMENTO_VALIDO = LocalDate.of(1994, 12, 05);
    public static final LocalDate DATA_ADMISSAO = LocalDate.of(2021, 11, 04);
}