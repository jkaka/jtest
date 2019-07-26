package com.kaka.jtest.designpatter.iterator.exmaple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/7/20 17:45
 */
public class GameListClient {

    public static void main(String[] args) {
        // 1.创建匹配赛列表
        Match[] matches = new Match[5];
        for (int i = 0; i < 5; i++) {
            Integer time = new Double(Math.random() * 100).intValue();
            boolean success = time % 2 == 0;
            Match match = new Match("匹配赛" + i, time, success);
            matches[i] = match;
        }
        MatchList matchingGameList = new MatchingGameList(matches);

        // 2.创建rank赛列表
        List<Match> matcheList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Integer time = new Double(Math.random() * 100).intValue();
            boolean success = time % 2 == 0;
            Match match = new Match("排位赛" + i, time, success);
            matcheList.add(match);
        }
        MatchList rankingGameList = new RankingGameList(matcheList);

        // 3.输出比赛
        System.out.println("*****打印匹配赛列表*****");
        printMatchList(matchingGameList.createIterator());
        System.out.println("*****打印排位赛列表*****");
        printMatchList(rankingGameList.createIterator());
    }

    private static void printMatchList(MatchIterator matchIterator) {
        while (matchIterator.hashNext()) {
            Match match = matchIterator.next();
            System.out.println(match.getMatchName() + ",游戏时长:" + match.getTime() + "min;比赛结果:" + (match.isSuccess() ? "胜利" : "失败"));
        }
    }
}
