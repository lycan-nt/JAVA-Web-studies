package br.com.owl.oop;

public class Gerente extends Funcionario{

    public Gerente(String name, double wage) {
        super(name, wage);
    }

    protected double calculateTax()
    {
        return getWage() * 0.01;
    }
}
