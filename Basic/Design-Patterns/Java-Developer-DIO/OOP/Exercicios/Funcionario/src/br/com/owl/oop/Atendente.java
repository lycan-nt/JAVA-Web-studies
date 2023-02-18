package br.com.owl.oop;

public class Atendente extends Funcionario{

    public Atendente(String name, double wage)
    {
        super(name, wage);
    }

    protected double calculateTax()
    {
        return getWage() * 0.01;
    }

}
