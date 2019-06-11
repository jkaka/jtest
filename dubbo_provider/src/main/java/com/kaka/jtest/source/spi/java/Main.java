package com.kaka.jtest.source.spi.java;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author: jsk
 * @date: 2019/5/21 20:10
 */
public class Main {
    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
