package com.kaka.jtest.jdk.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jsk
 * @Date 2018/8/6 9:18
 */
public class PatternTest {
    private Pattern p = Pattern.compile("abc+");

    @Test
    public void compile() {
        Matcher matcher = p.matcher("abcabcabcabccc");
        System.out.println(matcher.find());
    }
}
