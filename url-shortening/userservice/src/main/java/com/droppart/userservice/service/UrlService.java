package com.droppart.userservice.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droppart.userservice.model.Url;
import com.droppart.userservice.repository.UrlRepository;

@Service
public class UrlService {
     @Autowired
    private UrlRepository urlRepository;

    public Url createShortUrl(Url url) {
        String shortUrl = generateShortUrl();
        url.setShortUrl(shortUrl);
        return urlRepository.save(url);
    }

    public Url getOriginalUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }
}
