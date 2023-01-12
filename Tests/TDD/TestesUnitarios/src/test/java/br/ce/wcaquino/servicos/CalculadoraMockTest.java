package br.ce.wcaquino.servicos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import junit.framework.Assert;

public class CalculadoraMockTest {
	
	@Mock
	private Calculadora calcMock;
	
	@Spy
	private Calculadora calcSpy;
	
	@Spy
	private IEmailService emailService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void diferencaEntreMockESpy() {
		Mockito.when(calcMock.somar(1, 2)).thenCallRealMethod();
		Mockito.when(calcSpy.somar(1, 2)).thenReturn(8);
		System.out.println("Mock: " + calcMock.somar(1, 5));
		System.out.println("Spy: " + calcSpy.somar(1, 5));
		System.out.println("Mock");
		calcMock.print();
		System.out.println("Spy");
		calcSpy.print();
	}

	@Test
	public void teste() {
		Calculadora calc = Mockito.mock(Calculadora.class);
		Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt())).thenReturn(5);
		
		Assert.assertEquals(5, calc.somar(1, 10000));
	}
	
}
