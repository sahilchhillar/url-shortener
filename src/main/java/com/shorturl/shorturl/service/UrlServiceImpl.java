package com.shorturl.shorturl.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shorturl.shorturl.model.Entity.Urls;
import com.shorturl.shorturl.model.POJO.UrlPOJO;
import com.shorturl.shorturl.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService{
    @Autowired
    private UrlRepository urlRepository;
    private String hostName = "https://shorturl.com/";

    @Override
    public ResponseEntity<String> save(UrlPOJO urlPOJO) throws Exception{
        Urls url = checkIfLongUrlExists(urlPOJO).get(0);
        if(url != null){
            updateShortUrl(url);
        }else{
            String shortUrl = createShortUrl();
            Urls urls = new Urls(urlPOJO.getLongUrl(), shortUrl, new Date());
            urlRepository.insert(urls);
            return new ResponseEntity<>(hostName+shortUrl, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public String getShortUrl() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int maxLength = 6;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<maxLength; i++){
            int pos = random.nextInt(chars.length())+1;
            stringBuilder.append(chars.charAt(pos));
        }

        return stringBuilder.toString();
    }

    @Override
    public List<Urls> getAllUrls() throws Exception{
        return urlRepository.findAll();
    }

    @Override
    public String getLongUrl(String shortUrl) throws Exception{
        return urlRepository.findByShortUrl(shortUrl).get(0).getLongUrl();
    }

    @Override
    public boolean checkIfShortUrlExists(List<Urls> shortUrls, String shortUrl) throws Exception{
        for (Urls urls : shortUrls) {
            if(urls.getShortUrl().equals(shortUrl)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Urls> checkIfLongUrlExists(UrlPOJO urlPOJO) throws Exception{
        List<Urls> urls;
        urls = urlRepository.findByLongUrl(urlPOJO.getLongUrl());
        if(!urls.isEmpty()){
            return urls;
        }else{
            urls.add(null);
            return urls;
        }
    }

    @Override
    public String createShortUrl() throws Exception {
        boolean exists = false;
        String shortUrl = "";
        List<Urls> shortUrls = urlRepository.findByShortUrl(shortUrl);
        do {
            shortUrl = getShortUrl();
            exists = checkIfShortUrlExists(shortUrls, shortUrl);
        } while (exists);
        return shortUrl;
    }

    @Override
    public ResponseEntity<String> updateShortUrl(Urls urls) throws Exception {
        String shortUrl = createShortUrl();
        urls.setShortUrl(shortUrl);
        urls.setCreatedOn(new Date());
        urlRepository.save(urls);
        return new ResponseEntity<String>(shortUrl, HttpStatus.OK);
    }
}
