package com.kaka.jtest.idea;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-25 12:29
 */
public class ReplaceTest {

	@Test
	public void replace() {

	}

	/**
	 * 正则替换
	 * 把SetXxx()替换为setXxx()：Set(\w.*)-->set$1
	 */
	public void setString() {
		Set<String> stringSet = new HashSet<>();
		System.out.println(stringSet);
	}
}
