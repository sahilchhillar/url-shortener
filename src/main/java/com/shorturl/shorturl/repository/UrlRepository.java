package com.shorturl.shorturl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shorturl.shorturl.model.Entity.Urls;

@Repository
public interface UrlRepository extends MongoRepository<Urls, String>{
    List<Urls> findByShortUrl(String shortUrl);
    List<Urls> findByLongUrl(String longUrl);
}
