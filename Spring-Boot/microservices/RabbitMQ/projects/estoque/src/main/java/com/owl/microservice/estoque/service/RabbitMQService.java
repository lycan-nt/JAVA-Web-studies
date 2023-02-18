package com.owl.microservice.estoque.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarMenssagem(String nomeFile, Object menssagem) {
        try {
            String messageJson = this.objectMapper.writeValueAsString(menssagem);
            this.rabbitTemplate.convertAndSend(nomeFile, messageJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
