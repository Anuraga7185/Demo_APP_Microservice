package com.customkafka.service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class MessageEntity {

    @Id
    private String id;
    private String message;

    public MessageEntity(String message) {
        this.message = message;
    }

    // Getters and setters
}
