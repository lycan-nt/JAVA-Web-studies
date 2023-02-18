package com.dev.java.funcional;

import java.util.function.UnaryOperator;

public class Imultabilidade {
    public static void main(String[] args) {
        int valor = 20;
        UnaryOperator<Integer> retornarDobro = v -> v * 2;

        System.out.println(retornarDobro.apply(valor));
        System.out.println(valor);
    }
}
