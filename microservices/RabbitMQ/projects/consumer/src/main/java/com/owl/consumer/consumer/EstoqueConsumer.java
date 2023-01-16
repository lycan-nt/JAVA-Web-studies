package com.owl.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import consts.RabbitMQConsts;
import dto.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConsts.FILA_ESTOQUE)
    private void consumidor(String mensagem) throws InterruptedException, JsonProcessingException {
        EstoqueDTO estoqueDTO = new ObjectMapper().readValue(mensagem, EstoqueDTO.class);
        System.out.println("Código: " + estoqueDTO.codigoProduto);
        System.out.println("Estoque: " + estoqueDTO.quantidade);
        System.out.println("------------------------------------");
//        Thread.sleep(120000);

       // throw new IllegalArgumentException("Argumen to inválido"); <-- Teste para disparar exeções personalizadas
    }

}
