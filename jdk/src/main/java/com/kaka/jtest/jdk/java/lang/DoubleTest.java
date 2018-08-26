package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author jsk
 * @Date 2018/8/21 11:21
 */
public class DoubleTest {

    @Test
    public void compare(){
        Double totalSize = 1010000.0;
        Double uploadedSize = 1010000.0;
        System.out.println(uploadedSize > totalSize);
    }
}
