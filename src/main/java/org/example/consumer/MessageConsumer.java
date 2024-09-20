package org.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "my-topic-2", groupId = "my-group-id")
    public void listen2(String message) {
        System.out.println("Received message: " + message);
        String newMessage = String.format("%s.new", message);
        kafkaTemplate.send("my-topic-3", newMessage);
        System.out.println("Send message: " + newMessage);
    }
}