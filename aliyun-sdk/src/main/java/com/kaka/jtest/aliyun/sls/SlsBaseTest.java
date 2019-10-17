package com.kaka.jtest.aliyun.sls;

import com.aliyun.openservices.log.Client;
import com.kaka.jtest.aliyun.common.constant.Constants;
import org.junit.Before;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 12:13
 */
public class SlsBaseTest {
	private final String accessId = Constants.ACCESS_ID;
	private final String accessKey = Constants.ACCESS_KEY;
	private final String endPoint = "cn-hangzhou.log.aliyuncs.com";
	/**
	 * 预发环境
	 */
	private final String innerEndPoint = "cn-shanghai-staging-share.sls.aliyuncs.com";

	protected Client client = null;

	protected String defaultProject = "sls-jsk-log";

	protected String defaultLogStore = "test-logstore1";
	@Before
	public void before() {
		client = new Client(innerEndPoint, accessId, accessKey);
	}
}
