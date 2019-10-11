package com.kaka.jtest.jdk.arithmetic.interview;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一个整型数组中，差值为n的组合
 * 比如: [1,2,3,4,5,3] 差值1 组合有[1,2] [2,3] [3,4] [4,5]
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-10 21:28
 */
public class CombinationTest {
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5, 3};
        int diff = 2;
        System.out.println(countPair(num, diff));
    }

    private static List<Pair> countPair(int[] num, int diff) {
        if (num == null) {
            return null;
        }
        ArrayList<Pair> list = new ArrayList<>();
        int temp;
        for (int i = 0; i < num.length; i++) {
            temp = num[i];
            for (int j = i + 1; j < num.length; j++) {
                if (temp + diff == num[j] || temp - diff == num[j]) {
                    Pair pair = new Pair();
                    if (temp > num[j]) {
                        pair.x = num[j];
                        pair.y = temp;
                    } else {
                        pair.x = temp;
                        pair.y = num[j];
                    }
                    if (!list.contains(pair)) {
                        list.add(pair);
                    }
                }
            }
        }
        return list;
    }
}

@Data
class Pair {
    int x;
    int y;
}
