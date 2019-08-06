package com.kaka.jtest.jdk.arithmetic.pointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/7/31 19:34
 */
public class PointerTest {

    @Test
    public void changePointer() {
        List<Object> listA = Arrays.asList("a001", "a002");
        List<Object> listB;
        // b指向A所指向的对象地址，而不是指向A引用
        listB = listA;

        listA = Arrays.asList("a003", "a004");
        System.out.println(listB);
        System.out.println(listA);
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'l', 'i', 'b', 'a', 'b', 'a'};
        swap(chars, 4);
        System.out.println(chars);
    }

    /**
     * 指定index，将index前后的char数组内容进行交换,要求空间复杂度是O(1)<br />
     * e.g.
     * <ul>
     * <li>char[] = 'a','l','i','b','a','b','a' index = 4, 返回 'b','a','a','l','i','b','a'</li>
     * <li>char[] = 'a','l','i','b','a','b','a' index = 2, 返回 'b','a','b','a','a','l','i'</li>
     * </ul>
     *
     * @param input
     * @param index
     * @return
     */
    public static void swap(char[] input, int index) {
        if (input == null) {
            return;
        }
        if (index > input.length || index < 0) {
            return;
        }

        // 保存index之前的数据
        char[] temp = new char[index + 1];
        for (int i = 0; i < input.length; i++) {
            if (i <= index) {
                temp[i] = input[i];
            }
            // 当右移到尽头时,后面的使用temp中的值
            if ((i + index + 1) >= input.length) {
                input[i] = temp[index + i + 1 - input.length];
            } else {
                input[i] = input[(i + index + 1) % input.length];
            }
        }
    }

    public static char[] swap1(char[] input, int index) {
        if (input == null) {
            return null;
        }
        if (index > input.length || index < 0) {
            return input;
        }
        char[] newArray = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            newArray[i] = input[(i + index + 1) % input.length];
        }
        return newArray;
    }
}
