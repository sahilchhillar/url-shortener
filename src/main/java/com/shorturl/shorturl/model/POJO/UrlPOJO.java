package com.shorturl.shorturl.model.POJO;

import java.util.Date;

public class UrlPOJO {
    private String longUrl;
    private String shortUrl;
    private String id;
    private Date createdOn;

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

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
