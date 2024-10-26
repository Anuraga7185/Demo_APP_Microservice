package com.droppart.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.droppart.userservice.model.Url;

public interface UrlRepository extends MongoRepository<Url,String> {
    Url findByShortUrl(String shortUrl);
    
} 