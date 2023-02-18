package br.com.owl.ISP.vehicles;

public class MotorCycle implements Ivehicle{
    private String color;
    private String year;
    private double engine;

    @Override
    public void configureCar(String color, String year, double engine, int seats) {

    }

    @Override
    public void configureMotorCycle(String color, String year, double engine)
    {
        this.color = color;
        this.year = year;
        this.engine = engine;
        System.out.println("Criando uma moto...");
    }

    @Override
    public void startVehicle()
    {
        System.out.println("Ligando os motores...");
    }
}
