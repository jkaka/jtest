package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.util.Iterator;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-09 14:25
 */
public class IterableTest {

    /**
     * foreach调用顺序
     * 1. 使用iterable对象的iterator方法，获取一个iterator对象
     * 2. 调用该iterator对象的hasNext方法
     *  2.1 若返回false  循环结束
     *  2.2 若返回true，则继续3
     * 3. 调用iterator对象的next获取对象
     */
    @Test
    public void iteratorTest(){
        MyIterable strings = new MyIterable();
        for(String string : strings){
            System.out.println("========"  +string);
        }
    }

}

class MyIterable implements Iterable<String>{
    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }
}

class MyIterator implements Iterator<String>{
    private int num = 3;
    @Override
    public boolean hasNext() {
        if(num <= 0){
            System.out.println("迭代结束");
            return false;
        }else{
            System.out.println("hasNext..." + num);
            num --;
            return true;
        }
    }

    @Override
    public String next() {
        System.out.println("next()...");
        return num + "a";
    }
}