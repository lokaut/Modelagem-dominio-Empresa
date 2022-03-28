package br.com.contmatic.prova.testes;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Testes da Modelagem")
@SelectPackages({"br.com.contmatic.prova"})
@ExcludePackages({ "br.com.contmatic.prova.testes", "br.com.contmatic.prova.constantes" })
public class SuitesRun {

}
