package com.kaka.jtest.jdk.java.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-21 16:04
 */
public class BufferedReaderTest {
	private String filePath = "/Users/jiashuangkai/test_kafka/test.txt";

	/**
	 * echo 'first line' > test.txt  覆盖内容
	 * echo 'first line' >> test.txt  追加内容
	 * 注意使用vim不行，ready()方法返回的一直为false
	 * @throws Exception
	 */
	@Test
	public void readyTest() throws Exception {
		Reader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (true) {
			if(bufferedReader.ready()){
				System.out.println(bufferedReader.readLine());
			}else{
				TimeUnit.MILLISECONDS.sleep(200);
			}
		}
	}
}
