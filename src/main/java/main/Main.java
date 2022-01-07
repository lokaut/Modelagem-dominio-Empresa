package main;

import static com.contimatic.prova.constantes.Constantes.CODIGO_IBGE_SAO_PAULO;

import com.contimatic.prova.model.Cidade;

public class Main {
	public static void main(String[] args) {
		String codigoIbge = CODIGO_IBGE_SAO_PAULO;
		String municipio = "São Paulo";
		String unidadeFederativa = "SP";

		String codigoErradoIbge = "123345678";
		String caracterEspecial = "@@@$$$!";
		String mais100Caracters = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcababcabcabcabcabcabcabcabcabcabcabcabcabcabcab";
		String ufErrado = "abc";
		Cidade cidadeConstrutor = new Cidade(codigoIbge, municipio, unidadeFederativa);

		Cidade cidade = new Cidade();
		
		//System.out.println(cidadeConstrutor.toString());
		System.out.println(codigoErradoIbge.substring(0, 2));

	}

}
