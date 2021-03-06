package com.kaka.jtest.jdk.java8.util.stream;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * 如果返回值是 Stream，那么是惰性求值(中间操作)；如果返回值是另一个值或为空，那么就是及早求值(结束操作)。
 *
 * @author shuangkaijia
 */
public class IntStreamTest {

    @Test
    public void summaryStatistics() {
        IntSummaryStatistics intSummaryStatistics = Stream.of(1, 2, 3)
                .mapToInt(integer -> integer)
                .summaryStatistics();
        System.out.println("count:" + intSummaryStatistics.getCount());
        System.out.println("sum:" + intSummaryStatistics.getSum());
        System.out.println("max:" + intSummaryStatistics.getMax());
        System.out.println("min:" + intSummaryStatistics.getMin());
        System.out.println("average:" + intSummaryStatistics.getAverage());
    }

    @Test
    public void sumTest() {
        Integer sum = Arrays.stream(new Person[]{new Person(22, "AA"), new Person(33, "BB")})
                .mapToInt(Person::getId)
                .sum();
        System.out.println(sum);
    }

    @Test
    public void maxTest() {
        int max = Arrays.stream(new String[]{"abc", "bbb", "aa", "agdts", "asstet"})
                .filter(s -> s.startsWith("a"))
                .mapToInt(String::length)
                .max()
                .orElse(1);
        System.out.println(max);
    }
}
