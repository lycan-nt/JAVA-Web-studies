package com.dev.java.funcional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class Inferencia {
    public static void main(String[] args) throws IOException {
        printName("Felipe", " D. Santos");
        printSoma(10, 10, 50, 30);
    }

    private void getConnectionURL() throws IOException
    {
        var url = new URL("https://google.com");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replace(">", ">\n"));

    }

    public static void printName(String nome, String sobreNome)
    {
        var nomeCompleto = nome + sobreNome;
        System.out.println(nomeCompleto);
    }

    public static void printSoma(int... numeros)
    {
        var soma = 0;

        if (numeros.length > 0)
        {
            for (var numero : numeros)
            {
                soma += numero;
            }

            System.out.println("Result: " + soma);
        }
    }
}
