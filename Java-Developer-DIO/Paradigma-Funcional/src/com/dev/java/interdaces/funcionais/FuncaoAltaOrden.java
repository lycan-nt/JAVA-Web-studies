package com.dev.java.interdaces.funcionais;

public class FuncaoAltaOrden {
    public static void main(String[] args) {
        Calcular soma = (a, b) -> a+b;
        System.out.println(execultarOperacao(soma, 5, 5));
    }

    public static int execultarOperacao(Calcular calculo, int a, int b)
    {
        return calculo.Calcular(a, b);
    }
}

interface Calcular {
    public int Calcular(int valor1, int valor2);
}