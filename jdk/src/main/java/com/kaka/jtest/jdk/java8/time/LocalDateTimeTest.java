package com.kaka.jtest.jdk.java8.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author: jsk
 * @date: 2019/7/4 18:41
 */
public class LocalDateTimeTest {

    @Test
    public void toInstant() {
        Instant instant = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8));
        System.out.println(instant.toEpochMilli());
    }

    @Test
    public void of() {
        LocalDateTime localDateTime = LocalDateTime.of(2016, 10, 26, 12, 10, 55);
        System.out.println(localDateTime);
    }

    @Test
    public void ofEpochSecond() {
        Long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);
    }

}
