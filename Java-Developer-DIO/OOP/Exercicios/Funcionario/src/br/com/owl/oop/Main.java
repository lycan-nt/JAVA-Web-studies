package br.com.owl.oop;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Gerente gerente = new Gerente("Hugo", 5000);
        System.out.println("O gerente: " + gerente.getName() + " Paga de imposto: " + gerente.calculateTax());

        Supervisor supervisor = new Supervisor("Mauricio", 3000);
        System.out.println("O supervidor: " + supervisor.getName() + " Paga de imposto: " + supervisor.calculateTax());

        Atendente atendente = new Atendente("Brunna",1500);
        System.out.println("O atendente: " + atendente.getName() + " Paga de imposto: " + atendente.calculateTax());

    }
}
