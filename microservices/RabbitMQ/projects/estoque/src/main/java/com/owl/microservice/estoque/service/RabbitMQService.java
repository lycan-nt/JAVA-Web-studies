package com.owl.microservice.estoque.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarMenssagem(String nomeFile, Object menssagem) {
        this.rabbitTemplate.convertAndSend(nomeFile, menssagem);
    }

}
