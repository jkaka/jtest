package com.kaka.jtest.springboot.boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author shuangkaijia
 */
@RestController
@RequestMapping("/orderController")
public class OrderController {

    /**
     * request请求的执行顺序
     *
     * @param map
     * @return
     */
    @PostMapping("/requestOrder")
    public String requestOrder(@RequestBody Map<String, Object> map) {
        System.out.println("5.controller");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
        return "requestOrder";
    }
}
