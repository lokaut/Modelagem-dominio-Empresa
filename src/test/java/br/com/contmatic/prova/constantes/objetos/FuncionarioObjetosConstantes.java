package br.com.contmatic.prova.constantes.objetos;

import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.utils.GeradorCpfCnpj;

import java.time.LocalDate;

public class FuncionarioObjetosConstantes {
    public static final String CPF_VALIDO = "76899070081";
    public static final String CPF_VALIDO_ALEATORIO = GeradorCpfCnpj.gerarCpf();
    public static final String NOME_COMPLETO = "Lókaut Santos";
    public static final LocalDate DATA_NASCIMENTO_VALIDO = LocalDate.of(1994, 12, 05);
    public static final LocalDate DATA_FUTURA = LocalDate.now().plusYears(1);
    public static final LocalDate DATA_ADMISSAO = LocalDate.of(2021, 11, 04);
    public static final LocalDate DATA_DESLIGAMENTO = LocalDate.now();
    public static final Funcionario FUNCIONARIO_01 = new Funcionario(GeradorCpfCnpj.gerarCpf());
    public static final Funcionario FUNCIONARIO_02 = new Funcionario(GeradorCpfCnpj.gerarCpf());
}