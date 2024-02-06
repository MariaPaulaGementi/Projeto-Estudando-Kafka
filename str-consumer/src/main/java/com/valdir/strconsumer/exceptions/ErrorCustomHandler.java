package com.valdir.strconsumer.exceptions;

import com.valdir.strconsumer.listeners.StrConsumerListener;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    Logger log = LoggerFactory.getLogger(StrConsumerListener.class);
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("Capturei um erro");
        log.info("Payload", message.getPayload());
        log.info("Headers", message.getHeaders());
        log.info("kafka_offset", message.getHeaders().get("kafka_offset"));
        log.info("Message Exception", e.getMessage());
        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}
