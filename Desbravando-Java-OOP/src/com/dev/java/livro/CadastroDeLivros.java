package com.dev.java.livro;

public class CadastroDeLivros {
    public static void main(String[] args) {
        Autor autorJava = new Autor();
        autorJava.nome = "Felipe D. Santos";
        autorJava.email = "lycan.felipe@gmail.com";
        autorJava.cpf = "77885522";

        Livro livroJava = new Livro();
        livroJava.nome = "Java 8";
        livroJava.descricao = "Recursos do JAVA 8";
        livroJava.valor = 59.90;
        livroJava.isbn = "154-52-12";
        livroJava.autor = autorJava;
        livroJava.mostrarDetalhes();

        Autor autorNode = new Autor();
        autorNode.nome = "Marcella D. Santos";
        autorNode.email = "lycan.marcella@gmail.com";
        autorNode.cpf = "22556699";

        Livro livroNode = new Livro();
        livroNode.nome = "Nodejs";
        livroNode.descricao = "Recursos do Node";
        livroNode.valor = 49.90;
        livroNode.isbn = "154-52-11";
        livroNode.autor = autorNode;
        livroNode.mostrarDetalhes();
    }
}
