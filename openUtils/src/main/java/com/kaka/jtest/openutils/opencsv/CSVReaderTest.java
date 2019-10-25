package com.kaka.jtest.openutils.opencsv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-24 09:35
 */
public class CSVReaderTest {

	@Test
	public void read() throws Exception {
//		String filePath = "src/main/resources/csv/test.csv";
		String filePath = "/Users/jiashuangkai/Downloads/CTS工单明细数据_1015to1021的副本.csv";
		InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath));
		CSVParser parser = new CSVParserBuilder()
				.withQuoteChar('\"')
				// 设置分隔符
				.withSeparator(',')
				// 忽略引用模式
				// 如果某个值中有特殊字符，如逗号、回车，则需要使用引用符号(如双引号)来引用这个值；此时不能忽略引用模式，设置值为false即可
				.withIgnoreQuotations(false)
				.build();

		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withCSVParser(parser)
				.withSkipLines(0)
				// 设置多行记录中允许的最大行数。
				// 在一条记录中超过这个数字将导致IOException。
				.withMultilineLimit(50)
				.withKeepCarriageReturn(false)
				.build();
		String[] strs;
		while ((strs = csvReader.readNext()) != null) {
			for (String str : strs) {
				System.out.printf("%s  ", str);
			}
			System.out.println("\n-----------------------------");
		}
	}
}
