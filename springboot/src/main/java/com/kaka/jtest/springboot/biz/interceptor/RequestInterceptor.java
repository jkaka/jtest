package com.kaka.jtest.springboot.biz.interceptor;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 请求拦截器
 *
 * @author shuangkaijia
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("2.拦截器拦截请求：" + httpServletRequest.getRequestURI());
        InputStream is = null;
        String contentStr = "";
        try {
            is = httpServletRequest.getInputStream();
//            contentStr = IOUtils.toString(is, "utf-8");
//            System.out.println("请求体：" + contentStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
