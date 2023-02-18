package com.owl.consumer.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.util.ErrorHandler;

public class TratamentoErroHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        String nomeFile = ((ListenerExecutionFailedException) t).getFailedMessage().getMessageProperties().getConsumerQueue();
        System.out.println("Fila: " + nomeFile);
        String menssagem = new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody());
        System.out.println("Mensagem: " + menssagem);
        System.out.println(t.getCause().getMessage());
        //Logar no ElasticSearch
        //Logar no Coud Watch(AWS)
        throw new AmqpRejectAndDontRequeueException("Não retorne a fila");
    }

}
