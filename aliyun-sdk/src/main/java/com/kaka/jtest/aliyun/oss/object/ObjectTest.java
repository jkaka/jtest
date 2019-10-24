package com.kaka.jtest.aliyun.oss.object;

import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.kaka.jtest.aliyun.oss.OssBaseTest;
import org.junit.Test;

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
		}catch (OSSException e){
			System.out.println("出现异常!errorCode:" + e.getErrorCode());
		}
	}

}
