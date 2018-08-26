package com.kaka.jtest.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;

/**
 * @author shuangkaijia
 */
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class })
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Spring应用启动起来
        SpringApplication.run(Application.class, args);
    }
}

