package com.kaka.jtest.jdk.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
 * Pattern类只能做一些简单的匹配操作,要想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作.
 * Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
 *
 * @author jsk
 * @Date 2018/8/6 9:30
 */
public class MatcherTest {
    private Pattern p = Pattern.compile("abc+");
    private Pattern pattern1 = Pattern.compile("\\d+");


    /**
     * 该Matcher对象是由哪个Pattern对象的创建的
     */
    @Test
    public void patternTest() {
        Matcher m = pattern1.matcher("22bb23");
        System.out.println(m.pattern());
    }

    /**
     * Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
     * Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false
     * matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
     */
    @Test
    public void matchesTest() {
        Matcher m = pattern1.matcher("22bb23");
        //返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        System.out.println(m.matches());
        Matcher m2 = pattern1.matcher("2223");
        //返回true,因为\d+匹配到了整个字符串
        System.out.println(m2.matches());
    }

    /**
     * 对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
     */
    @Test
    public void lookingAtTest() {
        Matcher m = pattern1.matcher("22bb23");
        //返回true,因为\d+匹配到了前面的22
        System.out.println(m.lookingAt());
        Matcher m2 = pattern1.matcher("aa2223");
        //返回false,因为\d+不能匹配前面的aa
        System.out.println(m2.lookingAt());
    }

    /**
     * 对字符串进行匹配,匹配到的字符串可以在任何位置.
     */
    @Test
    public void findTest() {
        Matcher m = pattern1.matcher("22bb23");
        System.out.println(m.find());
        Matcher m2 = pattern1.matcher("aa2223");
        System.out.println(m2.find());
        Matcher m3 = pattern1.matcher("aa2223bb");
        System.out.println(m3.find());
        Matcher m4 = pattern1.matcher("aabb");
        System.out.println(m4.find());
    }

    /**
     * Mathcer.start()/ Matcher.end()/ Matcher.group()
     * 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.
     * 返回匹配到的子字符串在字符串中的索引位置.
     */
    @Test
    public void startTest() {
        Matcher m = pattern1.matcher("aaa2223bb");
        if(m.find()){
            System.out.println(m.start());
        }
    }

    /**
     * 返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
     */
    @Test
    public void endTest() {
        Matcher m = pattern1.matcher("aaa2223bb");
        if(m.find()){
            System.out.println(m.end());
        }
    }

    /**
     * 返回匹配到的子字符串
     */
    @Test
    public void group() {
        Matcher matcher = p.matcher("abcabcabcabccc");
        while (matcher.find()) {
            System.out.println(matcher.group() + ";\tstart:" + matcher.start() + ";\tend:" + matcher.end());
        }
    }

}
