package com.kaka.jtest.jdk.java8.util.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class IntStreamTest {

    public void summaryStatistics(){
        IntSummaryStatistics intSummaryStatistics = Stream.of(1, 2, 3)
                .mapToInt(integer -> integer)
                .summaryStatistics();
        System.out.println("count:" + intSummaryStatistics.getCount());
        System.out.println("sum:" + intSummaryStatistics.getSum());
        System.out.println("max:" + intSummaryStatistics.getMax());
        System.out.println("min:" + intSummaryStatistics.getMin());
        System.out.println("average:" + intSummaryStatistics.getAverage());
    }
}
