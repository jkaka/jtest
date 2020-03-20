package com.kaka.jtest.jdk.java.lang.instrument.hotswap;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

/**
 * @author: jsk
 * @date: 2019/4/3 15:40
 */
public class ReplaceAgentTrigger {
    //    private final static String VM_NAME = "com.kaka.jtest.jdk.java.lang.instrument.hotswap.ReplaceAgentMain";
//    private final static String VM_NAME = "com.jsk.ota.Application";
    private final static String VM_NAME = "ota.jar";
    private final static String AGENT_PATH = "E:\\workspace\\myProject\\jtest\\jdk\\target\\jdk-1.0-SNAPSHOT.jar";

    //    private final static String FILE_PATH = "E:\\workspace\\myProject\\jtest\\jdk\\src\\main\\java\\com\\kaka\\jtest\\jdk\\java\\lang\\instrument\\hotswap\\HotSwapBean.class";
    private final static String FILE_PATH = "D:\\Java\\jdk1.8.0_31\\lib/jskOtaTestController.class";
    private final static String CLASS_NAME = "com/jsk/ota/controller/jskOtaTestController";
//    private final static String CLASS_NAME = "com/kaka/jtest/jdk/model/HotSwapBean";

    /**
     * Attach API 不是 Java 的标准 API，而是 Sun 公司提供的一套扩展 API，用来向目标 JVM ”附着”（Attach）代理工具程序的。
     * 有了它，开发者可以方便的监控一个 JVM，运行一个外加的代理程序。
     *
     * Attach API 很简单，只有 2 个主要的类，都在 com.sun.tools.attach 包里面： VirtualMachine 代表一个 Java 虚拟机，
     * 也就是程序需要监控的目标虚拟机，提供了 JVM 枚举，Attach 动作和 Detach 动作（Attach 动作的相反行为，从 JVM 上面解除一个代理）等等 ;
     * VirtualMachineDescriptor 则是一个描述虚拟机的容器类，配合 VirtualMachine 类完成各种功能。
     *
     * 1. 列出当前所有的JVM实例描述
     * 2. Attach到其中一个JVM上，建立通信管道
     * 3. 让目标JVM加载Agent
     */
    public static void main(String[] args) {
        VirtualMachineDescriptor vmdTar = null;
        // VirtualMachine类可以拿到这台机子的所有jvm进程
        for (VirtualMachineDescriptor vmd : VirtualMachine.list()) {
            if (vmd.displayName().equals(VM_NAME)) {
                vmdTar = vmd;
                System.out.println("发现匹配的VM！");
                break;
            }
        }
        if (vmdTar != null) {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("filePath", FILE_PATH);
                jsonObject.put("className", CLASS_NAME);

                VirtualMachine vm = VirtualMachine.attach(vmdTar);
                vm.loadAgent(AGENT_PATH, jsonObject.toJSONString());
                vm.detach();
                System.out.println("attached成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("hello world");
    }
}
