package com.dev.java.interdaces.funcionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {
        String[] nomes = {"Felipe", "Marcella", "Floop"};
        Integer[] numeros = {1, 2, 3};
        imprimirNomesFiltrados(nomes);
        imprimirDobro(numeros);

        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Tester");
        profissoes.add("Gerente");

        profissoes.stream()
                .filter(profissao -> profissao.startsWith("Desevolvedor"))
                .forEach(System.out::println);
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

    public static void imprimirDobro(Integer... numeros)
    {
        for (Integer numero: numeros)
        {
            System.out.println(numero * 2);
        }

        Stream.of(numeros).map( numero -> numero * 2 )
                .forEach(System.out::println);
    }

}
