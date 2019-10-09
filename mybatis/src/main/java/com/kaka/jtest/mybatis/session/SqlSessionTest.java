package com.kaka.jtest.mybatis.session;

import com.kaka.jtest.mybatis.BaseTest;
import com.kaka.jtest.mybatis.entities.User;
import com.kaka.jtest.mybatis.mapper.UserMapper;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-09 16:48
 */
public class SqlSessionTest extends BaseTest {

    /**
     * sqlSession被关闭之后，再使用mapper会报错！
     */
    @Test
    public void closeTest(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        sqlSession.close();
        User user = mapper.selectOne(1);
        System.out.println(user);
    }
}
