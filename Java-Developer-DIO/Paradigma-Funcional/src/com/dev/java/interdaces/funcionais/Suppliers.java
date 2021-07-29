package com.dev.java.interdaces.funcionais;

import java.util.function.Supplier;

class Supridores {
    public static void main(String[] args) {
        Supplier<Pessoa> suppliers = () -> new Pessoa();
        System.out.println(suppliers.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "Felipe D. Santos";
        idade = 25;
    }

    @Override
    public String toString() {
        return String.format("nome: %s, idade: %d", nome, idade);
    }
}
