package com.owl.microservice.estoque.controller;

import com.owl.microservice.estoque.service.RabbitMQService;
import consts.RabbitMQConsts;
import dto.PrecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alterarPreco(@RequestBody PrecoDTO precoDTO) {
        System.out.println("PRECO: " + precoDTO.codigoProduto);
        this.rabbitMQService.enviarMenssagem(RabbitMQConsts.FILA_PRECO, precoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
