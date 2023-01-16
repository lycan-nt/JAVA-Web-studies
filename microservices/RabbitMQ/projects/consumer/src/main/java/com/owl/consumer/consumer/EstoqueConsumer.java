package com.owl.consumer.consumer;

import consts.RabbitMQConsts;
import dto.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConsts.FILA_ESTOQUE)
    private void consumidor(EstoqueDTO estoqueDTO) {
        System.out.println("Código: " + estoqueDTO.codigoProduto);
        System.out.println("Estoque: " + estoqueDTO.quantidade);
        System.out.println("------------------------------------");
    }

}
