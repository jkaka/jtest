package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.common.utils.jvm.JavaClassUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/3/25 20:24
 */
@RestController
@RequestMapping("/classController")
public class ClassController {

    public ClassController(){
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
    private String filed = "filed1";

    @PostMapping("/execute")
    public List<String> executeCode(MultipartFile file, String className) throws Exception {
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        System.out.println(Arrays.toString(webApplicationContext.getBeanDefinitionNames()));

        System.out.println("---------------------" + filed);
        InputStream inputStream = file.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        JavaClassUtil.execute(className, bytes);
        return new ArrayList<>();
    }

    @PostMapping("/compile")
    public String compileCode(MultipartFile file, String className) throws Exception {
        System.out.println(filed);
        InputStream inputStream = file.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();

        JavaClassUtil.compile(className, bytes);
        return "compile";
    }

    @GetMapping("/output")
    public String output(){
        System.out.println(filed);
        return filed;
    }
}
