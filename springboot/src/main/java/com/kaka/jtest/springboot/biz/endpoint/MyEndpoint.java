package com.kaka.jtest.springboot.biz.endpoint;

import com.kaka.jtest.springboot.biz.indicator.MyHealthIndicator;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/**
 * 端点配置
 * 若想把结果配置到默认路径(/actuator/health)中,使用HealthIndicator方式   {@link MyHealthIndicator}
 * id中不能有大写
 * @author: jsk
 * @date: 2019/8/22 16:17
 */
@WebEndpoint(id = "myendpoint")
@Component
public class MyEndpoint {

    /**
     * get请求方式
     * returns a value, the response status will be 200 (OK).
     * If it does not return a value, the response status will be 404 (Not Found).
     */
    @ReadOperation
    public void testRead() {
        System.out.println("testRead");
    }

    /**
     * POST请求方式
     * returns a value, the response status will be 200 (OK).
     * If it does not return a value the response status will be 204 (No Content).
     */
    @WriteOperation
    public void testWrite() {
        System.out.println("testWrite");
    }

    /**
     * Delete请求方式
     * returns a value, the response status will be 200 (OK).
     * If it does not return a value the response status will be 204 (No Content).
     */
    @DeleteOperation
    public void testDelete() {
        System.out.println("testDelete");
    }

}
