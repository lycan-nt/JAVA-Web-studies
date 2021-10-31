package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.wcaquino.exceptions.CalculadoraException;

public class CalculadoraTest {
	
	private Calculadora calculadora;
	
	@Before
	public void setup() {
		calculadora = new Calculadora();
	}
	
	@Test
	public void deveSomarDoisValores() {
		//Cenario
		int a = 5;
		int b = 5;
		
		//Acao
		int resultado = calculadora.somar(a, b);
		
		//Verificacao
		Assert.assertEquals(10, resultado);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		//Cenario
		int a = 15;
		int b = 5;
		
		//Acao
		int resultado = calculadora.subtrair(a, b);
		
		//Verificacao
		Assert.assertEquals(10, resultado);
	}
	
	@Test
	public void deveDividirDoisValores() throws CalculadoraException {
		//Cenario
		int a = 20;
		int b = 2;
		
		//Acao
		int resultado = calculadora.dividir(a, b);
		
		//Verificacao
		Assert.assertEquals(10, resultado);
	}
	
	@Test(expected = CalculadoraException.class)
	public void deveLancarExcecaoAoDividrPorZero() throws CalculadoraException {
		//Cenario
		int a = 20;
		int b = 0;
		
		//Acap
		int resultado = calculadora.dividir(a, b);
		
		//Verificacao
		Assert.assertEquals(10, resultado);
	}
}
