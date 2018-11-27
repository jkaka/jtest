package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.UUID;

/**
 * @author jsk
 * @Date 2018/11/20 10:25
 */
public class UUIDTest {

    @Test
    public void test(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
