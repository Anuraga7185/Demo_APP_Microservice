package com.customkafka.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.customkafka.service.MessageEntity;
import com.customkafka.service.MessageRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void cabLocation(String location) {
        System.out.println(location);
    }
}
