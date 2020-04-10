package com.kaka.jtest.openutils.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/09 15:09:21
 */
public class PairTest {

    @Test
    public void of() {
        Pair<String, Integer> pair = Pair.of("小明", 100);
        System.out.println(pair.getKey());
    }
}
