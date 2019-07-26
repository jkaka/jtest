package com.kaka.jtest.designpatter.iterator.exmaple;

/**
 * 匹配赛聚合实现类
 *
 * @author: jsk
 * @date: 2019/7/20 17:22
 */
public class MatchingGameList implements MatchList {
    private Match[] matches;

    public MatchingGameList(Match[] matches) {
        this.matches = matches;
    }

    @Override
    public MatchIterator createIterator() {
        return new MatchingGameIterator(matches);
    }
}
