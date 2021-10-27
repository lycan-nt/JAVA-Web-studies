package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertEquals("Erro de compara��o", 1, 1);
		Assert.assertEquals(0.51, 0.51, 0.1);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "Casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Felipe");
		Usuario u2 = new Usuario("Felipe");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);
	
		Assert.assertSame(u2, u2);
		Assert.assertNotSame(u2, u3);
		
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
	}
	
	
}
