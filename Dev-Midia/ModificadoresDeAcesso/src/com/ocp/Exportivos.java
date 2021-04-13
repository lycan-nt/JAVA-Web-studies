package com.ocp;

import com.veiculo.Carro;

public class Exportivos {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.acelerar();
        carro.setVelocidade(50);
        System.out.println(carro.getVelocidade());
    }
}
