package com.kaka.jtest.mybatis.test;

import com.kaka.jtest.mybatis.BaseTest;
import com.kaka.jtest.mybatis.entities.User;
import com.kaka.jtest.mybatis.mapper.LabelMapper;
import org.junit.Test;

/**
 * xml中的标签
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-09 20:14
 */
public class LabelTest extends BaseTest {


    /**
     * set标签
     * 1. 会把该标签内的最后一个逗号去掉；一般与if标签一起使用(这样末尾才有可能多出一个逗号)
     * 2. set标签内没有赋值操作，SQL会报错
     */
    @Test
    public void setLabelTest(){
        LabelMapper mapper = sqlSession.getMapper(LabelMapper.class);
        User user = new User();
        user.setId(1);
        user.setAge(23);
        mapper.setLabelTest(user);
    }

    /**
     * if标签
     * 1. test条件中无需使用#{}取值符号
     * 2. 可以使用逻辑运算符号：&& || ==
     */
    @Test
    public void ifLabelTest(){
        LabelMapper mapper = sqlSession.getMapper(LabelMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("");
        mapper.ifLabelTest(user);
    }
}
