package com.kaka.jtest.springboot.boot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.kaka.jtest.springboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private UserService userService;

    @GetMapping("/getConnect")
    public String getConnect() throws SQLException {
        return druidDataSource.getConnection().toString();
    }


    /**
     * 测试同一个userName有多条数据。
     * @param userName
     * @return
     */
    @PostMapping("/selectAge")
    public String selectAge(String userName) {
        System.out.println("查询用户的age!username:" + userName);
        System.out.println(userService.selectAge(userName));
        return "selectAge";
    }
}
