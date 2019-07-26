package com.kaka.jtest.jdk.java.util.regex;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,
 * 但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式,
 *
 * @author jsk
 * @Date 2018/8/6 9:18
 */
public class PatternTest {
    /**
     * 编译一个模式实例
     */
    private Pattern p = Pattern.compile("abc+");
    private Pattern pattern2 = Pattern.compile("\\d+");


    @Test
    public void compile() {
        // 使用模式创建Matcher对象
        Matcher matcher = p.matcher("abcabcabcabccc");
        System.out.println(matcher.find());
    }

    @Test
    public void oneMatcher() {
        System.out.println(Pattern.matches("a*b", "aaaaab"));
    }


    private Pattern pattern1 = Pattern.compile("\\w+");

    /**
     * 正则表达式的字符串形式
     */
    @Test
    public void patternTest() {
        System.out.println(pattern1.pattern());
    }


    private Pattern compile = Pattern.compile("\\d+");

    /**
     * 分隔字符串
     */
    @Test
    public void splitTest() {
        String[] str = compile.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        System.out.println(Arrays.asList(str));
    }

    /**
     * 快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
     */
    @Test
    public void matchesTest() {
        //返回true
        System.out.println(Pattern.matches("\\d+","2223"));
        //返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
        System.out.println(Pattern.matches("\\d+","2223aa"));
        //返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
        System.out.println(Pattern.matches("\\d+","22bb23"));
    }

    @Test
    public void matcherTest(){
        Matcher m=pattern2.matcher("22bb23");
        //返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的
        System.out.println(m.pattern());
    }
}
