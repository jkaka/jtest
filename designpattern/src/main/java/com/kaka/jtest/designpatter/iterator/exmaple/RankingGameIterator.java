package com.kaka.jtest.designpatter.iterator.exmaple;

import java.util.List;

/**
 * rank赛迭代器
 *
 * @author: jsk
 * @date: 2019/7/20 17:31
 */
public class RankingGameIterator implements MatchIterator {
    private List<Match> matches;
    private int position = 0;

    public RankingGameIterator(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean hashNext() {
        return position < matches.size();
    }

    @Override
    public Match next() {
        Match match = matches.get(position);
        position++;
        return match;
    }

    @Override
    public Match remove() {
        return null;
    }
}
