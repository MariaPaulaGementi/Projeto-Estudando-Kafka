package com.valdir.strconsumer.listeners;

import com.valdir.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class StrConsumerListener {
    Logger log = LoggerFactory.getLogger(StrConsumerListener.class);
    //forma de criar particao sem usar o listener customizado
//    @KafkaListener(groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(topic ="srt-topic", partitions = {"0"} )
//            }, containerFactory = "strContainerFactory")
    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("Receive message {}", message);
        throw new IllegalArgumentException("EXCEPTION ...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){

        log.info("Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public String history(String message){
          log.info("History :: message {}", message);
        return "Teste";
    }
}
