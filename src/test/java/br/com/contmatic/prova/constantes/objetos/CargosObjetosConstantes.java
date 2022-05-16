package br.com.contmatic.prova.constantes.objetos;

import static br.com.contmatic.prova.constantes.objetos.listas.SerializacaoListas.FUNCIONARIOS;

import java.math.BigDecimal;
import java.util.List;

import br.com.contmatic.prova.model.empresa.Cargo;
import br.com.contmatic.prova.model.empresa.Funcionario;

public class CargosObjetosConstantes {
    public static final String NOME_CARGOS = "Gerente de projetos de tecnologia da informação";
    public static final String CBO_CARGOS = "142520";
    public static final String CBO_ANALISTA_TI = "2124";
    public static final String DESCRICAO_CARGOS = "Cargo de gerente";
    public static final BigDecimal SALARIO_CARGOS = BigDecimal.valueOf(14000.60);
    public static final BigDecimal SALARIO_CARGOS_ANALISTAS = BigDecimal.valueOf(1400.60);
    public static final Cargo CARGO_01 = gerarCargo(NOME_CARGOS, CBO_CARGOS, SALARIO_CARGOS, DESCRICAO_CARGOS, FUNCIONARIOS);
    public static final Cargo CARGO_02 = gerarCargo(NOME_CARGOS, CBO_ANALISTA_TI, SALARIO_CARGOS_ANALISTAS, DESCRICAO_CARGOS, FUNCIONARIOS);

    private static Cargo gerarCargo(String nome, String cbo, BigDecimal salario, String descricao, List<Funcionario> funcionarios) {
        return new Cargo(nome, cbo, salario, descricao, funcionarios);
    }
}
