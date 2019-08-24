package com.kaka.jtest.jdk.arithmetic.interview;

import java.util.Arrays;

/**
 * @author: jsk
 * @date: 2019/8/24 14:42
 */
public class MergeArray {

    //评测题目: 实现一个函数，入参是两个int类型有序数组，返回是一个有序数组。
//例如，入参数组[1,3,5,7]和[2,4,6,8]，返回[1,2,3,4,5,6,7,8]
// 要求：不要使用java的三方库方法

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        int[] wrap = wrap(a, b);
        System.out.println(Arrays.asList(wrap));
    }


    public static int[] wrap(int[] a, int[] b) {
        int count = a.length + b.length;
        int[] success = new int[count];

        int indexA = 0;
        int indexB = 0;
        int temp = 0;

        for (int i = 0; i < count; i++) {
            if(indexA == a.length){
                temp = b[indexB];
                indexB ++;
            }else if(indexB == b.length){
                temp = a[indexA];
                indexA ++;
            }else{
                if(a[indexA] < b[indexB]){
                    temp = a[indexA];
                    indexA ++;
                }else {
                    temp = b[indexB];
                    indexB ++;
                }
            }
            success[i] = temp;
        }
        return success;
    }
}
