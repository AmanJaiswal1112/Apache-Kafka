package com.example.apache.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPRoducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaPRoducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaPRoducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("javaguide", message);
    }
}
