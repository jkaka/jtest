package com.kaka.jtest.jdk.arithmetic.interview;

import java.util.Arrays;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-20 19:19
 */
public class Test {

    public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
       int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum equal" + target);
    }
}
