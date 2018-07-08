package com.kaka.jtest.springboot.boot.beanconfig;

import com.kaka.jtest.springboot.biz.security.AuthenticationTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuangkaijia
 */
@Configuration
public class FilterConfig {

    /**
     * 拦截器注册
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myOncePerRequestFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationTokenFilter());
        registration.addUrlPatterns("/*");// 拦截路径
        registration.setName("AuthenticationTokenFilter");// 拦截器名称
        registration.setOrder(2);// 顺序
        return registration;
    }

}