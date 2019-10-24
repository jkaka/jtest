package com.kaka.jtest.mybatis.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 自定义数据源
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-22 11:25DruidDataSourceFactory
 */
public class MyDataSourceFactory implements DataSourceFactory {

	private DataSource dataSource;

	public MyDataSourceFactory() {
		System.out.println("创建数据源工厂...");
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://localhost:3306/jsk?characterEncoding=utf-8&useUnicode=true");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("root");
		dataSource = druidDataSource;
	}

	private Properties properties;

	@Override
	public void setProperties(Properties props) {
		this.properties = props;
	}

	@Override
	public DataSource getDataSource() {
		System.out.println("从工厂中获取数据源,properties:" + properties);
		return dataSource;
	}
}