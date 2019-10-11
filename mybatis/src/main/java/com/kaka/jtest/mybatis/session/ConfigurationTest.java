package com.kaka.jtest.mybatis.session;

import com.kaka.jtest.mybatis.BaseTest;
import com.kaka.jtest.mybatis.mapper.UserMapper;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-10 17:53
 */
public class ConfigurationTest extends BaseTest {

    @Test
    public void getMapperTest(){
        sqlSessionFactory.getConfiguration().getMapper(UserMapper.class, sqlSession);
    }
}
