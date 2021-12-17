package com.dev.java.livro;

public class Livro {
    public String nome;
    public String descricao;
    public double valor;
    public String isbn;
    public Autor autor;

    public void mostrarDetalhes() {
        String mensagem = "Mostrando detalhes do livro";
        System.out.println(mensagem);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: " + valor);
        System.out.println("ISBN" + isbn);
        System.out.println("--------------------------");
    }
}
