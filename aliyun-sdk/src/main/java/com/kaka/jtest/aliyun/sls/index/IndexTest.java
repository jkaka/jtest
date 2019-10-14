package com.kaka.jtest.aliyun.sls.index;

import com.aliyun.openservices.log.common.Index;
import com.aliyun.openservices.log.common.IndexKey;
import com.aliyun.openservices.log.common.IndexKeys;
import com.aliyun.openservices.log.common.IndexLine;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.request.CreateIndexRequest;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 14:52
 */
public class IndexTest extends SlsBaseTest {
    String project = "sls-jsk-log";
    String logstore = "test-bss";

    @Test
    public void createIndex() throws LogException {
        //打开分析功能,只有打开分析功能，才能使用SQL 功能。 可以在控制台开通分析功能，也可以使用SDK开启分析功能
        IndexKeys indexKeys = new IndexKeys();
        ArrayList<String> tokens = new ArrayList<String>();
        tokens.add(",");
        tokens.add(".");
        tokens.add("#");
        IndexKey keyContent = new IndexKey(tokens, false, "text");
        indexKeys.AddKey("index0", keyContent);
        keyContent = new IndexKey(new ArrayList<String>(), false, "long");
        indexKeys.AddKey("index1", keyContent);
        keyContent = new IndexKey(new ArrayList<String>(), false, "double");
        indexKeys.AddKey("index2", keyContent);
        IndexLine indexLine = new IndexLine(new ArrayList<String>(), false);
        Index index = new Index(7, indexKeys, indexLine);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(project, logstore, index);
        client.CreateIndex(createIndexRequest);
    }
}
