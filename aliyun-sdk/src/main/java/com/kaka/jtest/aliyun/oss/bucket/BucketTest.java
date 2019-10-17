package com.kaka.jtest.aliyun.oss.bucket;

import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.StorageClass;
import com.kaka.jtest.aliyun.oss.OssBaseTest;
import org.junit.Test;

import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-15 17:00
 */
public class BucketTest extends OssBaseTest {

    @Test
    public void listBuckets() {
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }
    }

    @Test
    public void createBucket(){
        CreateBucketRequest createBucketRequest = new CreateBucketRequest("jsk-store");
        createBucketRequest.setStorageClass(StorageClass.Archive);
        Bucket bucket = ossClient.createBucket(createBucketRequest);
        System.out.println(bucket.getName());
        System.out.println(bucket.getCreationDate());
    }
}
