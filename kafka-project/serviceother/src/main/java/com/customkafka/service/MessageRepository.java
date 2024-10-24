package com.customkafka.service;
import com.customkafka.service.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface MessageRepository extends MongoRepository<MessageEntity, String> {
}
