package com.kaka.jtest.jdk.java.text;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author: jsk
 * @date: 2019/8/21 15:08
 */
public class DecimalFormatTest {

    /**
     * 保留N为有效小数,6及以上进一
     */
    @Test
    public void formatTest() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        double percent = 100.566;
        String format = decimalFormat.format(percent);
        System.out.println(format);
    }
}
