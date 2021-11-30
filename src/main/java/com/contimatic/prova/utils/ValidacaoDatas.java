package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_ADMISSAO_FUTURA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.REGRA_DATA_ADMISSAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class ValidacaoDatas {
	private ValidacaoDatas() {}

	public static void dataNascMaiorIdade(LocalDate idade) {
		long anos = ChronoUnit.YEARS.between(idade, LocalDate.now());

		if (anos < IDADE_MINIMA_EMPRESA) {
			throw new IllegalStateException(MENSAGEM_IDADE_MINIMA_EMPRESA);
		}
	}

	public static void validacaoDataAdmissao(LocalDate dataAdmissao) {
		LocalDate doisMesesPosDataAtual = LocalDate.now().plusMonths(REGRA_DATA_ADMISSAO);
		if (dataAdmissao.isAfter(doisMesesPosDataAtual)) {
			throw new IllegalStateException(MENSAGEM_ADMISSAO_FUTURA);
		}
	}

}
