package com.kaka.jtest.designpatter.iterator.exmaple;

/**
 * 匹配赛迭代器
 *
 * @author: jsk
 * @date: 2019/7/20 17:31
 */
public class MatchingGameIterator implements MatchIterator {
    private Match[] matches;
    private int position = 0;

    public MatchingGameIterator(Match[] matches) {
        this.matches = matches;
    }

    @Override
    public boolean hashNext() {
        if (position >= matches.length
                || matches[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Match next() {
        Match match = matches[position];
        position++;
        return match;
    }

    @Override
    public Match remove() {
        return null;
    }
}
