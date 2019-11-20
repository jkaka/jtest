package com.kaka.jtest.jdk.arithmetic.interview;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-19 17:56
 */
public class ArrayRepetition {

    /**
     * 假设int数组长度为n，其中数组中的每个值都小于n；
     * 判断这个数组中的值是否有重复，要求空间复杂度小于O(n)，时间复杂度小于等于O(n)
     * 如：
     * [0,2,1]  不重复
     * [0,0,1,3]  重复
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 0, 4, 0};
        int k = array.length;
        int index;
        for (int i = 0; i < k; i++) {
            if (array[i] >= k) {
                index = array[i] - k;
            } else {
                index = array[i];
            }
            array[index] += k;
            if (array[index] >= 2 * k) {
                System.out.println("重复的数据为:" + index);
                break;
            }
        }
    }

    @Test
    public void replete() {
        int[] array = {1, 2, 0, 2, 4};
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[array[i]] == array[i]) {
                    System.out.println("重复的数据为:" + array[i]);
                    break;
                }
                int temp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = temp;
            }
        }
    }
}
