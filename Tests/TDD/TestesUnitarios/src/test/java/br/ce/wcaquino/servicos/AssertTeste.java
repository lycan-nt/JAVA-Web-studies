package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTeste {

	@Test
	public void teste() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals("Erro de comparação: ", 1, 1);
		Assert.assertEquals(0.51, 0.51, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("teste", "teste");
		Assert.assertNotEquals("teste1", "teste");
		Assert.assertTrue("teste".equalsIgnoreCase("Teste"));
		Assert.assertTrue("teste".startsWith("te"));
		
		Usuario u1 = new Usuario("User1");
		Usuario u2 = new Usuario("User1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);
		
		Assert.assertSame(u2, u2);
		Assert.assertNotSame(u1, u2);
		
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
		
		
	}
	
	
}
