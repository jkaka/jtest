package com.kaka.jtest.jdk.java.nio.channels;

import org.junit.Test;
import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jsk
 * @Date 2019/3/5 19:46
 */
public class FileChannelTest {

    @Test
    public void read() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("/Users/jiashuangkai/Downloads/ideaIC-2019.3.1.dmg", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(666581608);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("");
            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char)buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    @Test
    public void mapTest() throws Exception {
        File file = new File("/Users/jiashuangkai/Downloads/ideaIC-2019.3.1000.dmg");
        FileChannel channel = new FileInputStream(file).getChannel();
        // 把文件映射到内存
        MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0, 666581608);
        File file1 = new File("/Users/jiashuangkai/Downloads/ideaIC-2019.3.1000.dmg");
        FileChannel resultFileChannel = new FileOutputStream(file1, true).getChannel();
        resultFileChannel.write(buff, 0);

        resultFileChannel.close();
        channel.close();
    }

}
