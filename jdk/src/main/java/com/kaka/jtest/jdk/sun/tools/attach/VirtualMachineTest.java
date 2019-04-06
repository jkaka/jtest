package com.kaka.jtest.jdk.sun.tools.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/4/2 15:19
 */
public class VirtualMachineTest {
    @Test
    public void displayName(){
        for (VirtualMachineDescriptor vmd : VirtualMachine.list()) {
            System.out.println(vmd.displayName());
        }
    }
}
