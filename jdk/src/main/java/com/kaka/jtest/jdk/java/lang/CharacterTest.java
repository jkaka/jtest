package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/8/14 14:21
 */
public class CharacterTest {
    @Test
    public void isLetterTest(){
        System.out.println(Character.isLetter('5'));
        System.out.println(Character.isLetter('A'));
    }
}
