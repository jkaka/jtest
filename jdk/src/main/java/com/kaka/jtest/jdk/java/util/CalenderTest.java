package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderTest {

    @Test
    public void getTimeInMillis(){
        Calendar calendar = new GregorianCalendar();
        Long millis = calendar.getTimeInMillis();
        System.out.println(millis);
    }


    @Test
    public void getTime(){
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    public void compareTo(){
        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        calendar2.add(Calendar.HOUR, 1);
        // 小于   -1
        System.out.println(calendar1.compareTo(calendar2));
        // 等于   0
        System.out.println(calendar1.compareTo(calendar1));
        // 大于   1
        System.out.println(calendar2.compareTo(calendar1));
    }
}
