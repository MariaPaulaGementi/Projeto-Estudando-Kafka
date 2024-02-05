package com.valdir.strconsumer.listeners;

import com.valdir.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {
    //forma de criar particao sem usar o listener customizado
//    @KafkaListener(groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(topic ="srt-topic", partitions = {"0"} )
//            }, containerFactory = "strContainerFactory")
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
      //  log.info("Receive message {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        //  log.info("Receive message {}", message);
    }
}
