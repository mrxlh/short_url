package com.collmall.short_url.service;

import com.collmall.short_url.model.UrlInfo;

import java.util.Map;

/**
 * @Author: xulihui
 * @Date: 2019/9/18 23:32
 */
public interface UrlInfoService {

    Map<String, String> getShortUrl(String url);

    UrlInfo getUrl(String shortUrl);
}
