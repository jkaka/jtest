package com.kaka.jtest.sharding.algorithm;

import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author: jsk
 * @date: 2019/6/11 20:46
 */
public class ScoreHintShardingAlgorithm implements HintShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ShardingValue shardingValue) {
        HashSet<String> strings = new HashSet<>();
        ListShardingValue listShardingValue = (ListShardingValue) shardingValue;
        for (String tableName : availableTargetNames){
            for(Object score : listShardingValue.getValues()){
                if(tableName.endsWith(score.toString())){
                    strings.add(tableName);
                }
            }
        }
        return strings;
    }
}
