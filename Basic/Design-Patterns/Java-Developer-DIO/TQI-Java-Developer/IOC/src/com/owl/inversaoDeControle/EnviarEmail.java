package com.owl.inversaoDeControle;

public class EnviarEmail {
	
	public EnviarEmail(String tipo, String endereco, String senha) {
		
	}
	
	public static EnviarEmail obterDadosEmail() {
		return new EnviarEmail("stmp", "contato@email.com", "senha");
	}
	
	public void retornar(String mensagem) {
		System.out.println("Email enviado");
	}

}
