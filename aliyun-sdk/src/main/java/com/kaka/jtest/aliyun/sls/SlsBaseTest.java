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
	/**
	 * 正式环境
	 */
	private final String endPoint = "cn-hangzhou.log.aliyuncs.com";
	private final String cdEndPoint = "cn-chengdu.log.aliyuncs.com";
	/**
	 * 预发环境
	 */
	private final String innerEndPoint = "cn-shanghai-staging-share.sls.aliyuncs.com";


	private final String accessId = Constants.ACCESS_ID;
	private final String accessKey = Constants.ACCESS_KEY;
	protected final String ossRoleArn = Constants.OSS_ROLE_ARN;
	protected final String bssRoleArn = Constants.BSS_ROLE_ARN;
	protected String defaultProject = "sls-jsk-log";
	protected String defaultLogStore = "test-logstore1";

	protected Client client = null;
	protected Client cdClient = null;
	protected Client innerClient = null;

	@Before
	public void before() {
		client = new Client(endPoint, accessId, accessKey);
		cdClient = new Client(cdEndPoint, accessId, accessKey);
		innerClient = new Client(innerEndPoint, accessId, accessKey);
	}
}
