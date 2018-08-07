package com.kaka.jtest.jdk.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jsk
 * @Date 2018/8/6 9:30
 */
public class MatcherTest {
    private Pattern p = Pattern.compile("abc+");

    @Test
    public void group() {
        Matcher matcher = p.matcher("abcabcabcabccc");
        while (matcher.find()) {
            System.out.println(matcher.group() + ";\tstart:" + matcher.start() + ";\tend:" + matcher.end());
        }
    }

}
