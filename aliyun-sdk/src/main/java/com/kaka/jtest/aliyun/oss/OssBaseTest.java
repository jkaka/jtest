package com.kaka.jtest.aliyun.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.kaka.common.utils.PropertiesUtil;
import com.kaka.jtest.aliyun.BaseTest;
import org.junit.After;
import org.junit.Before;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-15 17:47
 */
public class OssBaseTest extends BaseTest {
    private String accessKeyId = PropertiesUtil.getLocalProperty("oss.accessKeyId");
    private String secretAccessKey = PropertiesUtil.getLocalProperty("oss.accessKeySecret");

    protected OSS ossClient;
    protected String bucketName= "yunlei-bill";

    @Before
    public void initOss() {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, secretAccessKey);
    }

    @After
    public void after() {
        ossClient.shutdown();
    }
}
