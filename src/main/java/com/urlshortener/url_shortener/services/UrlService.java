package com.urlshortener.url_shortener.services;

import com.urlshortener.url_shortener.model.entity.Url;
import com.urlshortener.url_shortener.model.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String shortenUrl(String longUrl) {
        String shortId = UUID.randomUUID().toString().substring(0, 7);
        Url url = new Url();
        url.setShortId(shortId);
        url.setLongUrl(longUrl);
        urlRepository.save(url);
        return shortId;
    }

    public String getLongUrl(String shortId) {
        Url url = urlRepository.findByShortId(shortId);
        return url != null ? url.getLongUrl() : null;
    }
}
