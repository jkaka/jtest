package com.kaka.jtest.aliyun.log;

import com.aliyun.openservices.log.Client;
import com.aliyun.openservices.log.common.*;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.request.BatchGetLogRequest;
import com.aliyun.openservices.log.request.GetLogsRequest;
import com.aliyun.openservices.log.response.BatchGetLogResponse;
import com.aliyun.openservices.log.response.GetCursorResponse;
import com.aliyun.openservices.log.response.GetHistogramsResponse;
import com.aliyun.openservices.log.response.GetLogsResponse;
import javafx.scene.input.DataFormat;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class App {

    static private String endPoint = "";
    static private String accessKeyId = "";
    static private String accessKeySecret = "";
    static private String project = "";
    static private String logStore = "";
    static private Client client = null;

    private int fromTime = (int) (System.currentTimeMillis() / 1000 - 15 * 60);
    private int toTime = (int) (System.currentTimeMillis() / 1000);
    private String topic = "";
    private String query = "";
    private Integer minute = 15;

    @Before
    public void before() throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/aliyun.log.properties");
        Properties properties = new Properties();
        properties.load(is);
        endPoint = properties.getProperty("endPoint");
        accessKeyId = properties.getProperty("accessKeyId");
        accessKeySecret = properties.getProperty("accessKeySecret");
        project = properties.getProperty("project");
        logStore = properties.getProperty("logStore");

        client = new Client(endPoint, accessKeyId, accessKeySecret);
    }

    /**
     * 每个时间段，日志个数(不包含日志内容)
     *
     * @throws Exception
     */
    @Test
    public void testGetHistograms() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fromTime = (int) (dateFormat.parse("2018-05-14 17:24:50").getTime() / 1000);
        toTime = (int) (dateFormat.parse("2018-05-14 17:24:59").getTime() / 1000);
        GetHistogramsResponse res = client.GetHistograms(project, logStore, this.fromTime, this.toTime, topic, "");
        System.out.println("日志总记录数为：" + res.GetTotalCount());
        ArrayList<Histogram> histograms = res.GetHistograms();
        int total = 0;
        for (Histogram histogram : histograms) {
            total += histogram.GetCount();
        }
        System.out.println("日志总记录数为：" + total);
    }

    /**
     * 查询指定时间段日志内容
     * @throws Exception
     */
    @Test
    public void GetLogs() throws Exception {
        Integer currentPage = 1;
        Integer pageSize = 20;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fromTime = (int) (dateFormat.parse("2018-05-14 17:24:50").getTime() / 1000);
        toTime = (int) (dateFormat.parse("2018-05-14 17:24:59").getTime() / 1000);
        int log_offset = (currentPage - 1) * pageSize;
        int log_line = pageSize;

        GetLogsResponse logsResponse = null;
        // 对于每个 log offset,一次读取 log_line 行 log，如果读取失败，最多重复读取 3 次。
        for (int retry_time = 0; retry_time < 3; retry_time++) {
            GetLogsRequest req4 = new GetLogsRequest(project, logStore, fromTime, toTime, topic, query, log_offset,
                    log_line, false);
            logsResponse = client.GetLogs(req4);
            if (logsResponse != null && logsResponse.IsCompleted()) {
                break;
            }
            Thread.sleep(200);
        }
        List<QueriedLog> queriedLogs = logsResponse.GetLogs();

        for (QueriedLog queriedLog : queriedLogs) {
            for (LogContent logContent : queriedLog.mLogItem.GetLogContents()) {
                System.out.println("key=" + logContent.GetKey() + ";value=" + logContent.GetValue());
            }
        }
    }

    /**
     * 根据游标查询日志
     */
    @Test
    public void BatchGetLog() throws Exception {
        logStore = "tsp-admin-ota-info";
        String cursor = "MTUyNzEwMTYwOTQ0NjE5NjA2Mw==";
        BatchGetLogRequest batchGetLogRequest = new BatchGetLogRequest(project, logStore, 0, 3, cursor);
        BatchGetLogResponse logDataRes = client.BatchGetLog(batchGetLogRequest);
        System.out.println(logDataRes.GetRawSize());
        // 读取LogGroup的List
        List<LogGroupData> logGroups = logDataRes.GetLogGroups();
        for(LogGroupData logGroup: logGroups){
            FastLogGroup flg = logGroup.GetFastLogGroup();
            System.out.println(String.format("\tcategory\t:\t%s\n\tsource\t:\t%s\n\ttopic\t:\t%s\n\tmachineUUID\t:\t%s",
                    flg.getCategory(), flg.getSource(), flg.getTopic(), flg.getMachineUUID()));
            System.out.println("Tags");
            for (int tagIdx = 0; tagIdx < flg.getLogTagsCount(); ++tagIdx) {
                FastLogTag logtag = flg.getLogTags(tagIdx);
                System.out.println(String.format("\t%s\t:\t%s", logtag.getKey(), logtag.getValue()));
            }
            for (int lIdx = 0; lIdx < flg.getLogsCount(); ++lIdx) {
                FastLog log = flg.getLogs(lIdx);
                System.out.println("--------\nLog: " + lIdx + ", time: " + log.getTime() + ", GetContentCount: " + log.getContentsCount());
                for (int cIdx = 0; cIdx < log.getContentsCount(); ++cIdx) {
                    FastLogContent content = log.getContents(cIdx);
                    System.out.println(content.getKey() + "\t:\t" + content.getValue());
                }
            }
        }
        String next_cursor = logDataRes.GetNextCursor();
        System.out.println(next_cursor);
    }

    /**
     * 得到游标
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long fromTime = dateFormat.parse("2018-06-07 15:33:01").getTime();
        // 1528356782
        System.out.println(fromTime);
        logStore = "tsp-admin-ota-info";
        GetCursorResponse cursorResponse = client.GetCursor(project, logStore, 0, fromTime / 1000L);
        System.out.println(cursorResponse.GetCursor());
    }
}

