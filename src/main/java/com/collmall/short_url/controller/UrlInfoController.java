package com.collmall.short_url.controller;

import com.collmall.short_url.model.UrlInfo;
import com.collmall.short_url.service.UrlInfoService;
import com.collmall.short_url.util.BrowseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: xulihui
 * @Date: 2019/9/18 23:31
 */
@RestController
public class UrlInfoController {

    @Autowired
    private UrlInfoService urlInfoService;

    @GetMapping("/")
    public void getUrl(String shortUrl) {
        if (StringUtils.isEmpty(shortUrl)) {
            return ;
        }
        UrlInfo result = urlInfoService.getUrl(shortUrl);
        BrowseUtil.browsePage(result.getUrl());
    }

    @GetMapping("/getShortUrl")
    public Map<String,String> getShortUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        Map<String,String> result = urlInfoService.getShortUrl(url);
        return  result;
    }
}
