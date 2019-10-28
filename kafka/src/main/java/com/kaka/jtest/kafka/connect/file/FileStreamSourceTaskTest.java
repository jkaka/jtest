package com.kaka.jtest.kafka.connect.file;

import org.apache.kafka.connect.file.FileStreamSourceConnector;
import org.apache.kafka.connect.file.FileStreamSourceTask;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTaskContext;
import org.apache.kafka.connect.storage.OffsetStorageReader;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-21 11:25
 */
public class FileStreamSourceTaskTest {

	private String filePath = "/Users/jiashuangkai/test_kafka/test.txt";

	@Test
	public void pollTest() throws Exception {
		FileStreamSourceTask task = new FileStreamSourceTask();
		Map<String, String> config = new HashMap<>(16);
		config.put(FileStreamSourceConnector.FILE_CONFIG, filePath);
		config.put(FileStreamSourceConnector.TOPIC_CONFIG, "test-topic");
		config.put(FileStreamSourceConnector.TASK_BATCH_SIZE_CONFIG, String.valueOf(FileStreamSourceConnector.DEFAULT_TASK_BATCH_SIZE));
		SourceTaskContext context = new SourceTaskContext() {
			@Override
			public OffsetStorageReader offsetStorageReader() {
				return new OffsetStorageReader() {
					@Override
					public <T> Map<String, Object> offset(Map<String, T> partition) {
						return null;
					}

					@Override
					public <T> Map<Map<String, T>, Map<String, Object>> offsets(Collection<Map<String, T>> partitions) {
						return null;
					}
				};
			}
		};
		task.initialize(context);

		task.start(config);
		List<SourceRecord> poll;
		OutputStream os = Files.newOutputStream(Paths.get(filePath));
		int i = 0;
		while (true) {
			poll = task.poll();
			if (poll == null) {
				os.write((i++ + " finished\n").getBytes());
				os.flush();
				continue;
			}
			for (SourceRecord sourceRecord : poll) {
				System.out.println(sourceRecord.value());
			}
			TimeUnit.SECONDS.sleep(1);
		}
	}

	@Test
	public void writeFile() throws IOException {
		OutputStream os = Files.newOutputStream(Paths.get(filePath));
		os.write(" finished\n".getBytes());
		os.flush();
	}
}
