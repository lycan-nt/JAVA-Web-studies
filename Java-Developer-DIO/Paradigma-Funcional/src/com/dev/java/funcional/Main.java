package com.dev.java.funcional;

import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        //------------Imperativo
//	    int valor = 20;
//	    int valor2 = 10;
//	    int soma = valor + valor2;
//        System.out.println("Result: " + soma);

        //--------------Funcional
        UnaryOperator<Integer> calcularValorVezes3 = valor -> valor*3;
        int valor = 10;
        System.out.println("Result: " + calcularValorVezes3.apply(10));
    }
}
