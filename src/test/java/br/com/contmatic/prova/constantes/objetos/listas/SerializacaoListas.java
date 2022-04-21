package br.com.contmatic.prova.constantes.objetos.listas;

import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.prova.constantes.objetos.ContatoObjetosConstantes;
import br.com.contmatic.prova.constantes.objetos.EnderecoObjetosConstantes;
import br.com.contmatic.prova.constantes.objetos.FuncionarioObjetosConstantes;
import br.com.contmatic.prova.constantes.objetos.SetorObjetosConstantes;
import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Endereco;

public final class SerializacaoListas {
	
	private SerializacaoListas(){}

	/*	Serialização para gerar listas */
	public static final List<Funcionario> FUNCIONARIOS = new ArrayList<>(){
		public static final long serialVersionUID = 1L;
	{
		add(FuncionarioObjetosConstantes.FUNCIONARIO_01);
		add(FuncionarioObjetosConstantes.FUNCIONARIO_02);
	}};
	
	public static final  List<Endereco> ENDERECOS = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(EnderecoObjetosConstantes.ENDERECO_01);
			add(EnderecoObjetosConstantes.ENDERECO_02);
		}
	};
	
	public static final List<Setor> SETORES = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(SetorObjetosConstantes.SETOR_01);
			add(SetorObjetosConstantes.SETOR_02);
		}
	};
	
	public static final List<Contato> CONTATOS = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(ContatoObjetosConstantes.CONTATO_01);
			add(ContatoObjetosConstantes.CONTATO_02);
		}
	};
}
