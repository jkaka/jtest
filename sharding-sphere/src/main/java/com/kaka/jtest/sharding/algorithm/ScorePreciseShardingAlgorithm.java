package com.kaka.jtest.sharding.algorithm;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 注意类与覆盖方法中的泛型
 *
 * @author: jsk
 * @date: 2019/6/10 15:17
 */
public class ScorePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        System.out.println(availableTargetNames);
        System.out.println(shardingValue);
        Integer value = shardingValue.getValue();
        for (String name : availableTargetNames) {
            if (name.endsWith((value + 10) % availableTargetNames.size() + "")) {
                System.out.println("数据路由,score:" + value + ";表名:" + name);
                return name;
            }
        }
        return null;
    }
}
