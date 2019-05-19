package com.kaka.jtest.jdk.sun.tools.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.junit.Test;

/**
 * Attach API可不仅仅是为了实现动态加载agent，Attach API其实是跨JVM进程通讯的工具，能够将某种指令从一个JVM进程发送给另一个JVM进程。
 * 加载agent只是Attach API发送的各种指令中的一种， 诸如jstack打印线程栈、jps列出Java进程、jmap做内存dump等功能，
 * 都属于Attach API可以发送的指令。
 *
 * @author: jsk
 * @date: 2019/4/2 15:19
 */
public class VirtualMachineTest {
    @Test
    public void displayName() {
        for (VirtualMachineDescriptor vmd : VirtualMachine.list()) {
            System.out.println(vmd.displayName());
        }
    }
}
