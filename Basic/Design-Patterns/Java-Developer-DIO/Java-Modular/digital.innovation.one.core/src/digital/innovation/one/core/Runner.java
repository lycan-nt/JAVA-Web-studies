package digital.innovation.one.core;

import digital.innovation.one.ultils.operacao.Calculadora;

public class Runner {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.mult(2,5));
    }
}
