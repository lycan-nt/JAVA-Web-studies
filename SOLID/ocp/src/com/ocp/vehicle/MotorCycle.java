package com.ocp.vehicle;

public class MotorCycle extends Vehicle{
    public MotorCycle(String color, String year, double engine)
    {
        this.color = color;
        this.year = year;
        this.engine = engine;

        configureMotoCycle();
    }

    public void configureMotoCycle()
    {
        System.out.println("Criando uma moto: " + year + engine + " Cilindradas");
        startVehicle();
    }
}
