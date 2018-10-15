package com.kaka.jtest.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaka.jtest.mybatis.entities.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class APP {

    private SqlSession sqlSession = null;

    @Before
    public void before() throws Exception {
        String resource = "/SqlMapConfig.xml";
        // 2.用类加载器获得配置数据库的流
        InputStream is = this.getClass().getResourceAsStream(resource);
        // 1.构建sqlSession的工厂，需要一个配置数据源的流
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        is.close();
        // 3.创建能执行映射文件中sql的SqlSession-------用的工厂的openSession方法
        sqlSession = factory.openSession(true);//事务默认是手动提交openSession()
    }

    @After
    public void after() {
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

    }


    @Test
    public void testParams() {
        String statement = "com.kaka.jtest.mybatis.mapper.UserMapper.listUser";
        Map list11 = new HashMap();
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
        Map params = new HashMap();
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
        params.put("name", "jsk2");

        String statement = "com.kaka.jtest.mybatis.mapper.UserMapper.testIf";
        List<User> users = sqlSession.selectList(statement, params);
        System.out.println(users);
    }
}
