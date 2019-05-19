package com.kaka.jtest.jdk.java.grammar;

import org.junit.Test;

import java.util.Objects;

/**
 * @author: jsk
 * @date: 2019/5/8 17:51
 */
public class ThreeUnary {

    @Test
    public void test(){
        Integer obj = null;
        // 三目运算符中如果有基本类型和对象就会自动拆箱
        Integer issuedCount = Objects.isNull(obj) ? null: obj;
//        Integer issuedCount = Objects.isNull(obj) ? obj: obj.intValue();
        System.out.println(issuedCount);
    }


    public Integer testa(){
        System.out.println("testaa");
        return 0;
    }

    public Integer testb(){
        System.out.println("testbb");
        return 0;
    }
}
