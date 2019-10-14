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
    private final String intranetEndPoint = "cn-hangzhou-intranet.log.aliyuncs.com";

    protected Client client = null;

    @Before
    public void before() {
        client = new Client(endPoint, accessId, accessKey);
    }
}
