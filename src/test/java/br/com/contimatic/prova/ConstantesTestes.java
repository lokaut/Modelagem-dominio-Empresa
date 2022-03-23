package br.com.contimatic.prova;

import static br.com.contimatic.prova.utils.GeradorCpfCnpj.gerarCnpj;
import static br.com.contimatic.prova.utils.GeradorCpfCnpj.gerarCpf;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.contimatic.prova.model.Contato;
import br.com.contimatic.prova.model.Endereco;
import br.com.contimatic.prova.model.Funcionario;
import br.com.contimatic.prova.model.Setor;

public final class ConstantesTestes {
	
	private ConstantesTestes(){}
	
	protected static final String MAIS_SESSENTA_CARACTERES_ALFABETICOS = "Rua BastoRua BastoRua BastoRua BastoRua BastoRua BastoRua Basto";
	protected static final String CODIGO_ERRADO_IBGE = "123345678";
	protected static final String MAIS_CIQUENTA_NUMEROS= "123345678223594735739123345678223597357395935627500";
	protected static final String MAIS_CEM_CARACTERES = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcababcabcabcabcabcabcabcabcabcabcabcabcabcabcab";
	protected static final String CARACTER_ESPECIAL = "@@@$#@$";
	protected static final String TRES_CARACTERES_ALFABETICOS = "abc";
	protected static final String SETENTA_CINCO_CARACTERES_ALFABETICOS = "contmatic contmatic contmatic contmatic contmatic contmaticsss contmaticsss";
	protected static final String EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS = "erierick_tckemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2@gmail.com";
	protected static final String DOIS_CARACTERES = "ac";
	protected static final String NUMERO_CPF_INVALIDO = "44085620000";
	protected static final String ONZE_NUMEROS = "66998583340";
	protected static final String ONZE_NUMEROS_CARACTERES = "44a764b7f34";
	
	/*	CARGOS	*/
	protected static final String NOME_CARGOS = "Gerente de projetos de tecnologia da informação";
	protected static final String CBO_CARGOS = "142520";
	protected static final String CBO_ANALISTA_TI = "2124";
	protected static final String DESCRICAO_CARGOS = "Cargo de gerente";
	protected static final BigDecimal SALARIO_CARGOS = valueOf(14000.60);
	
	/*	CIDADE	*/
	protected static final String CODIGO_IBGE_SAO_PAULO = "3550308";
	protected static final String CODIGO_IBGE_PINDAMONHANGABA = "3538006";
	protected static final String MUNICIPIO_SAO_PAULO  = "São Paulo";
	protected static final String MUNICIPIO_PINDAMONHANGABA  = "Pindamonhangaba";
	protected static final String UNIDADE_FEDERATIVA_SP = "SP";
	
	/*	CONTATO	*/
	protected static final String EMAIL = "erick123@gmail.com";
	protected static final String EMAIL_SECUNDARIO = "erickemail2@gmail.com";
	protected static final Contato CONTATO_01 = new Contato(EMAIL);
	protected static final Contato CONTATO_02 = new Contato(EMAIL_SECUNDARIO);
	
	/*	EMPRESA	*/
	protected static final String CNPJ_VALIDO = "88592632000132";
	protected static final String CNPJ_VALIDO_ALEATORIO = gerarCnpj();
	protected static final String RAZAO_SOCIAL = " Empresa Aleatória Comércio Ltda";
	protected static final String NOME_FANTASIA = "Empresa Aleatória";
	
	
	/*	FUNCIONARIO	*/
	protected static final String CPF_VALIDO = "76899070081";
	protected static final String CPF_VALIDO_ALEATORIO = gerarCpf();
	protected static final String NOME_COMPLETO = "Lókaut Santos";
	protected static final LocalDate DATA_NASCIMENTO_VALIDO = of(1994, 12, 05);
	protected static final LocalDate DATA_FUTURA = now().plusYears(1);
	protected static final LocalDate DATA_ADMISSAO = of(2021, 11, 04);
	protected static final LocalDate DATA_DESLIGAMENTO = now();
	protected static final Funcionario FUNCIONARIO_01 = new Funcionario(gerarCpf());
	protected static final Funcionario FUNCIONARIO_02 = new Funcionario(gerarCpf());
	
	/*	ENDERECO	*/
	protected static final String LOGRADOURO = "Rua Bastos";
	protected static final String NUMERO_ENDERECO = "101";
	protected static final String SEGUNDO_NUMERO_ENDERECO = "103";
	protected static final String SEGUNDO_CEP = "18321050";
	protected static final String BAIRRO = "Vila Olímpia";
	protected static final String CEP = "03757040";
	protected static final String COMPLEMENTO = "predio A, apartamento 23";
	protected static final Endereco ENDERECO_01 = new Endereco(CEP, NUMERO_ENDERECO);
	protected static final Endereco ENDERECO_02 = new Endereco(SEGUNDO_CEP, SEGUNDO_NUMERO_ENDERECO);
	
	
	/*	SETOR	*/
	protected static final String NOME_SETOR = "Tecnologia da Informação";
	protected static final String NOME_SETOR_RH = "Recursos Humanos";
	protected static final String DESCRICAO_SETOR = "Setor resposável pela parte tecnológica da empresa";
	protected static final Setor SETOR_01 = new Setor(NOME_SETOR);
	protected static final Setor SETOR_02 = new Setor(NOME_SETOR_RH);
	
	/*	TELEFONE	*/
	protected static final String DDD_CEARA = "85";
	protected static final String DDD_SAO_PAULO = "11";
	protected static final String NUMERO_TELEFONE = "56668057";
	protected static final String NUMERO_CELULAR = "956634577";
	
	/*	Serialização para gerar listas */
	protected static final List<Funcionario> FUNCIONARIOS = new ArrayList<>(){
		private static final long serialVersionUID = 1L;
	{
		add(FUNCIONARIO_01);
		add(FUNCIONARIO_02);
	}};
	
	protected static final  List<Endereco> ENDERECOS = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(ENDERECO_01);
			add(ENDERECO_02);
		}
	};
	
	protected static final List<Setor> SETORES = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(SETOR_01);
			add(SETOR_02);
		}
	};
	
	protected static final List<Contato> CONTATOS = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(CONTATO_01);
			add(CONTATO_02);
		}
	};
	
	
}
