package com.kaka.jtest.jdk.java8.time.format;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-04 14:50
 */
public class DateTimeFormatterTest {

    @Test
    public void parse(){
        String patter = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(patter);
        TemporalAccessor temporalAccessor = format.parse("2019-09-09 21:22:26");
    }

    @Test
    public void format(){
        String patter = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patter);
        String format = formatter.format(LocalDateTime.now());
        System.out.println(format);
    }
}
