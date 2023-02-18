package com.dev.poo.model;

import java.util.ArrayList;

public class EntregaCartaoApp {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        //Dados do endereço

        Cliente cliente = new Cliente();
        //Dados do cliente
        cliente.tipo = Pessoa.TipoPessoa.FISICA;

        try{
            cliente.adicionarEndereco(endereco);
        }catch(Exception e){
            System.err.println("Houve erro ao adicionar o endereço: " + e.getMessage());
        }
        System.out.println("Endereço adicionado com sucesso!");
    }
}
