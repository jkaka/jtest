package com.kaka.jtest.springboot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 所有的测试类都继承这个基类,就不用每个测试类上面加以下两个注解了
 *
 * @author jsk
 * @Date 2018/11/7 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("开始测试-----------------");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("测试结束-----------------");
    }


    /**
     * @BeforeClass：针对所有测试，只执行一次，且必须为static void
     * @Before：初始化方法，执行当前测试类的每个测试方法前执行。
     * @Test：测试方法，在这里可以测试期望异常和超时时间
     * @After：释放资源，执行当前测试类的每个测试方法后执行
     * @AfterClass：针对所有测试，只执行一次，且必须为static void
     * @Ignore：忽略的测试方法（只在测试类的时候生效，单独执行该测试方法无效）
     * @RunWith:可以更改测试运行器 ，缺省值 org.junit.runner.Runner
     */
}