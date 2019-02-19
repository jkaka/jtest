package com.kaka.jtest.springboot.biz.service;

import org.springframework.stereotype.Service;

/**
 * @author jsk
 * @Date 2019/2/19 16:12
 */
@Service
public class MockServiceImpl implements MockService {
    @Override
    public Integer one(Integer number) {
        System.out.println("service中的one方法:" + number);
        return number;
    }

    @Override
    public Integer two(Integer number) {
        System.out.println("service中的two方法:" + number);
        return number;
    }

    @Override
    public Integer three(Integer number) {
        System.out.println("service中的three方法:" + number);
        return number;
    }
}
