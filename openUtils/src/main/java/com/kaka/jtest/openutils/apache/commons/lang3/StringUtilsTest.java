package com.kaka.jtest.openutils.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-23 12:09
 */
public class StringUtilsTest {

	/**
	 * 判断是否有内容(空格、换行，都不是内容;常用)
	 */
	@Test
	public void isNotBlank() {
		System.out.println(StringUtils.isNotBlank(null));
		System.out.println(StringUtils.isNotBlank(""));
		System.out.println(StringUtils.isNotBlank(" "));
		System.out.println(StringUtils.isNotBlank("/t /n /f /r"));
		System.out.println(StringUtils.isNotBlank("/b"));
		System.out.println(StringUtils.isNotBlank("bob"));
		System.out.println(StringUtils.isNotBlank(" bob "));
	}

	/**
	 * 判断是否为空字符(空格不属于空字符)
	 */
	@Test
	public void isNotEmpty() {
		System.out.println(StringUtils.isNotEmpty(null));
		System.out.println(StringUtils.isNotEmpty(""));
		System.out.println(StringUtils.isNotEmpty(" "));
		System.out.println(StringUtils.isNotEmpty("bob"));
		System.out.println(StringUtils.isNotEmpty(" bob "));
	}

	@Test
	public void isNoneBlank(){
		System.out.println(StringUtils.isNotBlank(""));
	}
}
