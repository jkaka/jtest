package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.biz.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jsk
 * @Date 2019/2/19 16:13
 */
@RestController
@RequestMapping("/mockController")
public class MockController {

    @Autowired
    private MockService mockService;

    @GetMapping("/one/{number}")
    public Integer one(@PathVariable Integer number) {
        Integer integer = mockService.one(55);
        System.out.println(integer);

        return mockService.one(number);
    }

    @GetMapping("/two/{number}")
    public Integer two(@PathVariable Integer number) {
        return mockService.two(number);
    }

    @GetMapping("/three/{number}")
    public Integer three(@PathVariable Integer number) {
        return mockService.three(number);
    }
}
