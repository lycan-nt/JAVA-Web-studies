package com.dev.java.interdaces.funcionais;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {
        String[] nomes = {"Felipe", "Marcella", "Floop"};
        Integer[] numeros = {1, 2, 3};
        imprimirNomesFiltrados(nomes);
    }

    public static void imprimirNomesFiltrados(String... nomes)
    {
        String nomesParaImprimir = "";

        for (int i = 0; i < nomes.length ; i++)
        {
            if (nomes[i].equals("Felipe"))
            {
                nomesParaImprimir += " " + nomes[i];
            }
         }

        String nomeStram = Stream.of(nomes)
                .filter(nome -> nome.equals("Felipe"))
                .collect(Collectors.joining());

        System.out.println(nomeStram);

        System.out.println(nomesParaImprimir);
    }

}
