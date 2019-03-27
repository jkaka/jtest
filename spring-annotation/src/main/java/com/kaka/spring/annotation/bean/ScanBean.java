package com.kaka.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: jsk
 * @date: 2019/3/14 15:41
 */
@Component
public class ScanBean {

    @Autowired
    private Person person;

    public ScanBean() {
        System.out.println("@Component的构造方法1......." + person);
    }

    @PostConstruct
    public void test() {
        System.out.println("@Component中的PostConstruct标注的方法2......." + person);
    }
}
