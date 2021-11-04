package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_ADMISSAO_FUTURA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.REGRA_DATA_ADMISSAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoData {
	
	private ValidacaoData(){}
	
	public static void dataNascMaiorIdade(LocalDate idade) {
		LocalDate dataHoje = LocalDate.now();
		long anos = ChronoUnit.YEARS.between(idade, dataHoje);
		
		if(anos < IDADE_MINIMA_EMPRESA) {
			throw new IllegalStateException(MENSAGEM_IDADE_MINIMA_EMPRESA);
		}
	}
	
	public static void validacaoDataAdmissao(LocalDate dataAdmissao){
		if(dataAdmissao.isAfter(LocalDate.now().plusMonths(REGRA_DATA_ADMISSAO))) {
			throw new IllegalArgumentException(MENSAGEM_ADMISSAO_FUTURA);
		}
	}
	
	
}

