package com.kaka.jtest.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaka.jtest.mybatis.BaseTest;
import com.kaka.jtest.mybatis.entities.User;
import com.kaka.jtest.mybatis.mapper.UserMapper;
import org.junit.Test;

import java.util.*;

/**
 * @author: jsk
 * @date: 2019/6/27 19:56
 */
public class CommonTest extends BaseTest {

    @Test
    public void testParams() {
        String statement = "com.kaka.jtest.mybatis.mapper.UserMapper.listUser";
        Map<String, Object> list11 = new HashMap<>(8);
        list11.put("keys", Arrays.asList("BB"));
        list11.put("AA", "BB");
        List<User> users = sqlSession.selectList(statement, list11);
        System.out.println(users);
    }

    /**
     * 测试if语句中的size写法
     */
    @Test
    public void testSize(){
        List<String> ids = new ArrayList<>();
        String statement = "com.kaka.jtest.mybatis.mapper.UserMapper.listUser";
        Map<String, Object> params = new HashMap<>(8);
        params.put("keys", Arrays.asList("BB"));
        params.put("idList", ids);
        List<User> users = sqlSession.selectList(statement, params);
        System.out.println("users:" + users);
    }

    @Test
    public void testPage() {
        PageHelper.startPage(1,10);
        String statement = "com.kaka.jtest.mybatis.mapper.UserMapper.listUserTestPage";
        List<User> users = sqlSession.selectList(statement);
        PageInfo<User> p=new PageInfo<>(users);
        System.out.println(users);
        System.out.println(p);
    }

    @Test
    public void testIf(){
        Map params = new HashMap();
        params.put("name", "jsk");

        String statement = "com.kaka.jtest.mybatis.mapper.UserMapper.testIf";
        List<User> users = sqlSession.selectList(statement, params);
        System.out.println(users);
    }

    @Test
    public void testSet(){
        User user = new User();
        user.setId(1);
//        user.setName("AAA");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.updateUser(user));
    }

    @Test
    public void long2Date(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectOne(2));
    }

    /**
     * 多参数
     * DefaultSqlSession.selectOne()
     */
    @Test
    public void selectByMultiParam(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> param = new HashMap<>(8);
        param.put("id", 5);
        System.out.println(userMapper.selectMultiParam(param, "aa1"));
    }
}
