package com.kaka.jtest.springboot.boot.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shuangkaijia
 */
@RestController
public class HelloController {

    @RequestMapping("/importFile")
    public String importFile(@RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename());

        return "导入成功！";
    }

    @PostMapping("/testExceptionHandler")
    public String testExceptionHandler(String name){
        System.out.println(name);
//        System.out.println( 10 /0);
        return "testExceptionHandler";
    }


}
