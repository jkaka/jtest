package com.kaka.jtest.designpatter.iterator.exmaple;

import java.util.List;

/**
 * rank赛聚合实现类
 *
 * @author: jsk
 * @date: 2019/7/20 17:23
 */
public class RankingGameList implements MatchList {
    private List matches;

    public RankingGameList(List matches) {
        this.matches = matches;
    }

    @Override
    public MatchIterator createIterator() {
        return new RankingGameIterator(matches);
    }
}
