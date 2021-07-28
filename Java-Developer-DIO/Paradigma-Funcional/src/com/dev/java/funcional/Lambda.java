package com.dev.java.funcional;

public class Lambda {
    public static void main(String[] args) {
        Funcao funcao = valor -> {
            return valor;
        };
        System.out.println(funcao.gerar("Felipe D. Santos"));
    }
}

@FunctionalInterface
interface Funcao {
    String gerar(String valor);
}
