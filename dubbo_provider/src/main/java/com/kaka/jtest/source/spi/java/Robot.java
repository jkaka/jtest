package com.kaka.jtest.source.spi.java;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author: jsk
 * @date: 2019/5/21 20:08
 */
@SPI
public interface Robot {
    void sayHello();
}
