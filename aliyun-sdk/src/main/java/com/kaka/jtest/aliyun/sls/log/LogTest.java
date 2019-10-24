package com.kaka.jtest.aliyun.sls.log;

import com.aliyun.openservices.log.common.*;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.request.GetHistogramsRequest;
import com.aliyun.openservices.log.request.GetLogsRequest;
import com.aliyun.openservices.log.request.PutLogsRequest;
import com.aliyun.openservices.log.response.*;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 14:29
 */
public class LogTest extends SlsBaseTest {
	String project = "sls-jsk-log";
	String logstore = "test-log";

	/**
	 * 1. 写入日志
	 *
	 * @throws LogException
	 */
	@Test
	public void putLog() throws LogException {
		// 写入日志
		String topic = "";
		String source = "";
		// 连续发送 10 个数据包，每个数据包有 10 条日志
		for (int i = 0; i < 10; i++) {
			List<LogItem> logGroup = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				LogItem logItem = new LogItem((int) (System.currentTimeMillis() / 1000));
				logItem.PushBack("index" + j, String.valueOf(i * 10 + j));
				logItem.PushBack("key", "value001");
				logItem.PushBack("__time__", "1571792736");
				logItem.PushBack("key3", "value003");
				logItem.SetTime(1570673410);
				logGroup.add(logItem);
			}
			PutLogsRequest req2 = new PutLogsRequest(project, logstore, topic, source, logGroup);
			client.PutLogs(req2);
		}
	}

	@Test
	public void putOneLog() throws LogException {
		// 写入日志
		String topic = "";
		String source = "";
		List<LogItem> logGroup = new ArrayList<>();
		// 构造函数的时间，优先级最低
		LogItem logItem = new LogItem((int) (System.currentTimeMillis() / 1000));
		logItem.PushBack("key", "jsk_test_time1");
		// 优先级最高
//        logItem.SetTime(1570673411);
        // 第二优先级
        logItem.PushBack("__time__", "1571792736");
		logGroup.add(logItem);
		PutLogsRequest req2 = new PutLogsRequest(project, logstore, topic, source, logGroup);
        PutLogsResponse putLogsResponse = client.PutLogs(req2);
        System.out.println(putLogsResponse.GetAllHeaders());
    }

	/**
	 * 根据游标查询日志
	 */
	@Test
	public void listLogByCursor() throws LogException {
		// 把 0 号 shard 中，最近 1 分钟写入的数据都读取出来。
		int shardId = 0;
		long curTimeInSec = System.currentTimeMillis() / 1000;
		GetCursorResponse cursorRes = client.GetCursor(project, logstore, shardId, curTimeInSec - 60);
		String beginCursor = cursorRes.GetCursor();
		cursorRes = client.GetCursor(project, logstore, shardId, Consts.CursorMode.END);
		String endCursor = cursorRes.GetCursor();
		String curCursor = beginCursor;
		while (!curCursor.equals(endCursor)) {
			// 每次读取两个 loggroup
			int logGroupCount = 2;
			BatchGetLogResponse logDataRes = client.BatchGetLog(project, logstore, shardId,
					logGroupCount, curCursor, endCursor);
			// 读取LogGroup的List
			List<LogGroupData> logGroups = logDataRes.GetLogGroups();
			for (LogGroupData logGroup : logGroups) {
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
			System.out.println("The Next cursor:" + next_cursor);
			curCursor = next_cursor;
		}
	}

	@Test
	public void histogramsTest() throws Exception {
		String topic = "";
		// 查询日志分布情况
		String query = "key";
		int from = (int) (System.currentTimeMillis() / 1000 - 300);
		int to = (int) (System.currentTimeMillis() / 1000);
		GetHistogramsResponse res3 = null;
		while (true) {
			GetHistogramsRequest req3 = new GetHistogramsRequest(project, logstore, topic, query, from, to);
			res3 = client.GetHistograms(req3);
			/**
			 * IsCompleted() 返回true，表示查询结果是准确的，如果返回false，则重复查询
			 */
			if (res3 != null && res3.IsCompleted()) {
				break;
			}
			Thread.sleep(200);
		}
		System.out.println("Total count of logs is " + res3.GetTotalCount());
		for (Histogram ht : res3.GetHistograms()) {
			System.out.printf("from %d, to %d, count %d.\n", ht.GetFrom(), ht.GetTo(), ht.GetCount());
		}
	}

	/**
	 * 查询指定时间段日志内容
	 *
	 * @throws Exception
	 */
	@Test
	public void listLogByTime() throws Exception {
		String topic = "";
		// 查询日志分布情况
		String query = "key";
		int from = (int) (System.currentTimeMillis() / 1000 - 500);
		int to = (int) (System.currentTimeMillis() / 1000);

		// 查询日志数据
		long total_log_lines = 500;
		int log_offset = 0;
		int log_line = 10;//log_line 最大值为100，每次获取100行数据。若需要读取更多数据，请使用offset翻页。offset和lines只对关键字查询有效，若使用SQL查询，则无效。在SQL查询中返回更多数据，请使用limit语法。
		while (log_offset <= total_log_lines) {
			GetLogsResponse res4 = null;
			// 对于每个 log offset,一次读取 10 行 log，如果读取失败，最多重复读取 3 次。
			for (int retry_time = 0; retry_time < 3; retry_time++) {
				GetLogsRequest req4 = new GetLogsRequest(project, logstore, from, to, topic, query, log_offset,
						log_line, false);
				res4 = client.GetLogs(req4);
				if (res4 != null && res4.IsCompleted()) {
					break;
				}
				Thread.sleep(200);
			}
			System.out.println("Read log count:" + String.valueOf(res4.GetCount()));
			log_offset += log_line;
		}
	}

	@Test
	public void listLogBySql() throws LogException {
		int from = (int) (System.currentTimeMillis() / 1000 - 500);
		int to = (int) (System.currentTimeMillis() / 1000);
		//使用分析功能
		GetLogsRequest req4 = new GetLogsRequest(project, logstore, from, to, "", " index0:value | select avg(index1) as v1,sum(index2) as v2, index0 group by index0");
		GetLogsResponse res4 = client.GetLogs(req4);
		if (res4 != null && res4.IsCompleted()) {
			for (QueriedLog log : res4.GetLogs()) {
				LogItem item = log.GetLogItem();
				for (LogContent content : item.GetLogContents()) {
					System.out.print(content.GetKey() + ":" + content.GetValue());
				}
				System.out.println();
			}
		}
	}
}
