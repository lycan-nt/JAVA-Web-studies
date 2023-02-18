package com.ocp;

public class Dog extends Animal{
    private String raca;
    private String porte;

    public Dog()
    {
        super(5.60, "Mamifero");
        System.out.println("Contrutor de dog");
    }

    public Dog(String raca, String port)
    {
        this();
        System.out.println("Sobrecarga de Dog");
    }
}
