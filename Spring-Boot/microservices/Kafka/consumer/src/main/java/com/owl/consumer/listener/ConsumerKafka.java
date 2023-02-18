package com.owl.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerKafka {

    private final Logger logger = LoggerFactory.getLogger(ConsumerKafka.class);

    @KafkaListener(topics = "${topic.microservices-consumer}", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

}
