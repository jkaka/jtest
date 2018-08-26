package com.kaka.jtest.jdk.java.security;

import org.junit.Test;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jsk
 * @Date 2018/8/26 13:56
 */
public class MessageDigestTest {
    /** 16进制的字符数组 */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    /**
     * 生成摘要
     * @throws Exception
     */
    @Test
    public void digest() throws Exception {
        String source = "abc";
        // 1.获得MD5摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        // 2.使用指定的字节数组更新摘要信息
        messageDigest.update(source.getBytes("utf-8"));
        // 3.messageDigest.digest()获得16位长度的字节数组
        for(byte b : messageDigest.digest()){
            System.out.print(b+ " ");
        }
        System.out.println("-----------------------------------");

        System.out.println("一般把摘要转成16进制的数值");
        String result = byteArrayToHexString(messageDigest.digest());
        System.out.println(result);
    }


    /**
     * 转换字节数组为16进制字符串
     *
     * @param bytes 字节数组
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }

    /**
     * 转换byte到16进制
     *
     * @param b
     *            要转换的byte
     * @return 16进制对应的字符
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
