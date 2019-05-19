package com.kaka.jtest.jdk.java.lang.instrument;


import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

/**
 * @author: jsk
 * @date: 2019/4/3 14:46
 */
public class AttachAgentMain {
    public static void main(String[] args){
        final String vmName = "com.kaka.jtest.jdk.java.lang.instrument.AttachAgentMain";
        final String agentPath = "E:\\workspace\\myProject\\jtest\\jdk\\target\\jdk-1.0-SNAPSHOT.jar";
        VirtualMachineDescriptor vmdTar = null;
        // VirtualMachine类可以拿到这台机子的所有jvm进程
        for(VirtualMachineDescriptor vmd : VirtualMachine.list()){
            System.out.println("vm主类名称:" + vmd.displayName());
            if(vmd.displayName().equals(vmName)){
                vmdTar = vmd;
                System.out.println("发现匹配的VM！");
                break;
            }
        }
        if(vmdTar !=  null){
            try {
                VirtualMachine vm = VirtualMachine.attach(vmdTar);
                vm.loadAgent(agentPath, "argument???");
                System.out.println("attached成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("hello world");
    }
}
