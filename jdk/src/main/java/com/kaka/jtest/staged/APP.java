package com.kaka.jtest.staged;

import com.kaka.jtest.jdk8.Person;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

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

    @Test
    public void test1(){
        List<Person> list =null;
        list.stream().filter(task ->
                null != task.getId()
                        && task.getId()< System.currentTimeMillis()
                        )
                .forEach((task) -> {
                    System.out.println("---");
                    task.setName("offline");
                    System.out.println(task);
                });
    }

}
