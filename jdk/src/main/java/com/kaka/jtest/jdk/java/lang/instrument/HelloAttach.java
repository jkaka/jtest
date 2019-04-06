package com.kaka.jtest.jdk.java.lang.instrument;

import java.lang.instrument.Instrumentation;

/**
 * @author: jsk
 * @date: 2019/4/3 14:44
 */
public class HelloAttach {
    public static void agentmain(String agentArgument, Instrumentation instrumentation){
        System.out.println("hello agent");
        System.out.println("hello agent!     agentArgument:" + agentArgument);
    }
}
