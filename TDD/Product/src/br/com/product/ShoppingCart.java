package br.com.product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Product> products;
	
	public ShoppingCart() {
		products = new ArrayList<Product>();
	}
	
	public List<Product> getProduct() {
		return products;
	}
	
	public void toAdd(Product product) {
		products.add(product);
	}
}
