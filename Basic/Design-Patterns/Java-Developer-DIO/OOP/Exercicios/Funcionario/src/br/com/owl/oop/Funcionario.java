package br.com.owl.oop;

public class Funcionario {
    private String name;
    private double wage;

    public Funcionario(String name, double wage)
    {
        this.name = name;
        this.wage = wage;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public double getWage()
    {
        return this.wage;
    }
    public void setWage(double wage)
    {
        this.wage = wage;
    }

    protected double calculateTax()
    {
        return this.wage * 0.01;
    }
}
