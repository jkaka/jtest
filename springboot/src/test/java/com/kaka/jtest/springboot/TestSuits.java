package com.kaka.jtest.springboot;

import com.kaka.jtest.springboot.biz.service.UserServiceImplTest;
import com.kaka.jtest.springboot.boot.controller.TestControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * testsuite：测试集
 * 1.统一测试
 * 2.idea中多个类无需都输入VM参数
 * @author jsk
 * @Date 2018/11/6 10:05
 */
@RunWith(Suite.class)// 1. 更改测试运行方式为 Suite
@Suite.SuiteClasses({TestControllerTest.class,  // 2. 将测试类传入进来
        UserServiceImplTest.class})
public class TestSuits {
    /**
     * 测试套件的入口类只是组织测试类一起进行测试，无任何测试方法，
     */
}
