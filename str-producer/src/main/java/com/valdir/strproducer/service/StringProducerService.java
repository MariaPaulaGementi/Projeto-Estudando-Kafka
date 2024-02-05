package com.valdir.strproducer.service;

import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringProducerService.class);

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

    public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info("Send message {}", message);
        kafkaTemplate.send("str-topic", message);
                //.addCallback(
//                success -> {
//                    if (success != null) {
//                        log.info("Send message with success {}", message);
//                        log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
//                    }
//                },
//                error -> log.error("Error sen message")
  //      );
    }
}
