package com.kaka.jtest.source.spi.java;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * META-INF/services 文件夹下创建一个文件，名称为 Robot 的全限定名
 *
 * @author: jsk
 * @date: 2019/5/21 20:10
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
