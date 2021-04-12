package com.ocp;

public class Animal {
    private double peso;
    private String grupo;

    public Animal()
    {
        super();
        System.out.println("Contrutor de animal");
    }

    public Animal(double peso, String grupo)
    {
        this();
        System.out.println("Sobrecarga de animal");
    }

    public double getPeso()
    {
        return this.peso;
    }
    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public String getGrupo()
    {
        return this.grupo;
    }
    public void setGrupo(String grupo)
    {
        this.grupo = grupo;
    }
}
