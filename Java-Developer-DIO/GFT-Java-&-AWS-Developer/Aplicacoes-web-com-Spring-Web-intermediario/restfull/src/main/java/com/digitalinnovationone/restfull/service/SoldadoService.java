package com.digitalinnovationone.restfull.service;

import com.digitalinnovationone.restfull.controller.request.SoldadoEditRequest;
import com.digitalinnovationone.restfull.dto.Soldado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoldadoService {

    public Soldado buscarSoldado(String cpf) {
        Soldado soldado = new Soldado();
        soldado.setCpf(cpf);
        soldado.setNome("Felipe");
        soldado.setArma("Espada");
        soldado.setRaca("Guerreiro");

        return soldado;
    }

    public void criarSoldado(Soldado soldado) {
        Soldado soldao = soldado;;
    }

    public void editarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest) {
        System.out.println("Soldado edit: " + cpf);
    }

    public void deletarSoldado(String cpf) {
        System.out.println("Deletar Soldado: " + cpf);
    }

    public List<Soldado> buscarSoldados() {
        List<Soldado> soldadoList = new ArrayList<>();
        Soldado soldado = new Soldado();

        soldado.setCpf("123");
        soldado.setNome("Felipe");
        soldado.setRaca("Mago");
        soldado.setArma("Cajado");
        soldadoList.add(soldado);

        return soldadoList;

    }
}
