package com.kaka.spring.pojo;

import lombok.Data;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/31 11:40:06
 */
@Data
public class Department {
    private Integer id;
    private String name;

    public Department() {
        System.out.println("执行department构造方法...");
    }

    public void testInitMethod(){
        System.out.println("我是配置的初始化方法...");
    }

    public void mergedInitMethod(){
        System.out.println("我是修改后的初始化方法...");
    }
}
