package com.kaka.jtest.aliyun.sls.logstore;

import com.aliyun.openservices.log.common.LogStore;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.request.ListLogStoresRequest;
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
		String project = "project-intg-1571214601";
		String logStoreSubName = "";
		ListLogStoresRequest req1 = new ListLogStoresRequest(defaultProject, 0, 10, logStoreSubName);
		ArrayList<String> logStores = client.ListLogStores(req1).GetLogStores();
		System.out.println("ListLogs:" + logStores.toString() + "\n");
	}

	/**
	 * 1.日志库名称仅支持小写字母、数字、连字符（-）和下划线（_）
	 * 2.必须以小写字母和数字开头和结尾
	 * 3.名称长度为3-63个字符
	 *
	 * @throws LogException
	 */
	@Test
	public void createLogStore() throws LogException {
		LogStore logStore = new LogStore();
		logStore.SetLogStoreName(defaultLogStore);
		logStore.SetShardCount(1);
		logStore.SetTtl(10);
		client.CreateLogStore("project-intg-1571214601", logStore);
	}
}
