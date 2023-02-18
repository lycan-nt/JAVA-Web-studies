package com.ocp;

public class Vehicle {
    private String color;
    private String year;
    private double engine;
    private int seats;

    public Vehicle(String color, String year, double engine, int seats)
    {
        this.color = color;
        this.year = year;
        this.engine = engine;
        this.seats = seats;
    }

    void car()
    {
        System.out.println("Criando um carro: " + color + " " + year + " " + engine + " Com " + seats + " acentos"  );
        startVehicle();
    }

    void motorCycle()
    {
        System.out.println("Criando uma moto: " + year + engine + " Cilindradas");
    }

    void startVehicle()
    {
        System.out.println("Ligando os motores...");
    }
}
