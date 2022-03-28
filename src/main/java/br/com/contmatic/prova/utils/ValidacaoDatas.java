package br.com.contmatic.prova.utils;

import br.com.contmatic.prova.constantes.Mensagem;
import br.com.contmatic.prova.constantes.RegrasEmpresa;

import static br.com.contmatic.prova.constantes.RegrasEmpresa.IDADE_MINIMA_EMPRESA;
import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;

public final class ValidacaoDatas {
	private ValidacaoDatas() {}

	public static void dataNascMaiorIdade(LocalDate dataNascimento) {
		LocalDate dataAtual = now();
		long anos = YEARS.between(dataNascimento, dataAtual);
		if (anos < IDADE_MINIMA_EMPRESA) {
			throw new IllegalStateException(Mensagem.MENSAGEM_IDADE_MINIMA_EMPRESA);
		}
	}

	public static void validarDataAdmissao(LocalDate dataAdmissao) {
		LocalDate doisMesesPosDataAtual = now().plusMonths(RegrasEmpresa.REGRA_DATA_ADMISSAO);
		if (dataAdmissao.isAfter(doisMesesPosDataAtual)) {
			throw new IllegalStateException(Mensagem.MENSAGEM_ADMISSAO_FUTURA);
		}
	}
	
	public static void validarDesligamento(LocalDate dataDesligamento) {
		if (dataDesligamento.isBefore(now())) {
			throw new IllegalStateException(Mensagem.MENSAGEM_DESLIGAMENTO_ANTES_DATA_ATUAL);
		}
	}
	
	public static void validarDataMaiorDataAtual(LocalDate dataFutura) {
		LocalDate dataAtual = now();
		if (dataFutura.isAfter(dataAtual)) {
			throw new IllegalStateException(Mensagem.MENSAGEM_DATA_FUTURA);
		}
	}

}
