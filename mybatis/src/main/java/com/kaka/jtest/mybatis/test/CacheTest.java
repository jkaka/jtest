package com.kaka.jtest.mybatis.test;

import com.kaka.jtest.mybatis.BaseTest;
import com.kaka.jtest.mybatis.entities.User;
import com.kaka.jtest.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 1. 只能在【只有单表操作】的表上使用缓存
 * 不只是要保证这个表在整个系统中只有单表操作，而且和该表有关的全部操作必须全部在一个namespace下。
 * 2. 在可以保证查询远远大于insert,update,delete操作的情况下使用缓存
 *
 * @author: jsk
 * @date: 2019/6/27 19:54
 */
public class CacheTest extends BaseTest {

    @Test
    public void secondLevel() {
        //获取session1
        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper userMapper = session1.getMapper(UserMapper.class);
        //使用session1执行第一次查询
        User user1 = userMapper.selectOne(1);
        System.out.println(user1);
        //关闭session1
        session1.close();

        //获取session2
        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);
        //使用session2执行第二次查询，由于开启了二级缓存这里从缓存中获取数据不再向数据库发出sql
        User user2 = userMapper2.selectOne(1);
        System.out.println(user2);
        //关闭session2
        session2.close();

    }
}
