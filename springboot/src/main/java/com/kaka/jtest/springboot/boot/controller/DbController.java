package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jsk
 * @Date 2019/2/15 16:07
 */
@RestController
@RequestMapping("/dbController")
public class DbController {

    @Autowired
    private UserService userService;

    @PutMapping("/user/test_tx")
    public Integer testTx() {
        userService.testTx();
        return 5;
    }

    /**
     * service内部方法间调用,加不上事务
     * 只能在注入service的类中(如controller、manager)调用service.method()
     *
     * @return
     */
    @PutMapping("/user/test_tx/nest_method")
    public Integer testNestMethod() {
        userService.nestMethod();
        return 5;
    }

}
