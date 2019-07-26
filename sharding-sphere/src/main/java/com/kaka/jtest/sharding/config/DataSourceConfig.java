package com.kaka.jtest.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.kaka.jtest.sharding.algorithm.ScoreHintShardingAlgorithm;
import com.kaka.jtest.sharding.algorithm.ScorePreciseShardingAlgorithm;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.HintShardingStrategyConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: jsk
 * @date: 2019/6/3 20:45
 */
@Configuration
@MapperScan("com.kaka.jtest.sharding.mapper")
public class DataSourceConfig {

    /**
     * 1.节点映射
     *
     * @return
     * @throws SQLException
     */
    private Map<String, DataSource> createDataSourceMap() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("jsk0", druidDataSource("jsk"));
        dataSourceMap.put("jsk1", druidDataSource("jsk_01"));
        return dataSourceMap;
    }

    private DataSource druidDataSource(final String dataSourceName) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(String.format("jdbc:mysql://localhost:3306/%s?characterEncoding=utf-8&useUnicode=true", dataSourceName));
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    /**
     * 2.person表规则
     */
    private TableRuleConfiguration getPersonTableRuleConfig() {
        TableRuleConfiguration personTableRuleConfig = new TableRuleConfiguration();
        // 1.设置逻辑表名称
        personTableRuleConfig.setLogicTable("person");

        // 2.设置物理节点
        // ${begin..end}表示范围区间，即表示从begin到end个
        // ${[unit1, unit2, unit_x]}表示枚举值
        personTableRuleConfig.setActualDataNodes("jsk${[0,1]}.person${0..4}");

        // 3.配置分库 + 分表策略
        // 分库:根据age取余(行表达式分片策略)
        personTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("age",
                "jsk${age % 2}"));
        // 分表：根据score取余(标准分片策略)
        personTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("score",
                new ScorePreciseShardingAlgorithm()));
//        personTableRuleConfig.setTableShardingStrategyConfig(new HintShardingStrategyConfiguration(new ScoreHintShardingAlgorithm()));

        // 4.分布式主键(如果insert的时候指定了主键的值,则本次插入不会使用分布式主键)
        DefaultKeyGenerator.setWorkerId(5L);
        personTableRuleConfig.setKeyGeneratorColumnName("id");


        return personTableRuleConfig;
    }

    /**
     * 3.设置分片的数据源
     *
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource shardingDataSource() throws SQLException {
        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getPersonTableRuleConfig());
        // 获取数据源对象
        Properties properties = new Properties();
        properties.put("sql.show", "true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new ConcurrentHashMap(), properties);
    }

    /**
     * Sharding-jdbc的事务支持
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource shardingDataSource) throws SQLException {
        return new DataSourceTransactionManager(shardingDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource shardingDataSource, PerformanceInterceptor performanceInterceptor)
            throws Exception {
        // 使用plus的sqlSession
        final MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(shardingDataSource);

        sessionFactory.setPlugins(new Interceptor[]{
                performanceInterceptor,
                new PaginationInterceptor(),
                new OptimisticLockerInterceptor()
        });
        return sessionFactory.getObject();
    }

    /**
     * 性能分析插件
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
