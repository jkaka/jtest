package com.kaka.jtest.mybatis.test;

import com.kaka.jtest.mybatis.BaseTest;
import com.kaka.jtest.mybatis.mapper.UserMapper;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-22 11:10
 */
public class CrudTest extends BaseTest {

	@Test
	public void selectByName(){
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(userMapper.selectByName("aa1"));
	}
}
