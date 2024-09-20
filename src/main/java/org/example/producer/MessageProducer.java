package org.example.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public String sendAndReceiveMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);

        ConsumerRecord<String, String> record = kafkaTemplate.receive("my-topic-3", 0, 0);

//        System.out.println(record.value());
//        System.out.println(record.key());
//        System.out.println(record.headers());
//        System.out.println(record.topic());

        return record.value();
    }
}