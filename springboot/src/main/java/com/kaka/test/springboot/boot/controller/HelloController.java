package com.kaka.test.springboot.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @RequestMapping("/importFile")
    public String importFile(@RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename());

        return "导入成功！";
    }
}
