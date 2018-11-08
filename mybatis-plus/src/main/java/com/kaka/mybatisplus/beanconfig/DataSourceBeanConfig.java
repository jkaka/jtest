package com.kaka.mybatisplus.beanconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisMapperRefresh;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

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
     * 动态加载 mapper.xml
     *
     * @param sqlSessionFactory
     * @return
     * @throws IOException
     */
    @Bean
    public MybatisMapperRefresh mybatisMapperRefresh(SqlSessionFactory sqlSessionFactory) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperLocations = resolver.getResources("com/kaka/mybatisplus/mapper/*.xml");
        int delaySeconds = 10;
        // 刷新时间间隔
        int sleepSeconds = 5;
        boolean enabled = true;
        return new MybatisMapperRefresh(mapperLocations, sqlSessionFactory,
                delaySeconds, sleepSeconds, enabled);
    }
}
