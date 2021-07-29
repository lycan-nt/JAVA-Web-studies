package com.dev.java.processamentoasyncparalel;

public class Threads {
    public static void main(String[] args) {
        GeradorPdf gerarPdf = new GeradorPdf();
        BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(gerarPdf);

        gerarPdf.start();
        barraDeCarregamento.start();
    }
}

class GeradorPdf extends Thread {
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Gerar PDF");
    }
}

class BarraDeCarregamento extends Thread {

    private Thread gerarPdf;

    public BarraDeCarregamento(Thread gerarPdf)
    {
        this.gerarPdf = gerarPdf;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(500);
                if (!gerarPdf.isAlive())
                {
                    break;
                }
                    System.out.println("Loadin...");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class BarraDeCarregamento2 implements Runnable{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(3000);
            System.out.println("Start: 2");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}

class BarraDeCarregamento3 implements Runnable {
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(10000);
            System.out.println("Start: 3");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


