package com.kaka.jtest.aliyun.sls.cursor;

import com.aliyun.openservices.log.response.GetCursorResponse;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 14:58
 */
public class CursorTest extends SlsBaseTest {
    String project = "sls-jsk-log";
    String logStore = "test-bss";

    /**
     * 得到游标
     * @throws Exception
     */
    @Test
    public void getCursor() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long fromTime = dateFormat.parse("2018-06-07 15:33:01").getTime();
        // 1528356782
        System.out.println(fromTime);
        GetCursorResponse cursorResponse = client.GetCursor(project, logStore, 0, fromTime / 1000L);
        System.out.println(cursorResponse.GetCursor());
    }
}
