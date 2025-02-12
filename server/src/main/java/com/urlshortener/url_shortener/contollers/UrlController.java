package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody String longUrl) {
        String shortId = urlService.shortenUrl(longUrl);
        return ResponseEntity.ok("http://localhost:8080/" + shortId);
    }

    @GetMapping("/{shortId}")
    public ResponseEntity<?> redirectToUrl(@PathVariable String shortId) {
        String longUrl = urlService.getLongUrl(shortId);
        if (longUrl != null) {
            return ResponseEntity.status(302).header("Location", longUrl).build();
        } else {
            return ResponseEntity.status(404).body("URL not found");
        }
    }
}
