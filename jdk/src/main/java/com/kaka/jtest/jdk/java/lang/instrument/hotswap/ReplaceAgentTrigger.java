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
//    private final static String VM_NAME = "com.ecarx.ota.Application";
    private final static String VM_NAME = "ota.jar";
    private final static String AGENT_PATH = "E:\\workspace\\myProject\\jtest\\jdk\\target\\jdk-1.0-SNAPSHOT.jar";

//    private final static String FILE_PATH = "E:\\workspace\\myProject\\jtest\\jdk\\src\\main\\java\\com\\kaka\\jtest\\jdk\\java\\lang\\instrument\\hotswap\\HotSwapBean.class";
    private final static String FILE_PATH = "D:\\Java\\jdk1.8.0_31\\lib/EcarxOtaTestController.class";
    private final static String CLASS_NAME = "com/ecarx/ota/controller/EcarxOtaTestController";
//    private final static String CLASS_NAME = "com/kaka/jtest/jdk/model/HotSwapBean";

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
                System.out.println("attached成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("hello world");
    }
}
