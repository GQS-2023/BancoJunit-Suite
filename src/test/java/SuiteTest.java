

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 *
 * @author rafaelamoreira
 */
@Suite
@SelectPackages("junitTests")
@IncludePackages("junitTests.Conta")
@ExcludePackages("junitTests.Cliente")
@IncludeClassNamePatterns("^.*Tests?$")
//@SelectClasses({GerenciadoraClienteTest_1.class, GerenciadoraClienteTest_2.class, GerenciadoraContasTest_1.class})
public class SuiteTest {
    
}
