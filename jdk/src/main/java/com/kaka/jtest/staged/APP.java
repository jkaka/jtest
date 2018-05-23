package com.kaka.jtest.staged;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class APP {

    @Test
    public void test() throws Exception{
        System.out.println(APP.generateDigest("123"));
    }

    private static String generateDigest(String idPassword)
            throws NoSuchAlgorithmException {
        Base64.Encoder encoder = Base64.getEncoder();
        String parts[] = idPassword.split(":", 2);
        byte digest[] = MessageDigest.getInstance("SHA1").digest(idPassword.getBytes());
        return parts[0] + ":" + encoder.encodeToString(digest);
    }

}
