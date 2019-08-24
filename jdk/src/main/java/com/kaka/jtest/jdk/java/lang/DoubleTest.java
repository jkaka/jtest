package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jsk
 * @Date 2018/8/21 11:21
 */
public class DoubleTest {

    @Test
    public void compare() {
        Double totalSize = 1010000.0;
        Double uploadedSize = 1010000.0;
        System.out.println(uploadedSize > totalSize);
    }

    /**
     * double转integer
     */
    @Test
    public void intValue() {
        Double d = new Double(55.22);
        System.out.println(d.intValue());
    }

    /**
     * 科学计数法转普通数值
     *  /saɪən'tɪfɪk/
     */
    @Test
    public void scientific2Common() {
        // 5.568987135E9
        Double num = 5.568987135E9;
        System.out.println(num);

        BigDecimal bg = new BigDecimal(num + "");
        System.out.println(bg);
    }
    
    @Test
    public void scientific(){
        Double used = 3.92129728E8;
        Double max = 4.108320767E9;

        System.out.println(used/max * 100 + "%");
        System.out.println(used/1024/1024 + "M");
    }
}
