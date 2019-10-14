package com.kaka.jtest.aliyun.sls.logstore;

import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.request.ListLogStoresRequest;
import com.aliyun.openservices.log.response.ListProjectResponse;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 12:17
 */
public class LogStoreTest extends SlsBaseTest {

    @Test
    public void listLogStore() throws LogException {
        String project = "sls-jsk-log";
        String logStoreSubName = "";
        ListLogStoresRequest req1 = new ListLogStoresRequest(project, 0, 10, logStoreSubName);
        ArrayList<String> logStores = client.ListLogStores(req1).GetLogStores();
        System.out.println("ListLogs:" + logStores.toString() + "\n");
    }
}
