package br.com.contmatic.prova.constantes;

import static br.com.contmatic.prova.utils.GeradorCpfCnpj.gerarCnpj;
import static br.com.contmatic.prova.utils.GeradorCpfCnpj.gerarCpf;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.prova.model.contato.Contato;
import br.com.contmatic.prova.model.empresa.Funcionario;
import br.com.contmatic.prova.model.empresa.Setor;
import br.com.contmatic.prova.model.endereco.Endereco;

public final class ConstantesTestes {
	
	private ConstantesTestes(){}
	
	public static final String MAIS_SESSENTA_CARACTERES_ALFABETICOS = "Rua BastoRua BastoRua BastoRua BastoRua BastoRua BastoRua Basto";
	public static final String CODIGO_ERRADO_IBGE = "123345678";
	public static final String MAIS_CIQUENTA_NUMEROS= "123345678223594735739123345678223597357395935627500";
	public static final String MAIS_CEM_CARACTERES = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcababcabcabcabcabcabcabcabcabcabcabcabcabcabcab";
	public static final String CARACTER_ESPECIAL = "@@@$#@$";
	public static final String TRES_CARACTERES_ALFABETICOS = "abc";
	public static final String SETENTA_CINCO_CARACTERES_ALFABETICOS = "contmatic contmatic contmatic contmatic contmatic contmaticsss contmaticsss";
	public static final String EMAIL_DUZENTOS_OITENTA_CARACTERES_ALFABETICOS = "erierick_tckemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2erickemail2@gmail.com";
	public static final String DOIS_CARACTERES = "ac";
	public static final String NUMERO_CPF_INVALIDO = "44085620000";
	public static final String ONZE_NUMEROS = "66998583340";
	public static final String ONZE_NUMEROS_CARACTERES = "44a764b7f34";
	public static final String CATORZE_NUMEROS_LETRAS = "ABC134rfgs5d7j";
	
	/*	CARGOS	*/
	public static final String NOME_CARGOS = "Gerente de projetos de tecnologia da informação";
	public static final String CBO_CARGOS = "142520";
	public static final String CBO_ANALISTA_TI = "2124";
	public static final String DESCRICAO_CARGOS = "Cargo de gerente";
	public static final BigDecimal SALARIO_CARGOS = valueOf(14000.60);
	
	/*	CIDADE	*/
	public static final String CODIGO_IBGE_SAO_PAULO = "3550308";
	public static final String CODIGO_IBGE_PINDAMONHANGABA = "3538006";
	public static final String MUNICIPIO_SAO_PAULO  = "São Paulo";
	public static final String MUNICIPIO_PINDAMONHANGABA  = "Pindamonhangaba";
	public static final String UNIDADE_FEDERATIVA_SP = "SP";
	
	/*	CONTATO	*/
	public static final String EMAIL = "erick123@gmail.com";
	public static final String EMAIL_SECUNDARIO = "erickemail2@gmail.com";
	public static final Contato CONTATO_01 = new Contato(EMAIL);
	public static final Contato CONTATO_02 = new Contato(EMAIL_SECUNDARIO);
	
	/*	EMPRESA	*/
	public static final String CNPJ_VALIDO = "88592632000132";
	public static final String CNPJ_VALIDO_ALEATORIO = gerarCnpj();
	public static final String RAZAO_SOCIAL = " Empresa Aleatória Comércio Ltda";
	public static final String NOME_FANTASIA = "Empresa Aleatória";
	
	
	/*	FUNCIONARIO	*/
	public static final String CPF_VALIDO = "76899070081";
	public static final String CPF_VALIDO_ALEATORIO = gerarCpf();
	public static final String NOME_COMPLETO = "Lókaut Santos";
	public static final LocalDate DATA_NASCIMENTO_VALIDO = of(1994, 12, 05);
	public static final LocalDate DATA_FUTURA = now().plusYears(1);
	public static final LocalDate DATA_ADMISSAO = of(2021, 11, 04);
	public static final LocalDate DATA_DESLIGAMENTO = now();
	public static final Funcionario FUNCIONARIO_01 = new Funcionario(gerarCpf());
	public static final Funcionario FUNCIONARIO_02 = new Funcionario(gerarCpf());
	
	/*	ENDERECO	*/
	public static final String LOGRADOURO = "Rua Bastos";
	public static final String NUMERO_ENDERECO = "101";
	public static final String SEGUNDO_NUMERO_ENDERECO = "103";
	public static final String SEGUNDO_CEP = "18321050";
	public static final String BAIRRO = "Vila Olímpia";
	public static final String CEP = "03757040";
	public static final String COMPLEMENTO = "predio A, apartamento 23";
	public static final Endereco ENDERECO_01 = new Endereco(CEP, NUMERO_ENDERECO);
	public static final Endereco ENDERECO_02 = new Endereco(SEGUNDO_CEP, SEGUNDO_NUMERO_ENDERECO);
	
	
	/*	SETOR	*/
	public static final String NOME_SETOR = "Tecnologia da Informação";
	public static final String NOME_SETOR_RH = "Recursos Humanos";
	public static final String DESCRICAO_SETOR = "Setor resposável pela parte tecnológica da empresa";
	public static final Setor SETOR_01 = new Setor(NOME_SETOR);
	public static final Setor SETOR_02 = new Setor(NOME_SETOR_RH);
	
	/*	TELEFONE	*/
	public static final String DDD_CEARA = "85";
	public static final String DDD_SAO_PAULO = "11";
	public static final String NUMERO_TELEFONE = "56668057";
	public static final String NUMERO_CELULAR = "956634577";
	
	/*	Serialização para gerar listas */
	public static final List<Funcionario> FUNCIONARIOS = new ArrayList<>(){
		private static final long serialVersionUID = 1L;
	{
		add(FUNCIONARIO_01);
		add(FUNCIONARIO_02);
	}};
	
	public static final  List<Endereco> ENDERECOS = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(ENDERECO_01);
			add(ENDERECO_02);
		}
	};
	
	public static final List<Setor> SETORES = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(SETOR_01);
			add(SETOR_02);
		}
	};
	
	public static final List<Contato> CONTATOS = new ArrayList<>() {
		private static final long serialVersionUID = 1L;
		{
			add(CONTATO_01);
			add(CONTATO_02);
		}
	};
}
