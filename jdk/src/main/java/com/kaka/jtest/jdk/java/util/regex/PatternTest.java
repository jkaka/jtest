package com.kaka.jtest.jdk.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jsk
 * @Date 2018/8/6 9:18
 */
public class PatternTest {
    /**
     * 编译一个模式实例
     */
    private Pattern p = Pattern.compile("abc+");

    @Test
    public void compile() {
        // 使用模式创建Matcher对象
        Matcher matcher = p.matcher("abcabcabcabccc");
        System.out.println(matcher.find());
    }

    @Test
    public void oneMatcher(){
        System.out.println(Pattern.matches("a*b", "aaaaab"));
    }
}
