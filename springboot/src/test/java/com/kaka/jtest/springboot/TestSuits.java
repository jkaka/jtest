package com.kaka.jtest.springboot;

import com.kaka.jtest.springboot.biz.service.UserServiceImplTest;
import com.kaka.jtest.springboot.boot.controller.TestControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jsk
 * @Date 2018/11/6 10:05
 */
// 1. 更改测试运行方式为 Suite
@RunWith(Suite.class)
// 2. 将测试类传入进来
@Suite.SuiteClasses({TestControllerTest.class,
        UserServiceImplTest.class})
public class TestSuits {
    /**
     * 测试套件的入口类只是组织测试类一起进行测试，无任何测试方法，
     */
}
