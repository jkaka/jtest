package com.kaka.jtest.aliyun.oss.storage;

import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.StorageClass;
import com.kaka.jtest.aliyun.oss.OssBaseTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-15 19:23
 */
public class StorageClassTest extends OssBaseTest {

	String storeBucketName = "jsk-store";

	/**
	 * 解冻归档文件
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void restoreTest() throws InterruptedException {
		String objectName = "test.md";
		ObjectMetadata objectMetadata = ossClient.getObjectMetadata(storeBucketName, objectName);

		// 1. 校验文件是否为归档文件
		StorageClass storageClass = objectMetadata.getObjectStorageClass();
		if (storageClass == StorageClass.Archive) {
			System.out.println("归档文件:" + objectName);
		} else {
			System.out.println("不是归档文件:" + objectName);
			return;
		}
		// 2. 是否已解冻
		// 没解冻过时 objectMetadata.getObjectRawRestore() 为null
		if (StringUtils.isNotBlank(objectMetadata.getObjectRawRestore())
				&& objectMetadata.isRestoreCompleted()) {
			System.out.println("该文档:" + objectName + "  已解冻完成,无需重复解冻...");
		} else {
			// 解冻文件。
			ossClient.restoreObject(storeBucketName, objectName);
			// 等待解冻完成。
			do {
				Thread.sleep(10 * 1000);
				objectMetadata = ossClient.getObjectMetadata(storeBucketName, objectName);
				System.out.println(objectMetadata.getObjectStorageClass());
			} while (!objectMetadata.isRestoreCompleted());
		}
	}
}
