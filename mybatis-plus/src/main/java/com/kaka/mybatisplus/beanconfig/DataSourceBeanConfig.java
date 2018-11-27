package com.kaka.mybatisplus.beanconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author jsk
 * @Date 2018/11/8 9:28
 */
@Configuration
@MapperScan("com.kaka.mybatisplus.mapper")
public class DataSourceBeanConfig {

    /**
     * 扫描xml四种配置方式：
     * 1.MapperScan注解；
     * 2.MapperScannerConfigurer的basePackage；
     * 3.MybatisSqlSessionFactoryBean的mapperLocations
     * 4.application.properties
     */


    /**
     * druid连接池
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jsk?characterEncoding=utf-8&useUnicode=true");
        dataSource.setPassword("root");
        dataSource.setUsername("root");
        return dataSource;
    }

    /**
     * 不使用springboot作为父工程,需要显示创建SqlSessionFactoryBean
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(GlobalConfig globalConfig, PerformanceInterceptor performanceInterceptor)
            throws Exception {
        final MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPlugins(new Interceptor[]{
                performanceInterceptor,
                new PaginationInterceptor(),
                new OptimisticLockerInterceptor()
        });
        sessionFactory.setGlobalConfig(globalConfig);
        return sessionFactory.getObject();
    }

}
