package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.properties.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/02/20 15:12:22
 */
@RestController
@RequestMapping("/propertiesController")
public class PropertiesController {
    @Autowired
    private MyProperties myProperties;

    @GetMapping("/printProperties")
    public String printProperties() {
        return myProperties.getTestKey();
    }
}
