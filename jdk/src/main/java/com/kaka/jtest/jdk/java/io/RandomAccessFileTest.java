package com.kaka.jtest.jdk.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-21 16:16
 */
public class RandomAccessFileTest {

	private String filePath = "/Users/jiashuangkai/test_kafka/test.txt";

	@Test
	public void readLine() throws Exception {
		RandomAccessFile randomFile = new RandomAccessFile(filePath, "r");
		while (true) {
			String tmp;
			if((tmp = randomFile.readLine()) !=null){
				System.out.println( tmp);
			}else{
				TimeUnit.SECONDS.sleep(1);
			}
		}
	}
}
