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

    /**
     * 创建LocalDateTime的两种方式
     */
    @Test
    public void create() {
        // now创建当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // of()创建指定时间
        LocalDateTime localDateTime = LocalDateTime.of(2019, 10, 26,
                12, 10, 55);
        System.out.println(localDateTime);
    }

    /**
     * 借助instant时间戳，获取秒、毫秒、纳秒
     * 1秒=1000毫秒
     * 1毫秒=1000微秒
     * 1微秒=1000纳秒
     * 1纳秒=1000皮秒
     * 1皮秒=1000飞秒
     */
    @Test
    public void toInstant() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(8));
        System.out.println("10位秒数：" + instant.getEpochSecond());
        System.out.println("13位毫秒数：" + instant.toEpochMilli());
        // getNano()返回的是纳秒的第二部分，需要与秒数拼接起来，才是完整的纳秒
        System.out.println(instant.getNano());
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
        System.out.println("秒:" + localDateTime.toEpochSecond(ZoneOffset.ofHours(8)));
        System.out.println("秒:" + System.currentTimeMillis() / 1000);
        System.out.println("毫秒(先toInstant):" + localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println("毫秒:" + System.currentTimeMillis());
    }

    /**
     * 加减时间(原时间不变)
     */
    @Test
    public void plusOrMinus() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = now.minusDays(1);
        System.out.println(now);
        System.out.println(dateTime);
    }
}
