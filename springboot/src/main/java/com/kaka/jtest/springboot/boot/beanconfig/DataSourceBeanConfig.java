package com.kaka.jtest.springboot.boot.beanconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Properties;

/**
 * @author shuangkaijia
 */
@Configuration
@MapperScan(basePackages = "com.kaka.jtest.springboot.biz.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceBeanConfig {

    /**
     * 事务管理器
     *
     * @return
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 数据库连接工厂
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:com/kaka/jtest/springboot/biz/mapper/*.xml"));
        //添加插件
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        PageInterceptor p  = new PageInterceptor();
        p.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{p});
        return sessionFactory.getObject();
    }

    @Bean
    public PageInterceptor pageInterceptor (){
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        PageInterceptor pageInterceptor  = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
    /**
     * 数据源
     *
     * @return
     */
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jsk?characterEncoding=utf-8&useUnicode=true");
        dataSource.setPassword("root");
        dataSource.setUsername("root");
        return dataSource;
    }

    /**
     * 分页插件
     *
     * @return
     */
   // @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        pageHelper.setProperties(properties);
        System.out.println(pageHelper.toString());
        return pageHelper;
    }
}
