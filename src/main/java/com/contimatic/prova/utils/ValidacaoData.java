package com.contimatic.prova.utils;

import static com.contimatic.prova.constantes.Constantes.IDADE_MINIMA_EMPRESA;
import static com.contimatic.prova.constantes.Constantes.MENSAGEM_IDADE_MINIMA_EMPRESA;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoData {

	public static void dataNascMaiorIdade(LocalDate data) {
		LocalDate dataAntes = data;
		LocalDate dateDepois = LocalDate.now();
		long anos = ChronoUnit.YEARS.between(dataAntes, dateDepois);
		
		if(anos < IDADE_MINIMA_EMPRESA) {
			throw new IllegalStateException(MENSAGEM_IDADE_MINIMA_EMPRESA);
		}
	}
	
	
}
