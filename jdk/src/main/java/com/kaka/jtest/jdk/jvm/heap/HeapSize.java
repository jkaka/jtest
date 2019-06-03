package com.kaka.jtest.jdk.jvm.heap;

/**
 * 默认新生代:老年代=1:2
 * 默认Eden:s0:s1=8:1:1
 * 大对象直接进入老年代,不进survivor
 *
 * @author: jsk
 * @date: 2019/6/1 17:27
 */
public class HeapSize {
    private static byte[][] bytes = new byte[3000][1];

    public static void main(String[] args) {
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("使用内存:" + (i + 1) + "M...");
            bytes[i] = new byte[1024 * 1024];
        }
    }
}
