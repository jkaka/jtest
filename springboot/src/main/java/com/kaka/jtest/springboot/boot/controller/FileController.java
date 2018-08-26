package com.kaka.jtest.springboot.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jsk
 * @Date 2018/8/20 17:39
 */
@RestController
@RequestMapping("/fileController")
public class FileController {

    @RequestMapping("/importFile")
    public String importFile(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(file.getOriginalFilename());
        return "导入成功！";
    }
}
