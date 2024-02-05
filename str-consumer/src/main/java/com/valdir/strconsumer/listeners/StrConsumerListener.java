package com.valdir.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {
    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic ="srt-topic", partitions = {"0"} )
            }, containerFactory = "strContainerFactory")
    public void create(String message){
      //  log.info("Receive message {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
            @TopicPartition(topic ="srt-topic", partitions = {"1"} )
            },
            containerFactory = "strContainerFactory")
    public void log(String message){
        //  log.info("Receive message {}", message);
    }
}
