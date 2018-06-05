package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    /**
     * mysql官方文档解释：timestamp的范围：1970-01-01 00:00:01UTC～2038/01/19 3:14:07UTC，
     * 我们是东八区，所以我们的timestamp的范围：1970-01-01 8:00:01UTC～2038/01/19 11:14:07UTC,
     * @throws ParseException
     */
    @Test
    public void getTime() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2038-01-01 00:00:00");
        System.out.println(date.getTime());
    }

    /**
     * date的构造函数
     */
    @Test
    public void constructor(){
        System.out.println(new Date(1528162080 * 1000L));
    }
}
