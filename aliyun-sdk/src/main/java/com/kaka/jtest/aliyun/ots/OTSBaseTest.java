package com.kaka.jtest.aliyun.ots;

import com.alicloud.openservices.tablestore.ClientConfiguration;
import com.alicloud.openservices.tablestore.SyncClient;
import com.alicloud.openservices.tablestore.model.AlwaysRetryStrategy;
import com.kaka.common.utils.PropertiesUtil;
import org.junit.Before;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-06 09:55
 */
public class OTSBaseTest {
    private static final String OTS_ACCESS_KEY_ID = PropertiesUtil.getLocalProperty("ots.accessKeyId", "");
    private static final String OTS_ACCESS_KEY_SECRET = PropertiesUtil.getLocalProperty("ots.accessKeySecret", "");
    protected SyncClient client;

    @Before
    public void initClient() {
        final String endPoint = "https://data-ingestion.cn-hangzhou.ots.aliyuncs.com";
        final String instanceName = "data-ingestion";
        // ClientConfiguration提供了很多配置项，以下只列举部分。
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        // 设置建立连接的超时时间。
        clientConfiguration.setConnectionTimeoutInMillisecond(5000);
        // 设置socket超时时间。
        clientConfiguration.setSocketTimeoutInMillisecond(5000);
        // 设置重试策略，若不设置，采用默认的重试策略。
        clientConfiguration.setRetryStrategy(new AlwaysRetryStrategy());
        client = new SyncClient(endPoint, OTS_ACCESS_KEY_ID, OTS_ACCESS_KEY_SECRET, instanceName, clientConfiguration);
    }
}
