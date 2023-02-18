package br.com.owl.ISP.vehicles;

public interface Ivehicle {
    public void configureCar(String color, String year, double engine, int seats);
    public void configureMotorCycle(String color, String year, double engine);
    public void startVehicle();
}
