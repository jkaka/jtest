package com.kaka.jtest.jdk.java.io;

import org.junit.Test;

import java.io.File;

/**
 * @author jsk
 * @Date 2018/8/16 14:50
 */
public class FileTest {

    /**
     * {@link FileTest}
     * length:文件的大小(单位：字节)
     */
    @Test
    public void length(){
        File file = new File("F:\\日常工作\\上传服务/ifly-2016-01-01_00-00-24-1451577624888.log");
        System.out.println(file.length());
    }
}
