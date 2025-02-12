package com.urlshortener.url_shortener.model.repository;

import com.urlshortener.url_shortener.model.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortId(String shortId);
} 