package com.kaka.jtest.jdk.jvm.heap;

/**
 * @author jiashuangkai
 * @date 2019/12/11 11:38:31
 */
public class GcDetail {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[1 * _1MB + 512*1024];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
    }

    public static void main(String[] args) {

        testAllocation();
    }
}
