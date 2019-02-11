package com.kaka.mybatisplus.beanconfig;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisMapperRefresh;
import com.kaka.mybatisplus.handler.FillMetaHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;

/**
 * @author jsk
 * @Date 2018/11/10 13:39
 */
@Configuration
public class MybatisPlusBeanConfig {

    /**
     * 逻辑删除(全局配置)
     *
     * @return
     */
    //@Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    //@Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁插件
     *
     * @return
     */
    //@Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

//    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        Properties properties = new Properties();
        // SQL 执行分析拦截器 stopProceed 发现全表执行 delete update 是否停止运行
        properties.setProperty("stopProceed", "true");
        sqlExplainInterceptor.setProperties(properties);
        return sqlExplainInterceptor;
    }

    /**
     * 性能分析插件
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
    /**
     * 热加载插件
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

    @Bean
    public GlobalConfig globalConfig(FillMetaHandler fillMetaHandler) {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setLogicDeleteValue("N");
        dbConfig.setLogicNotDeleteValue("Y");
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setDbConfig(dbConfig);
        globalConfig.setSqlInjector(sqlInjector());

        globalConfig.setMetaObjectHandler(fillMetaHandler);
        return globalConfig;
    }
}
