package com.dev.java.calendar;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Calendar agora = Calendar.getInstance();
        System.out.println("New:" + agora.getTime());

        try
        {
            GerarDataVencimento dataVencimento = new GerarDataVencimento(Calendar.getInstance(), 10);
            Calendar novaData = dataVencimento.calcularDataVencimento();
            System.out.println("Data para vencimento: " + novaData.getTime());
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
