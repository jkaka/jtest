package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.java.lang.management.ManagementFactoryTest;
import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

/**
 * @author jsk
 * @Date 2018/9/14 9:34
 */
public class RuntimeTest {

    /**
     * 获取处理器数量
     */
    @Test
    public void getRuntime() {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        int threadNum = cpuNum * 2 + 1;// 根据cpu数量,计算出合理的线程并发数
        int corePoolSize = threadNum - 1;// 核心线程数
        int maximumPoolSize = threadNum; // 最大线程数
        System.out.println("cpu数量：" + cpuNum);
        System.out.println("最佳核心线程数量：" + corePoolSize + "(默认双核)");
        System.out.println("最大线程数量：" + maximumPoolSize);
        new Person();
    }

    /**
     * -Xmx188M -Xms188M -Xmn20M
     * <p>
     * {@link ManagementFactoryTest}
     */
    @Test
    public void memoryTest() {
        // 最大可用内存减去一个Survivor的大小
        // 最大可用内存:对应-Xmx,默认值为物理内存的1/4;设置不能高于计算机物理内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(maxMemory / (1024 * 1024) + "M");

        //当前JVM空闲内存
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println(freeMemory / (1024 * 1024) + "M");

        //当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(totalMemory / (1024 * 1024) + "M");
    }

}
