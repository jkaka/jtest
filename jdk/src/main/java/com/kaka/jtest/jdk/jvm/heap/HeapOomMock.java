package com.kaka.jtest.jdk.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx20m -Xms20m
 *
 * @author jsk
 * @date 2019/1/28 18:58
 */
public class HeapOomMock {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        boolean flag = true;
        while (flag) {
            // 每次增加一个1M大小的数组对象
            try {
                i++;
                list.add(new byte[1024 * 1024]);
                System.out.println(i + "M          .....");
            } catch (Throwable e) {
                System.out.println("出现OOM异常,count=" + i);
                e.printStackTrace();
                flag = false;
            }
        }
    }
}
