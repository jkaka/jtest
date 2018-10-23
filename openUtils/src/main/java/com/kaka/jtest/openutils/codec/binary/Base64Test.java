package com.kaka.jtest.openutils.codec.binary;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
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
        String string = "GAPP  测试2\n" +
                "1GAPP第一次上线 大家赏脸\n" +
                "2AGAIN\n" +
                "3在测试一次\n" +
                "4实在编不下去了";
        byte[] base64 = Base64.encodeBase64(string.getBytes());
        String baseToken = new String(base64);
        System.out.println(baseToken);
    }

    public static void main(String[] args) {
        Long timestamp = (System.currentTimeMillis() / 1000);
        System.out.println(timestamp);
        String secretKey = "FDAA721C1BD44D0D8B171B5F690E6F228E6D28FD16F74DE8AFC7A17A62FECC970086E214A8F94DA9B65C-F2CF0C96D81";
        String sign = "OTA" + "zhengjie.gao" + secretKey + timestamp;
        System.out.println(DigestUtils.sha256Hex(sign));
        System.out.println();
    }

}
