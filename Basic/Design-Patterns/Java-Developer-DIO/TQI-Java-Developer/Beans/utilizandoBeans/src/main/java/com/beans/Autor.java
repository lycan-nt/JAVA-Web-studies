package com.beans;

public class Autor implements IAutorLivro{
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void exibirAutor() {
		System.out.println(this.nome);
	}
	
}
