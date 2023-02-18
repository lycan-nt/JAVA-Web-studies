package br.com.owl.oop;

public class Supervisor extends Funcionario{

    public Supervisor(String name, double wage)
    {
        super(name, wage);
    }

    protected double calculateTax()
    {
        return getWage() * 0.01;
    }
}
