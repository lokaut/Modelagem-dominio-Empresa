package br.com.contimatic.prova;

import static br.com.contimatic.prova.ConstantesTestes.CNPJ_VALIDO;
import static br.com.contimatic.prova.ConstantesTestes.CNPJ_VALIDO_ALEATORIO;
import static br.com.contimatic.prova.ConstantesTestes.CONTATOS;
import static br.com.contimatic.prova.ConstantesTestes.ENDERECOS;
import static br.com.contimatic.prova.ConstantesTestes.NOME_FANTASIA;
import static br.com.contimatic.prova.ConstantesTestes.RAZAO_SOCIAL;
import static br.com.contimatic.prova.ConstantesTestes.SETORES;
import static br.com.contimatic.prova.constantes.Constantes.FUNDACAO_EMPRESA;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_NULO;
import static br.com.contimatic.prova.constantes.Constantes.MENSAGEM_CAMPO_VAZIO;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.contimatic.prova.model.Contato;
import br.com.contimatic.prova.model.Empresa;
import br.com.contimatic.prova.model.Endereco;
import br.com.contimatic.prova.model.Setor;

public class EmpresaTest {
	
	private List<Setor> setoresVazio;
	
	private List<Contato> contatosVazio;
	
	private List<Endereco> enderecosVazio;
	
	private Empresa empresaCompleta;
	
	private Empresa empresa;
	
	private IllegalStateException illegalState;
	
	private IllegalArgumentException illegalArgument;
	

	@BeforeEach
	public void instanciar() {
		setoresVazio = new ArrayList<>();
		contatosVazio = new ArrayList<>();
		enderecosVazio = new ArrayList<>();
		empresa = new Empresa(CNPJ_VALIDO);
		empresaCompleta = new Empresa(CNPJ_VALIDO_ALEATORIO, RAZAO_SOCIAL, NOME_FANTASIA, FUNDACAO_EMPRESA, SETORES, CONTATOS, ENDERECOS);
	}

	@AfterAll
	public static void finalizacao() {
		System.out.println("Fim dos testes Empresa");
	}
	
	@Test
	void nao_deve_aceitar_cnpj_nulo() {
		this.illegalArgument = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(null));
		assertTrue(this.illegalArgument.getMessage().contains(MENSAGEM_CAMPO_NULO));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "  "})
	void nao_deve_aceitar_campo_vazio_nome(String stringVazia) {
		this.illegalState = assertThrows(IllegalStateException.class, () -> empresa.setCnpj(stringVazia));
		assertTrue(this.illegalState.getMessage().contains(MENSAGEM_CAMPO_VAZIO));
	}
}
