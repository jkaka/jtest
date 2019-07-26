package com.kaka.jtest.jdk.java.net;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * @author: jsk
 * @date: 2019/6/25 14:01
 */
public class URLTest {
    @Test
    public void openStreamTest() throws IOException {
        Enumeration<URL> urls = ClassLoader.getSystemResources("test/url/a.txt");
        if (urls != null) {
            while (urls.hasMoreElements()) {
                URL resourceURL = urls.nextElement();
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(resourceURL.openStream(), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
        }
    }




}
