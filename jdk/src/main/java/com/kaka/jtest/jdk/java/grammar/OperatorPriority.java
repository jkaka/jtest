package com.kaka.jtest.jdk.java.grammar;

import org.junit.Test;

/**
 * 运算符优先级
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-28 11:01
 */
public class OperatorPriority {

	/**
	 * 强转符号的优先级高于除号
	 */
	@Test
	public void casts() {
		long a = 10000000000L;
		int num = (int) a / 1000;
		System.out.println("先强转后除法:" + num);
		num = (int) (a / 1000);
		System.out.println(num);
	}
}
