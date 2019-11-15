package com.kaka.jtest.jdk.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx40m -Xms20m
 * <p>
 * 设置出现OOM时生成堆文件，并制定堆文件生成地址(默认生成在程序的同级目录)
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/jiashuangkai/jvm
 * <p>
 * 也可以直接执行命令jmap -dump:format=b,file=heap.bin pid
 * file：保存路径及文件名
 * pid：进程编号（windows通过任务管理器查看，linux通过ps aux查看）
 * dump文件可以通过MemoryAnalyzer(MAT)分析查看,可以查看dump时对象数量，内存占用，线程情况等。
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

        // OOM导致的jvm退出,会进入到这个钩子函数，且内存还未被释放。
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            long totalMemory = Runtime.getRuntime().totalMemory();
            System.out.println("jvm退出,totalMemory:" + totalMemory / (1024 * 1024) + "M");
        }));
    }
}
