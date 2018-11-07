package com.kaka.jtest.jdk.java.io;

import org.junit.Test;

import java.io.*;

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
    public void length() {
        File file = new File("F:\\日常工作\\上传服务/ifly-2016-01-01_00-00-24-1451577624888.log");
        System.out.println(file.length());
    }

    @Test
    public void createFile() throws Exception {
        File file = new File("E:\\workspace\\generateCode\\test/one.txt");
        Writer writer = new FileWriter(file);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            writer.write(i + "a");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\workspace\\generateCode\\test/one.txt");
        Writer writer = new FileWriter(file);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            writer.write(i + "a");
            writer.flush();
            System.exit(0);
        }
        writer.close();
    }

}
