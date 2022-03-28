package br.com.contmatic.prova.constantes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegraEmpresa {
    public static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1210.0);
    public static final long IDADE_MINIMA_EMPRESA = 16;
    public static final LocalDate FUNDACAO_EMPRESA = LocalDate.of(1988, 10, 05);
    public static final int REGRA_DATA_ADMISSAO = 2;
    public static final String DATA_ATUAL = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
}