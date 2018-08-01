package com.kaka.jtest.jdbc;

import com.kaka.jtest.jdbc.utils.DBUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shuangkaijia
 */
public class ConnectionTest {

    private Connection conn = null;

    @Before
    public void before() throws Exception {
        conn = DBUtil.getConnection();;
    }

    @Test
    public void getConnection(){
        System.out.println(conn);
    }


    @After
    public void after() throws SQLException {
        conn.close();
    }
}
