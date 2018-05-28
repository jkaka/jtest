package com.kaka.jtest.apollo.controller;

import com.kaka.jtest.apollo.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApolloController {
    @Autowired
    private ApplicationProperties applicationProperties;

    @ResponseBody
    @GetMapping("/testProperties")
    public String testProperties() {
        System.out.println(applicationProperties);
        return "testProperties";
    }
}
