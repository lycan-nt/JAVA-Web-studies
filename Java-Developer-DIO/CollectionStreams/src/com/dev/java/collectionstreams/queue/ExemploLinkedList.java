package com.dev.java.collectionstreams.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {

    public static void main(String[] args) {

        Queue<String> filaDeBanco = new LinkedList<>();

        filaDeBanco.add("Felipe");
        filaDeBanco.add("Marcella");
        filaDeBanco.add("Mais um cliente");

        String clienteSendoAtendido = filaDeBanco.poll();
        System.out.println("Sendo atendido: " + clienteSendoAtendido);
        System.out.println("Estado da fila: " + filaDeBanco);

        for (String cliente : filaDeBanco)
        {
            System.out.println("Cliente: " + cliente);
        }

        String quemSeraProximo = filaDeBanco.peek();
        System.out.println("Que e: " + quemSeraProximo);
        System.out.println("Estado da fila: " + filaDeBanco);

        try
        {
            filaDeBanco.clear();
            String primeirouErro = filaDeBanco.element();
            System.out.println("Primeiro: " + primeirouErro);
            System.out.println("Estado da fila: " + filaDeBanco);
        }
        catch (Exception e)
        {
            System.out.println("Opa: " + e.getMessage());
        }
    }

}
