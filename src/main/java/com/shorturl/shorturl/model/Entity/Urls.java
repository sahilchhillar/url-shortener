package com.shorturl.shorturl.model.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shortUrl")
public class Urls {
    @Id
    private String id;
    private String longUrl;
    private String shortUrl;
    private Date createdOn;
    
    public Urls(String longUrl, String shortUrl, Date createdOn){
        super();
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.createdOn = createdOn;
    }

    /**
     * @return UUID return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the longUrl
     */
    public String getLongUrl() {
        return longUrl;
    }

    /**
     * @param longUrl the longUrl to set
     */
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    /**
     * @return String return the shortUrl
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * @param shortUrl the shortUrl to set
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Urls [Id=" + id + ", longUrl=" + longUrl + ", shortUrl=" + shortUrl + "]";
    }


    /**
     * @return Date return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
