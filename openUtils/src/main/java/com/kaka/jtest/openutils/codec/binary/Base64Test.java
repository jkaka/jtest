package com.kaka.jtest.openutils.codec.binary;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * @author jsk
 * @Date 2018/8/26 14:16
 */
public class Base64Test {

    /**
     * base64加密
     */
    @Test
    public void encodeBase64() {
        String string = "abc";
        byte[] base64 = Base64.encodeBase64(string.getBytes());
        String baseToken = new String(base64);
        System.out.println(baseToken);
    }
}
