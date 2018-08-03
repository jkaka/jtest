package com.kaka.jtest.springboot.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/acceptController")
public class AcceptController {
    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response) {
        System.out.println("accept=text/html");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getConnect");
        return modelAndView;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        System.out.println("accept=ResponseBody");
        Map<String, Object> map = new HashMap<>();
        map.put("username", "jsk");
        ResponseEntity responseEntity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
