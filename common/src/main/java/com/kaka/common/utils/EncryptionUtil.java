package com.kaka.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jsk
 * @Date 2018/10/15 9:33
 */
public class EncryptionUtil {

    public static String string2SHA256(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            // 字节数组转为16进制
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    /**
     * Base64 encode
     */
    public static String base64Encode(String data) {
        return Base64.encodeBase64String(data.getBytes());
    }

    /**
     * Base64 decode
     *
     * @throws UnsupportedEncodingException
     */
    public static String base64Decode(String data) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(data.getBytes()), "utf-8");
    }

    /**
     * md5
     */
    public static String md5Hex(String data) {
        return DigestUtils.md5Hex(data);
    }

    /**
     * sha1
     */
    public static String sha1Hex(String data) {
        return DigestUtils.sha1Hex(data);
    }

    /**
     * sha256
     */
    public static String sha256Hex(String data) {
        return DigestUtils.sha256Hex(data);
    }
}
