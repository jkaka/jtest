package com.kaka.jtest.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.kaka.common.utils.PropertiesUtil;
import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class DBUtil {

    private static String mysqlUrl = PropertiesUtil.getLocalProperty("mysql.url");

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + mysqlUrl + "?useUnicode=true&characterEncoding=UTF8";
        props.setProperty("user", "TEST_SK_APP");
        props.setProperty("password", "123456");
        //设置可以获取remarks信息
        props.setProperty("remarks", "true");
        //设置可以获取tables remarks信息
        props.setProperty("useInformationSchema", "true");
        return DriverManager.getConnection(url, props);
    }

    @Test
    public void connectTest() throws Exception {
        System.out.println(getConnection());
    }
}
