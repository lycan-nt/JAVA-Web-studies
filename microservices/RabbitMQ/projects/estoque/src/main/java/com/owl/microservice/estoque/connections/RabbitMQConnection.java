package com.owl.microservice.estoque.connections;

import consts.RabbitMQConsts;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String nameQueue) {
        return new Queue(nameQueue, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding directRelation(Queue queue, DirectExchange directExchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void addQueue() {
        Queue queueEstoque = this.queue(RabbitMQConsts.FILA_ESTOQUE);
        Queue queuePreco  = this.queue(RabbitMQConsts.FILA_PRECO);
        DirectExchange direct = this.directExchange();
        Binding linkEstoque = this.directRelation(queueEstoque, direct);
        Binding linkPreco = this.directRelation(queuePreco, direct);
        this.amqpAdmin.declareQueue(queueEstoque);
        this.amqpAdmin.declareQueue(queuePreco);
        this.amqpAdmin.declareExchange(direct);
        this.amqpAdmin.declareBinding(linkEstoque);
        this.amqpAdmin.declareBinding(linkPreco);
    }

}
