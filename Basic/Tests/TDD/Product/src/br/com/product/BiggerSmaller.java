package br.com.product;

public class BiggerSmaller {
	private Product smaller;
	private Product bigger;
	
	public void meet(ShoppingCart cart) {
		for (Product product : cart.getProduct()) {
			if (smaller == null || product.getValue() < smaller.getValue()) {
				smaller = product;
			}
			if (bigger == null || product.getValue() > bigger.getValue()) {
				bigger = product;
			}
		}
	}
	
	public Product getSmaller() {
		return smaller;
	}
	
	public Product getBigger() {
		return bigger;
	}
	
}
