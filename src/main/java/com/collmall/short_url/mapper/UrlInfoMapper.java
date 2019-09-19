package com.collmall.short_url.mapper;

import com.collmall.short_url.model.UrlInfo;

/**
 * @Author: xulihui
 * @Date: 2019/9/18 23:25
 */
public interface UrlInfoMapper {

    public void insert(UrlInfo urlInfo);

    UrlInfo getUrl(String shortUrl);
}
