package com.example.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic testTopic() {
        return new NewTopic("new-topic", Runtime.getRuntime().availableProcessors(), ((short) 1));
    }

//    @Bean
//    public Admin admin(){
//        Admin admin = Admin.create();
//    }
}
