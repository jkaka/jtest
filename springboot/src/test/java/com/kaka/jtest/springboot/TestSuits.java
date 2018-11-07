package com.kaka.jtest.springboot;

import com.kaka.jtest.springboot.biz.service.UserServiceImplTest;
import com.kaka.jtest.springboot.boot.controller.TestControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suits打包测试
 * @author jsk
 * @Date 2018/11/6 10:05
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({TestControllerTest.class,
        UserServiceImplTest.class})
public class TestSuits {
}
