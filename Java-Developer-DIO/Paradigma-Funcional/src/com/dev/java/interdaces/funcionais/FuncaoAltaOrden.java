package com.dev.java.interdaces.funcionais;

public class FuncaoAltaOrden {
    public static void main(String[] args) {
        Calcular somar = (a, b) -> a+b;
        Calcular subtrair = (a, b) -> a-b;
        Calcular multiplicar = (a, b) -> a*b;
        Calcular dividir = (a,b) -> a/b;

        System.out.println(execultarOperacao(somar,5, 5));
        System.out.println(execultarOperacao(subtrair,5, 5));
        System.out.println(execultarOperacao(multiplicar,5, 5));
        System.out.println(execultarOperacao(dividir,5, 5));
    }

    public static int execultarOperacao(Calcular calculo, int a, int b)
    {
        return calculo.Calcular(a, b);
    }
}

interface Calcular {
    public int Calcular(int valor1, int valor2);
}