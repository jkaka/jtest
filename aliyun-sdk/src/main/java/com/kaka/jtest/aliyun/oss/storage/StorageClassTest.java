package com.kaka.jtest.aliyun.oss.storage;

import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.StorageClass;
import com.kaka.jtest.aliyun.oss.OssBaseTest;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-15 19:23
 */
public class StorageClassTest extends OssBaseTest {

    @Test
    public void restoreTest() throws InterruptedException {
        String objectName = "1654218965343050_BillingItemDetail_201905";
        ObjectMetadata objectMetadata = ossClient.getObjectMetadata(bucketName, objectName);

        // 校验文件是否为归档文件。
        StorageClass storageClass = objectMetadata.getObjectStorageClass();
        System.out.println(storageClass.toString());
        if (storageClass == StorageClass.Archive) {
            // 解冻文件。
            ossClient.restoreObject(bucketName, objectName);
            // 等待解冻完成。
            do {
                Thread.sleep(1000);
                objectMetadata = ossClient.getObjectMetadata(bucketName, objectName);
            } while (!objectMetadata.isRestoreCompleted());
        }
    }
}
