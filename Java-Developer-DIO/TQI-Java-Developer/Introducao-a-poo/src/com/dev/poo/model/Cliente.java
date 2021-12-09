package com.dev.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public Integer codigo;
    public String nome;
    public String cpf;

    private List<Endereco> enderecos;

    public void adicionarEndereco(Endereco emdereco){
        if (emdereco == null){
            throw new NullPointerException("Endereço não pode ser null");
        }
        getEnderecos().add(emdereco);
    }

    private List<Endereco> getEnderecos(){
        if(enderecos == null){
            enderecos = new ArrayList<Endereco>();
        }
        return this.enderecos;
    }
}
