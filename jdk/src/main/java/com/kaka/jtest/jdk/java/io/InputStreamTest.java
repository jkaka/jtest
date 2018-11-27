package com.kaka.jtest.jdk.java.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author jsk
 * @Date 2018/11/14 19:46
 */
public class InputStreamTest {

    /**
     * 把输入流中的数据读取到byte[]
     * 1.byte[]转成string;string再转成byte[]之后,把这个byte[]写入到新文件,打开文件提示文件已损坏
     * 2.直接把byte当成一个个的字节，再写入到新文件，文件也不是原来的文件
     *
     * @throws Exception
     */
    @Test
    public void read() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\workspace\\otherTest/test.zip");
        int length = inputStream.available();
        byte[] bytes = new byte[length];
        inputStream.read(bytes);
        inputStream.close();

        String string = "8075341000800123-12410277000000000000500011610111511647807534200088015-12310277-6211742-92400020001200011610111511647111110101461161201165172408075126301000800123-12410277000000000000503600000001600000001161011151164710032000001024024-2-111-70-85117-44124-2-111-70-85117-44162481103-85117-441807512630200088015-12310277-6211742-92400020001203600000003200035000116101115116471111101014611612011610032000001024042394195-84117-44124-2-111-70-85117-44124-2-111-70-85117-44180755600002020-750008100000";

        OutputStream outputStream = new FileOutputStream("E:\\workspace\\otherTest/testCopy.zip");
        outputStream.write(string.getBytes());
        outputStream.close();
    }

}
