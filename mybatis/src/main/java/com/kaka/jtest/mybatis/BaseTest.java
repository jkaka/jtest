package com.kaka.jtest.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.InputStream;

/**
 * @author: jsk
 * @date: 2019/6/27 19:55
 */
public class BaseTest {

    protected SqlSession sqlSession = null;
    protected SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws Exception {
        String resource = "/mybatis/SqlMapConfig.xml";
        // 2.用类加载器获得配置数据库的流
        InputStream is = this.getClass().getResourceAsStream(resource);
        // 1.构建sqlSession的工厂，需要一个配置数据源的流(输入流无需我们代码关闭,build方法内已关闭)
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3.创建能执行映射文件中sql的SqlSession-------用的工厂的openSession方法
        sqlSession = sqlSessionFactory.openSession(true);//事务默认是手动提交openSession()
    }

    @After
    public void after() {
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
}
