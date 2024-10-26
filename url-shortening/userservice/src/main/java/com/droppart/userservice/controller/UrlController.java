package com.droppart.userservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppart.userservice.model.Url;
import com.droppart.userservice.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/droppart/urls")
public class UrlController {
     @Autowired
    private UrlService urlService;

    @PostMapping
    public Url createShortUrl(@RequestBody Url url) {
        return urlService.createShortUrl(url);
    }

    @GetMapping("/{shortUrl}")
    public String getOriginalUrl(@PathVariable String shortUrl) {
        Url url = urlService.getOriginalUrl(shortUrl);
        return url != null ? url.getOriginalUrl() : "URL not found";
    }

    @GetMapping("/redirect/{shortUrl}")
    public void redirect(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        Url url = urlService.getOriginalUrl(shortUrl);
        if (url != null) {
            response.sendRedirect(url.getOriginalUrl());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "URL not found");
        }
    }
}
