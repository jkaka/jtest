package com.kaka.jtest.jdk.java.util;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2018/11/26 9:18
 */
public class WeakHashMapTest {

    /**
     * 弱引用
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        String aa = new String("AA");
        String bb = new String("BB");
        Map<String, Person> map = new WeakHashMap<>();
        map.put(aa, new Person(1, "AA"));
        map.put(bb, new Person(1, "BB"));
        aa = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(map.size());
    }

    @Test
    public void test1(){
        float a = -0.0f;
        float b = -0.0f;
        System.out.println(-0.0f == b);
    }
}
