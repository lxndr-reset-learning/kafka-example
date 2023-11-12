package com.example.kafkaexample.controller;

import com.example.kafkaexample.utils.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MainController {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public MainController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/message")
    public void publishMessage(@RequestBody MessageRequest request) {
        kafkaTemplate.send(request.topic(), request.data());
    }
}
