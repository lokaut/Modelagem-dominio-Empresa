package br.com.contmatic.prova.testes;

import br.com.contmatic.prova.contato.ContatoTest;
import br.com.contmatic.prova.contato.TelefoneTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.prova.model.contato.Contato;

@RunWith(JUnitPlatform.class)
@SelectPackages(value = { "br.com.contmatic.prova" })
@ExcludePackages(value = {
						"br.com.contmatic.prova.testes",
						"br.com.contmatic.prova.constates"
						})
public class testesPrincipal {

}
