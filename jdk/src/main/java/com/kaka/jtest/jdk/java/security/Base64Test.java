package com.kaka.jtest.jdk.java.security;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Base64不是为了加密,而是为了传输(有些字节在其他设备是不可见的,使用base64可转为可见的字符)
 *
 * @author jsk
 * @Date 2018/8/26 14:24
 */
public class Base64Test {

    /**
     * BASE加密后产生的字节位数是8的倍数，如果不够位数以=符号填充
     *
     * @throws IOException
     */
    @Test
    public void coder() throws IOException {
        String key = "abc";
        String result = new BASE64Encoder().encodeBuffer(key.getBytes());
        System.out.println("加密之后：" + result);
        byte[] bytes = new BASE64Decoder().decodeBuffer(result);
        System.out.println("解密：" + new String(bytes));
    }
}
