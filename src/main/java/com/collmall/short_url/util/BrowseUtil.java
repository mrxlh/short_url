package com.collmall.short_url.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author: xulihui
 * @Date: 2019/9/19 22:29
 */

public class BrowseUtil {

    /**
     * 打开浏览器访问URL
     */
    public static void browsePage(String url) {
        try {
            // 调用默认浏览器
            CommandUtil.browse(new URI(url));
        } catch (URISyntaxException e) {
            System.out.println("打开浏览器失败:" + e.getMessage()+","+ e);
        }
    }

}
