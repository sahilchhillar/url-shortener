package com.shorturl.shorturl.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shorturl.shorturl.model.Entity.Urls;
import com.shorturl.shorturl.model.POJO.UrlPOJO;

@Service
public interface UrlService {
    ResponseEntity<String> save(UrlPOJO urlPOJO) throws Exception;
    String getShortUrl();
    List<Urls> getAllUrls() throws Exception;
    String getLongUrl(String shortUrl) throws Exception;
    boolean checkIfShortUrlExists(List<Urls> shortUrls, String shortUrl) throws Exception;
    List<Urls> checkIfLongUrlExists(UrlPOJO urlPOJO) throws Exception;
    ResponseEntity<String> updateShortUrl(Urls urls) throws Exception;
    String createShortUrl() throws Exception;
}
