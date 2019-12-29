package com.kaka.jtest.jdk.java.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @date 2019/12/18 14:35:43
 */
public class SimpleDateFormatTest {

    @Test
    public void parseUTCTime() throws ParseException {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+00:00");
        date = sdf.parse("2019-12-21T07:15:59.363+00:00");

        SimpleDateFormat beiJingFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(beiJingFormat.format(date));
    }
}
