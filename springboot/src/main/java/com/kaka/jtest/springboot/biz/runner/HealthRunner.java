package com.kaka.jtest.springboot.biz.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: jsk
 * @date: 2019/8/16 12:44
 */
@Component
public class HealthRunner implements ApplicationRunner {
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始健康检查...");
            ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8081/actuator/health", String.class);
            System.out.println(result.getBody());

        }).start();
        // 1.异步去检查服务是否健康
        // 2.获取返回结果
        // 3.解析返回结果
        // 4.输出
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8008/actuator/health1", String.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getStatusCodeValue());
    }
}