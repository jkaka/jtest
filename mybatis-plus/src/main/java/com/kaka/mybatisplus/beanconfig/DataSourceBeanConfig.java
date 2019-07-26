package com.kaka.mybatisplus.beanconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/11/8 9:28
 */
@Configuration
public class DataSourceBeanConfig {

    private static final String MAPPER_LOCATION = "classpath:com/kaka/mybatisplus/*.xml";
    /**
     * 扫描xml四种配置方式：
     * 1.MapperScan注解(这种情况需要xml和mapper接口在同一个包下,且名称一样)；
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
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jsk?characterEncoding=utf-8&useUnicode=true");
        dataSource.setPassword("root");
        dataSource.setUsername("root");
//        配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
        dataSource.setFilters("stat,wall,log4j");
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
        // 如果编译后的target目录中,xml文件与mapper接口在同一个目录下,mapper接口和xml会自动绑定    无需以下代码
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));

        // 输出加载的文件
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION);
        if (mapperLocations.length == 0) {
            System.out.println("没有加载到mapper文件！");
        } else {
            for (Resource resource : mapperLocations) {
                System.out.println("mapper文件：" + resource.getFilename());
            }
        }

        // 加入插件
        sessionFactory.setPlugins(new Interceptor[]{
                performanceInterceptor,
                new PaginationInterceptor(),
                new OptimisticLockerInterceptor()
        });
        sessionFactory.setGlobalConfig(globalConfig);
        return sessionFactory.getObject();
    }


    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();

        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");//默认就是允许所有访问
        initParams.put("deny", "192.168.15.21");

        bean.setInitParameters(initParams);
        return bean;
    }


    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
