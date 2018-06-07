package com.kaka.jtest.ssm.controller;

import com.kaka.jtest.ssm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping("/selectListUser")
    public String selectListUser(){
        System.out.println(userDao.selectList());
        return "selectListUser";
    }
}
