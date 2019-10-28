package com.kaka.jtest.aliyun.mq;

import com.aliyun.mq.http.MQClient;
import com.kaka.jtest.aliyun.BaseTest;
import com.kaka.jtest.aliyun.common.constant.Constants;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-25 16:17
 */
public class MqBaseTest extends BaseTest {
	protected static MQClient mqClient = new MQClient(
			Constants.MQ_ENDPOINT != null ? Constants.MQ_ENDPOINT : "",
			ACCESS_KEY_ID,
			ACCESS_KEY_SECRET);

	protected static String topic = "jsk-topic";
}
