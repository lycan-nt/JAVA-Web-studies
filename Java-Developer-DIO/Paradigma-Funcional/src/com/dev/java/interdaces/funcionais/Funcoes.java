package com.dev.java.interdaces.funcionais;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        Function<String,String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String,Integer> converterStringParaInteiro = String -> Integer.valueOf(String);
        System.out.println(retornarNomeAoContrario.apply("NextDev"));
        System.out.println(converterStringParaInteiro.apply("10"));
    }
}
