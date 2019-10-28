package com.kaka.jtest.jdk.java.util.regex;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,
 * 但可以通过Pattern.compile(String regex)简单工厂方法创建一个正则表达式
 *
 * @author jsk
 * @date 2018/8/6 9:18
 */
public class PatternTest {
	/**
	 * 初始化一个模式实例
	 */
	private Pattern pattern = Pattern.compile("\\d+");
	private Pattern pattern1 = Pattern.compile("\\w+");

	/**
	 * 输出正则表达式的字符串形式
	 */
	@Test
	public void patternTest() {
		System.out.println(pattern1.pattern());
	}


	/**
	 * 使用正则表达式，分隔字符串
	 */
	@Test
	public void splitTest() {
		String[] str = pattern.split("我的QQ是:123465我的电话是:111222333我的邮箱是:aaa@aaa.com");
		System.out.println(Arrays.asList(str));
	}

	/**
	 * 快速匹配字符串,该方法适合用于只匹配一次
	 */
	@Test
	public void matches() {
        /**
         * 限定符
         * + 号代表前面的字符必须至少出现一次（1次或多次）。
         * * 号代表前面的字符可以不出现，也可以出现一次或者多次（0次、或1次、或多次）。
         * ? 号代表前面的字符最多只可以出现一次（0次、或1次）。
         * {n}	n 是一个非负整数。匹配确定的 n 次。例如，'o{2}' 不能匹配 "Bob" 中的 'o'，但是能匹配 "food" 中的两个 o。
         * {n,}	n 是一个非负整数。至少匹配n 次。例如，'o{2,}' 不能匹配 "Bob" 中的 'o'，但能匹配 "foooood" 中的所有 o。'o{1,}' 等价于 'o+'。'o{0,}' 则等价于 'o*'。
         * {n,m}	m 和 n 均为非负整数，其中n <= m。最少匹配 n 次且最多匹配 m 次。例如，"o{1,3}" 将匹配 "fooooood" 中的前三个 o。'o{0,1}' 等价于 'o?'。请注意在逗号和两个数之间不能有空格。
         */
        System.out.println(Pattern.matches("runoo+b", "runoooooob"));
		System.out.println(Pattern.matches("jska{2,}", "jskaa"));

        /**
         * 定位符
         * ^	匹配输入字符串开始的位置。如果设置了 RegExp 对象的 Multiline 属性，^ 还会与 \n 或 \r 之后的位置匹配。
         * $	匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与 \n 或 \r 之前的位置匹配。
         * \b	匹配一个单词边界，即字与空格间的位置。
         * \B	非单词边界匹配。
         */
        // 以jsk开头,后面跟着0或多个k字符
        System.out.println(Pattern.matches("^jsk*", "jskkkkk"));

        // [xyz]：字符集合。匹配所包含的任意一个字符。例如，“[abc]”可以匹配“plain”中的“a”。
		System.out.println(Pattern.matches("ar[abc]k", "arck"));
        // [^xyz]：负值字符集合。匹配未包含的任意字符。例如，“[^abc]”可以匹配“plain”中的“plin”任一字符。
		System.out.println(Pattern.matches("ar[^abc]k", "arvk"));
        // [a-z]：字符范围。匹配指定范围内的任意字符。例如，“[a-z]”可以匹配“a”到“z”范围内的任意小写字母字符。
        // [^a-z]：负值字符范围。匹配任何不在指定范围内的任意字符。例如，“[^a-z]”可以匹配任何不在“a”到“z”范围内的任意字符。
        // \d：匹配一个数字字符。等价于[0-9]。grep 要加上-P，perl正则支持
        // \D：匹配一个非数字字符。等价于[^0-9]。grep要加上-P，perl正则支持
        // \w：匹配包括下划线的任何单词字符。类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集。
        // \W：匹配任何非单词字符。等价于“[^A-Za-z0-9_]”。   不包含.
		// (pattern)：匹配pattern并获取这一匹配。

		// ([^swc][ .])Get(\w*)[^;]$
		// $1get$2
    }
}
