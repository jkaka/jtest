package com.kaka.jtest.jdk.java.security;

import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/8/26 13:56
 */
public class MessageDigestTest {
    /**
     * 16进制的字符数组
     */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};

    /**
     * md5加密
     *
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
        for (byte b : messageDigest.digest()) {
            System.out.print(b + " ");
        }
        System.out.println("-----------------------------------");

        System.out.println("一般把摘要中的字节转成16进制的字符");
//        String result = byteArrayToHexString(messageDigest.digest());
//        System.out.println(result);
    }

    /**
     * sha-256加密
     * @throws Exception
     */
    @Test
    public void String2SHA256StrJava() throws Exception {
        String source = "abc";
        // 1.获得MD5摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        // 2.使用指定的字节数组更新摘要信息
        messageDigest.update(source.getBytes("UTF-8"));
        // 3.messageDigest.digest()获得16位长度的字节数组
        for (byte b : messageDigest.digest()) {
            System.out.print(b + " ");
        }
    }

    /**
     * 普通验签
     */
    @Test
    public void token() throws Exception {
        // 1.取出body体的字符串
        String appSecret = "upload";
        String bodyStr = "{\"serviceName\":\"ad\",\"key\":\"1970CBFD9B7A4C21CFF6659323D0792F\",\"fileName\":\"ClipX.rar\",\"rename\":\"\"}";
        System.out.println(bodyStr);
        String befoteSecret = (bodyStr + appSecret).replaceAll("\\s*", "");
        // 2.md5加密(加密之后把字节转为16进制的字符)
        String md5Str = Md5Util.md5Encode(befoteSecret);
        System.out.println(md5Str);
        // 3. md5字符串转大写，然后base64编码
        String baseToken = new String(new BASE64Encoder().encode(md5Str.toUpperCase().getBytes()));
        System.out.println(baseToken);
    }


    /**
     * get方式验签
     */
    @Test
    public void getTest() throws UnsupportedEncodingException {
        String path = "/check-sign/upload/resource";
        String queryStr = "filename=abc.rar&filesize=5555&timestamp=888";
        path += "?" + URLEncoder.encode(queryStr, "utf-8") + "upload";
        String beforeSecret = path.replaceAll("\\s*", "");
        System.out.println(beforeSecret);
        String md5Str = Md5Util.md5Encode(beforeSecret);
        String authorization = new String(new BASE64Encoder().encode(md5Str.toUpperCase().getBytes()));
        System.out.println(authorization);
    }

    /**
     * file验签
     */
    @Test
    public void fileToken() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "1970CBFD9B7A4C21CFF6659323D0792F");
        map.put("fileName", "ClipX.rar");
        map.put("chunk", "1");
        map.put("chunks", "10");
        map.put("fileSize", "1163860");

        Object[] keyArray = map.keySet().toArray();
        //1.把key按自然排序
        Arrays.sort(keyArray);
        int len = keyArray.length;
        String signStr = "";
        // 拼接除了file以外的参数
        for (int i = 0; i < len; i++) {
            String value = map.get(keyArray[i].toString());
            signStr += keyArray[i] + value;
        }

        // 2.拼接uri和body体中的参数
        String requestUri = "/upload/resource/oss/ihulog/uploadPart";
        requestUri += signStr;

        String appId = "upload";
        String appSecret = "upload";
        String befoteSecret = (requestUri + appSecret).replaceAll("\\s*", "");
        System.out.println(befoteSecret);
        String md5Str = Md5Util.md5Encode(befoteSecret);
        System.out.println(md5Str);
        String baseToken = new String(new BASE64Encoder().encode(md5Str.getBytes()));
        System.out.println(baseToken);
    }


    @Test
    public void md5Hash(){
        System.out.println(Md5Util.md5Encode("LP00170209246395"));
    }
}
