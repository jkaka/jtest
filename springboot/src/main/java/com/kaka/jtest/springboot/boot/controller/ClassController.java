package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.common.utils.jvm.JavaClassUtil;
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

    private String filed = "filed1";

    @PostMapping("/execute")
    public List<String> executeCode(MultipartFile file) throws Exception {
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        System.out.println(Arrays.toString(webApplicationContext.getBeanDefinitionNames()));

        System.out.println("---------------------" + filed);
        InputStream inputStream = file.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        JavaClassUtil.execute(bytes);
        return new ArrayList<>();
    }

    @PostMapping("/compile")
    public String compileCode(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();

        JavaClassUtil.compile(bytes);
        return "compile";
    }

}
