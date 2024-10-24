package com.customkafka.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.customkafka.service.MessageEntity;
import com.customkafka.service.MessageRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
        MessageEntity messageEntity = new MessageEntity(message);
        messageRepository.save(messageEntity);
    }
}
