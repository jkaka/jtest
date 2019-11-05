package com.kaka.jtest.jdk.java8.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-04 12:56
 */
public class LocalDateTest {

    @Test
    public void create() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(1998, 2, 4);
        LocalDate date3 = LocalDate.ofEpochDay(180);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }

    /**
     * 时间日期的格式是按照ISO-8061的时间和日期标准来显示的。
     * 年份为4位数，月日时分秒都是2位数，不足两位用0补齐，日期之间需要用短横线连接
     */
    @Test
    public void parseDefault(){
        LocalDate date = LocalDate.parse("2016-09-08");
        System.out.println(date);
    }

    @Test
    public void parse(){
        String input = "20160708";
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(input, formatter);
        System.out.println(date);
    }
}
