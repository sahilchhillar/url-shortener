package com.shorturl.shorturl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shorturl.shorturl.model.Entity.Urls;
import com.shorturl.shorturl.model.POJO.UrlPOJO;
import com.shorturl.shorturl.service.UrlServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class UrlController {
    @Autowired
    private UrlServiceImpl urlServiceImpl;

    @PostMapping(value = "/save", headers = {"content-type=application/json"})
    public ResponseEntity<String> saveLongUrl(@RequestBody UrlPOJO urlPOJO) throws Exception{
        System.out.println(urlPOJO);
        return urlServiceImpl.save(urlPOJO);
    }

    @GetMapping("/findAll")
    public List<Urls> getAllUrls() throws Exception{
        return urlServiceImpl.getAllUrls();
    }

    @GetMapping("/findLongUrl/{shortUrl}")
    public String getLongUrl(@PathVariable String shortUrl) throws Exception{
        System.out.println(shortUrl);
        return urlServiceImpl.getLongUrl(shortUrl);
    }
}
