package com.kaka.jtest.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author shuangkaijia
 */
public class DBUtil {

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jsk?useUnicode=true&characterEncoding=UTF8";

        props.setProperty("user", "root");
        props.setProperty("password", "root");
        props.setProperty("remarks", "true"); //设置可以获取remarks信息
        props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息

        return DriverManager.getConnection(url, props);
    }
}
