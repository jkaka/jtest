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
    public void writer() throws Exception {
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

    @Test
    public void createTempFile() throws Exception {
        // 默认临时目录来创建临时文件
        final File htmlFile = File.createTempFile("temp", ".txt");
        // 也可以使用 createTempFile(String prefix, String suffix, File directory) 中的 directory 参数来指定临时文件的目录
        System.out.println("临时文件所在的本地路径：" + htmlFile.getCanonicalPath());
        OutputStream outputStream = new FileOutputStream(htmlFile);
        try {
            //这里处理业务逻辑
            outputStream.write("abcde".getBytes());
        } finally {
            //关闭临时文件
            outputStream.flush();
            outputStream.close();
            //程序退出时删除临时文件
            htmlFile.deleteOnExit();
        }
    }

    /**
     * 创建多级文件
     *
     * @throws IOException
     */
    @Test
    public void createFile() throws IOException {
        File file = new File("");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
    }

}
