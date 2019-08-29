package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTest {

    /**
     * mysql官方文档解释：timestamp的范围：1970-01-01 00:00:01UTC～2038/01/19 3:14:07UTC，
     * 我们是东八区，所以我们的timestamp的范围：1970-01-01 8:00:01UTC～2038/01/19 11:14:07UTC,
     * @throws ParseException
     */
    @Test
    public void timestamp() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("1970-01-01 08:00:01");
        System.out.println(date.getTime());
    }

    /**
     * getTime：得到1970-01-01 00:00:00到现在的毫秒数
     * 中国是东八区,所以开始时间为：1970-01-01 08:00:00
     * @throws ParseException
     * @throws InterruptedException
     */
    @Test
    public void getTime() throws ParseException, InterruptedException {
        Date date = new Date();
        System.out.println(date.getTime());
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println(System.currentTimeMillis());

    }
    /**
     * date的构造函数
     */
    @Test
    public void constructor(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date(1549011962288L)));
        System.out.println(dateFormat.format(new Date(1549011962288L)));
        System.out.println(dateFormat.format(new Date(1549011837397L)));
        System.out.println(dateFormat.format(new Date(1550653437397L)));
    }

    @Test
    public void constructTest(){
        Date date = new Date(1566885312164L);
        System.out.println(date);
    }
}
