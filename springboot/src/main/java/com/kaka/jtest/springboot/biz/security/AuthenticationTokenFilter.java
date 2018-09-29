package com.kaka.jtest.springboot.biz.security;

import com.kaka.jtest.springboot.biz.wrapper.WrappedHttpServletRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shuangkaijia
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("1.过滤器(请求前)：" + httpServletRequest.getRequestURL());
        WrappedHttpServletRequest requestWrapper = new WrappedHttpServletRequest(httpServletRequest);
        String params = requestWrapper.getRequestParams();
        System.out.println("请求体：" + params);
        filterChain.doFilter(requestWrapper, httpServletResponse);
        System.out.println("过滤器(请求后)：" + httpServletRequest.getRequestURL());
    }
}
