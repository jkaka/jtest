package com.kaka.jtest.jdk.java8.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    /**
     * 秒数转datetime
     */
    @Test
    public void ofEpochSecond() {
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.ofEpochSecond(1463287833, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime1);
    }

    /**
     * 把时间按照指定格式，解析为字符串
     */
    @Test
    public void format() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        LocalDateTime date = LocalDateTime.now();
        String dateStr = date.format(format);
        System.out.println(dateStr);
    }

    /**
     * 把字符串按指定格式，解析为时间
     */
    @Test
    public void parse() {
        String str1 = "2018-07-05 12:24:12";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str1, dtf);
        System.out.println(dateTime);
        dateTime.atZone(ZoneId.of(""));
        dateTime.getSecond();
    }

    /**
     * 获取区域时间
     */
    @Test
    public void atZone() {
        ZoneId zoneId = ZoneId.of("+8");
        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(zoneId);
        System.out.println(zonedDateTime.toEpochSecond());

        System.out.println(System.currentTimeMillis() / 1000);
    }

    /**
     * 获取各类信息
     */
    @Test
    public void getInfo() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.toEpochSecond(ZoneOffset.ofHours(8)));
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println(System.currentTimeMillis());
    }
}
