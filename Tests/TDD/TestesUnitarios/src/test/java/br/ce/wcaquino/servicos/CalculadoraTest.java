package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	
	private Calculadora calc;
	
	@Before
	public void setup() {
		calc = new Calculadora();
	}
	
	@Test
	public void deveSomarDoisValores() {
		//Cenario
		int a = 5;
		int b = 3;
		
		//Acao
		int result = calc.somar(a, b);
		
		//Verificacao
		Assert.assertEquals(8, result);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		//Canario
		int a = 8;
		int b = 5;
		
		//Acao
		int result = calc.subtrair(a, b);
		
		//Verificacao
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		//Cenario
		int a = 6;
		int b = 3;
		
		//Acao
		int result = calc.dividir(a, b);
		
		//Verificacao
		Assert.assertEquals(2, result);
		
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		//Cenario
		int a = 10;
		int b = 0;
		
		//Acao
		calc.dividir(a, b);
		
		//Verificacao
	}
	
	@Test
	public void deveDividir() {
		//Cenario
		String a = "6";
		String b = "3";
		
		//Ação
		int result = calc.divide(a, b);
		
		//verificacao
		Assert.assertEquals(2, result);
	}

}
