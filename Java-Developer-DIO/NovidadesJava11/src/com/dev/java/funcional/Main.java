package com.dev.java.funcional;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        NumberFormat nformat = NumberFormat.getInstance(Locale.GERMAN);

        int qtdPositiva = 0;
        for (int i = 0; i < 6; i++)
        {
            Scanner leitor = new Scanner(System.in);

            double x =  Double.valueOf(leitor.nextLine());
            qtdPositiva += x > 0 ? 1 : 0;
        }
        System.out.println(qtdPositiva + " valores positivos");
    }


    private static void connect() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://google.com"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(response.body());
    }
}


