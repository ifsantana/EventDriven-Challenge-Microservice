package com.eventdriven.challenge.services.queries;

import com.eventdriven.challenge.domain.entities.Event;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClickConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Event click) {
        System.out.println("Consumed JSON Message: " + click);
    }
}