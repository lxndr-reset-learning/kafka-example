package com.example.kafkaexample.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "new-topic", groupId = "new-topic")
    void listener(String data) {
        System.out.println("data = " + data);
    }
}
