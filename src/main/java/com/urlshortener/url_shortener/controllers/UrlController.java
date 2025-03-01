package com.urlshortener.url_shortener.controllers;

import com.urlshortener.url_shortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class UrlController {

    @Autowired
    private UrlService urlService;

    @Value("${app.base-url}")
    private String baseUrl;

    @PostMapping(value = "/api/shorten", consumes = "text/plain")
    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl) {
        try {
            String shortId = urlService.shortenUrl(longUrl);
            return ResponseEntity.ok(baseUrl + "/" + shortId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing URL");
        }
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