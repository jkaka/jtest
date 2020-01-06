package com.kaka.jtest.jdk.java.lang.management;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;

/**
 * @author: jsk
 * @date: 2019/8/22 10:50
 */
public class ManagementFactoryTest {

    /**
     * -Xmx200M -Xms100M -Xmn10M
     */
    @Test
    public void getMemoryMXBean() {
        System.out.println("Runtime max: " + B2M(Runtime.getRuntime().maxMemory()));
        MemoryMXBean m = ManagementFactory.getMemoryMXBean();

        System.out.println("Non-heap: " + B2M(m.getNonHeapMemoryUsage().getMax()));
        System.out.println("Heap: " + B2M(m.getHeapMemoryUsage().getMax()));

        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println("Pool: " + mp.getName() + " (type " + mp.getType() + ")" + " = " + B2M(mp.getUsage().getMax()));
        }
    }

    /**
     * 字节转兆
     * 1kB=1024B
     * 1B=8bit
     *
     * @param s
     * @return
     */
    public static String B2M(long s) {
        return String.format("%d (%.2f M)", s, (double) s / (1024 * 1024));
    }
}
