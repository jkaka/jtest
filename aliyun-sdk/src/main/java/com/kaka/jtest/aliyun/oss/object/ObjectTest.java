package com.kaka.jtest.aliyun.oss.object;

import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.kaka.jtest.aliyun.oss.OssBaseTest;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 12:56
 */
public class ObjectTest extends OssBaseTest {

    @Test
    public void getObject() {
        try {
            OSSObject object = ossClient.getObject(bucketName, "multi_line/javaException.txt");
            System.out.println(object);
        } catch (OSSException e) {
            System.out.println("出现异常!errorCode:" + e.getErrorCode());
        }
    }


    @Test
    public void putObject() throws FileNotFoundException {
        for (int i = 0; i < 1200; i++) {
            InputStream inputStream = new FileInputStream("/Users/jiashuangkai/Downloads/preview.csv");
            String key = "jsk_test/test_threshold/test_file" + i + ".csv";
            ossClient.putObject(bucketName, key, inputStream);
            System.out.println("已上传文件个数:" + i + 1);
        }
    }
}
