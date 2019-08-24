package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/8/20 16:05
 */
public class RuntimeExceptionTest {
    
    @Test
    public void continueRun(){
        System.out.println("开始更新数据!");
        throwRunTime();
        System.out.println("更新成功!");
    }

    private void throwRunTime(){
        System.out.println("发现没有lastUser");
        throw new RuntimeException("运行时异常了");
    }
}
