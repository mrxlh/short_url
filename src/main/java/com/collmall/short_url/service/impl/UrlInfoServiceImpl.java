package com.collmall.short_url.service.impl;

import com.collmall.short_url.mapper.UrlInfoMapper;
import com.collmall.short_url.model.UrlInfo;
import com.collmall.short_url.service.UrlInfoService;
import com.collmall.short_url.util.ShortUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xulihui
 * @Date: 2019/9/18 23:41
 */
@Service
public class UrlInfoServiceImpl implements UrlInfoService {


    @Autowired
    private UrlInfoMapper urlInfoMapper;

    @Override
    public Map<String, String> getShortUrl(String url) {
        String shortUrl = ShortUrlUtil.shortUrl2();
        Map<String, String> result = new HashMap<>(2);
        UrlInfo bean = new UrlInfo();
        bean.setDeleted(false);
        bean.setUrl(url);
        bean.setShortUrl(shortUrl);
        urlInfoMapper.insert(bean);
        result.put("url",url);
        result.put("short_url",shortUrl);
        return result;
    }

    @Override
    public UrlInfo getUrl(String shortUrl) {
        return urlInfoMapper.getUrl(shortUrl);
    }
}
