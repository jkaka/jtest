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
