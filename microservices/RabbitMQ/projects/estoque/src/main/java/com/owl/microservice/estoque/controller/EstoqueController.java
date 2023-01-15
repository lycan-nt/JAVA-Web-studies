package com.owl.microservice.estoque.controller;

import com.owl.microservice.estoque.consts.RabbitMQConsts;
import com.owl.microservice.estoque.dto.EstoqueDTO;
import com.owl.microservice.estoque.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alterarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        System.out.println("ESTOQUE: " + estoqueDTO.codigoProduto);
        this.rabbitMQService.enviarMenssagem(RabbitMQConsts.FILA_ESTOQUE, estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
