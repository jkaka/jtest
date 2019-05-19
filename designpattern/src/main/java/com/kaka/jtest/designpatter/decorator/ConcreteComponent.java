package com.kaka.jtest.designpatter.decorator;

/**
 * 基础组件实现类
 *
 * @author: jsk
 * @date: 2019/5/11 21:47
 */
public class ConcreteComponent implements Component {
    @Override
    public String methodA() {
        return "一杯咖啡";
    }

    @Override
    public Integer methodB() {
        return 20;
    }
}
