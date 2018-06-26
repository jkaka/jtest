package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderTest {

    @Test
    public void getTimeInMillis(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        Long millis = calendar.getTimeInMillis();
        System.out.println(millis);
    }
}
