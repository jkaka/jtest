package com.kaka.jtest.springboot.boot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaka.jtest.springboot.biz.dataobject.User;
import com.kaka.jtest.springboot.biz.mapper.UserDao;
import com.kaka.jtest.springboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author shuangkaijia
 */
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @PostMapping("/testExceptionHandler")
    public String testExceptionHandler(String name) {
        PageInfo<User> user = userService.selectList();
        System.out.println(user);
        System.out.println(user.getTotal());
        return "testExceptionHandler";
    }

    /**
     * 重复读body体中的内容(只能读取一次)
     *
     * @return
     */
    @PostMapping("/repetitionReadBody")
    public String repetitionReadBody(@RequestBody Map<String, Object> map) {
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
        return "repetitionReadBody";
    }

}
