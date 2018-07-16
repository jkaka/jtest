package com.kaka.jtest.springboot.boot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private DruidDataSource druidDataSource;

    @GetMapping("/getConnect")
    public String getConnect() throws SQLException {
        return druidDataSource.getConnection().toString();
    }
}
