package com.veiculo;

public class Carro {
    //variavel de instancia
    private double velocidade;
    int portas;

    public double getVelocidade()
    {
        return this.velocidade;
    }
    public void setVelocidade(double velocidade)
    {
        if(velocidade <= 0)
            System.out.println("Digite uma velocidade valida");
        this.velocidade = velocidade;
    }

    //Metodo
    public void acelerar()
    {
        //Variavel local
        int x = 0;
        System.out.println(x);
    }
}
