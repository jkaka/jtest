package com.kaka.jtest.aliyun.sls.ingestion;

import com.aliyun.openservices.log.common.*;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.request.CreateIngestionRequest;
import com.aliyun.openservices.log.request.GetIngestionRequest;
import com.aliyun.openservices.log.request.ListIngestionRequest;
import com.aliyun.openservices.log.response.CreateIngestionResponse;
import com.aliyun.openservices.log.response.GetIngestionResponse;
import com.aliyun.openservices.log.response.ListIngestionResponse;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.util.Date;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-22 17:29
 */
public class IngestionTest extends SlsBaseTest {
	private String project = "sls-jsk-log";

	@Test
	public void createIngestion() throws LogException {
		CreateIngestionResponse ingestion = cdClient.createIngestion(new CreateIngestionRequest(project, createOssIngestion()));
		System.out.println(ingestion.GetAllHeaders());
	}

	@Test
	public void listIngestion() throws LogException {
		ListIngestionRequest listIngestionRequest = new ListIngestionRequest(defaultProject);
//		listIngestionRequest.setLogstore("test-oss-logstore");
//		listIngestionRequest.setName("ingestion-jsk");
		ListIngestionResponse listIngestionResponse = client.listIngestion(listIngestionRequest);
		System.out.println(listIngestionResponse.getResults());
	}

	@Test
	public void getIngestion() throws LogException {
		GetIngestionRequest getIngestionRequest = new GetIngestionRequest(project, "ingestion-jsk");
		GetIngestionResponse ingestion = cdClient.getIngestion(getIngestionRequest);
		System.out.println(ingestion.getIngestion());
	}

	private Ingestion createOssIngestion() {
		Ingestion ingestion = new Ingestion();
		String jobName = "ingestion-jsk";
		ingestion.setName(jobName);
		ingestion.setDisplayName("OSS-test");
		IngestionConfiguration configuration = new IngestionConfiguration();
		configuration.setLogstore("test-oss-logstore");
		AliyunOSSSource source = new AliyunOSSSource();
		source.setBucket("yunlei-bill");
		source.setEncoding("UTF-8");
		source.setEndpoint("oss-cn-beijing.aliyuncs.com");
		source.setRoleARN(ossRoleArn);
		DelimitedTextFormat format = new DelimitedTextFormat();
		format.setEscapeChar("\\");
		format.setFirstRowAsHeader(true);
		format.setSkipLeadingRows(0);
		format.setQuoteChar("\"");
		format.setFieldDelimiter(",");
		source.setFormat(format);
		configuration.setSource(source);
		ingestion.setConfiguration(configuration);
		JobSchedule schedule = new JobSchedule();
		schedule.setInterval("1h");
		schedule.setType(JobScheduleType.FIXED_RATE);
		ingestion.setSchedule(schedule);
		return ingestion;
	}
}
