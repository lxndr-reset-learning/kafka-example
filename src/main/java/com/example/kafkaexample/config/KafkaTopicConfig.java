package com.example.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaTopicConfig {
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Bean
    public NewTopic testTopic() {
        NewTopic newTopic = new NewTopic("new-topic", Runtime.getRuntime().availableProcessors(), ((short) 1));

        kafkaTemplate.setDefaultTopic(this.toString());
        kafkaTemplate.send(newTopic.name(), "new-topic initialized");

        return newTopic;
    }

}