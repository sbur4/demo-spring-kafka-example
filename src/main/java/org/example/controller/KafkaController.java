package org.example.controller;

import org.example.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage("my-topic", message);
        return "Message sent: " + message;
    }

    @PostMapping("/sendAndReceive")
    public String sendAndReceiveMessage(@RequestParam("message") String sentMessage) {
        String receivedMessage = messageProducer.sendAndReceiveMessage("my-topic-2", sentMessage);
        return "Message sent: " + sentMessage + ". Message received: " + receivedMessage;
    }
}