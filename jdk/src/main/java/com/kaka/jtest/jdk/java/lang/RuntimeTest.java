package com.kaka.jtest.jdk.java.lang;

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
}
