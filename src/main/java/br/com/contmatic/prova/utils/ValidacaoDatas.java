package br.com.contmatic.prova.utils;

import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_ADMISSAO_FUTURA;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DATA_FUTURA;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_DESLIGAMENTO_ANTES_DATA_ATUAL;
import static br.com.contmatic.prova.constantes.Mensagem.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.IDADE_MINIMA_EMPRESA;
import static br.com.contmatic.prova.constantes.RegrasEmpresa.REGRA_DATA_ADMISSAO;
import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class ValidacaoDatas {
	private ValidacaoDatas() {}

	public static void dataNascMaiorIdade(LocalDate dataNascimento) {
		LocalDate dataAtual = now();
		long anos = YEARS.between(dataNascimento, dataAtual);
		if (anos < IDADE_MINIMA_EMPRESA) {
			throw new IllegalStateException(MENSAGEM_IDADE_MINIMA_EMPRESA);
		}
	}

	public static void validarDataAdmissao(LocalDate dataAdmissao) {
		LocalDate doisMesesPosDataAtual = now().plusMonths(REGRA_DATA_ADMISSAO);
		if (dataAdmissao.isAfter(doisMesesPosDataAtual)) {
			throw new IllegalStateException(MENSAGEM_ADMISSAO_FUTURA);
		}
	}
	
	public static void validarDesligamento(LocalDate dataDesligamento) {
		if (dataDesligamento.isBefore(now())) {
			throw new IllegalStateException(MENSAGEM_DESLIGAMENTO_ANTES_DATA_ATUAL);
		}
	}
	
	public static void validarDataMaiorDataAtual(LocalDate dataFutura) {
		LocalDate dataAtual = now();
		if (dataFutura.isAfter(dataAtual)) {
			throw new IllegalStateException(MENSAGEM_DATA_FUTURA);
		}
	}
	
    public static void validarDateTimeMaiorDateTimeAtual(LocalDateTime dataFutura) {
        validarDataMaiorDataAtual(dataFutura.toLocalDate());
    }

}
