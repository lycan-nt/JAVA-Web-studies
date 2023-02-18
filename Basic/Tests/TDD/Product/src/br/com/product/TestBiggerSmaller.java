package br.com.product;

import org.junit.Assert;
import org.junit.Test;

public class TestBiggerSmaller {

	@Test
	public void descendingOrder() {
		ShoppingCart cart = new ShoppingCart();
		cart.toAdd(new Product("Geladeira", 450.0));
		cart.toAdd(new Product("Liquidificador", 250.0));
		cart.toAdd(new Product("Jogo de pratos", 70.0));
		
		BiggerSmaller algoritimo = new BiggerSmaller();
		algoritimo.meet(cart);
		
		Assert.assertEquals("Geladeira", algoritimo.getBigger().getName());
		Assert.assertEquals("Jogo de pratos", algoritimo.getSmaller().getName());
	}
	
	@Test
	public void ascendingOrder() {
		ShoppingCart cart = new ShoppingCart();
		cart.toAdd(new Product("Jogo de pratos", 70.0));
		cart.toAdd(new Product("Liquidificador", 250.0));
		cart.toAdd(new Product("Geladeira", 450.0));

		BiggerSmaller algoritimo = new BiggerSmaller();
		algoritimo.meet(cart);
		
		Assert.assertEquals("Geladeira", algoritimo.getBigger().getName());
		Assert.assertEquals("Jogo de pratos", algoritimo.getSmaller().getName());
	}
	
	@Test
	public void justOneProduct() {
		ShoppingCart cart = new ShoppingCart();
		cart.toAdd(new Product("Geladeira", 450.0));
		
		BiggerSmaller algoritimo = new BiggerSmaller();
		algoritimo.meet(cart);
		
		Assert.assertEquals("Geladeira", algoritimo.getSmaller().getName());
		Assert.assertEquals("Geladeira", algoritimo.getBigger().getName());
	}
	
}
