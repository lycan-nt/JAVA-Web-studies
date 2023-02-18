package com.owl.inversaoDeControle;

public class Pedido {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.gravar();
	}
	
	private EnviarEmail enviar = EnviarEmail.obterDadosEmail();
	
	public void gravar() {
		this.enviar.retornar("Pedido criado!");
	}

}
