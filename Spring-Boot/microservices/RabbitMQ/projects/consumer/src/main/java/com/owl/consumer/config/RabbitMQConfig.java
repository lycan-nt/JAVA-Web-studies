package com.owl.consumer.config;

import com.owl.consumer.consumer.CustomErrorStrategy;
import com.owl.consumer.exception.TratamentoErroHandler;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.FatalExceptionStrategy;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

@Configuration
public class RabbitMQConfig {

    @Bean
    public RabbitListenerContainerFactory<DirectMessageListenerContainer> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        DirectRabbitListenerContainerFactory factory = new DirectRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setPrefetchCount(2);
        factory.setErrorHandler(errorHandler());
        //factory.setGlobalQos(true); <-- Configuração global
        //factory.setConsumersPerQueue(20); <-- Quantidade de consumidores por fila
        return factory;
    }

    @Bean
    public FatalExceptionStrategy customErrorStrategy() {
        return new CustomErrorStrategy();
    }

    @Bean
    public ErrorHandler errorHandler() {
        return new ConditionalRejectingErrorHandler(customErrorStrategy());
    }

}
