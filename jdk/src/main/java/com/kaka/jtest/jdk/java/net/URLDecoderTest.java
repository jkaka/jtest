package com.kaka.jtest.jdk.java.net;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 解码器
 */
public class URLDecoderTest {

    @Test
    public void decode() throws Exception {
        String keyWord = URLDecoder.decode("%E7%BD%91%E7%BB%9C%E6%97%B6%E7%A9%BA", "UTF-8");
        System.out.println(keyWord);
        // 将普通字符串转换成
        // application/x-www-form-urlencoded字符串
        String urlStr = URLEncoder.encode("网络时空", "UTF-8");
        System.out.println(urlStr);
    }
}
