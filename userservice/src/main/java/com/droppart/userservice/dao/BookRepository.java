package com.droppart.userservice.dao;
import com.droppart.userservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  BookRepository  extends MongoRepository<Book,Integer> {
    
}
