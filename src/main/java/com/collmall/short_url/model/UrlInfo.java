package com.collmall.short_url.model;

/**
 * @Author: xulihui
 * @Date: 2019/9/18 23:23
 */
public class UrlInfo extends  BaseModel {

    private  String url;

    private  String shortUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

}
