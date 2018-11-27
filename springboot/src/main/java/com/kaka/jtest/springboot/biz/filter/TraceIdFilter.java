package com.kaka.jtest.springboot.biz.filter;

import com.kaka.common.utils.TraceIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jsk
 * @Date 2018/11/15 15:52
 */
public class TraceIdFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId = request.getHeader("traceId");
        if (StringUtils.isEmpty(traceId)) {
            traceId = TraceIdUtil.generateTraceId();
            logger.info("服务生成的traceId：" + traceId + "!请求开始：" + request.getRequestURI());
        } else {
            logger.info("网关带来的traceId：" + traceId + "!请求开始：" + request.getRequestURI());
        }
        filterChain.doFilter(request, response);
        logger.info("请求结束,traceId：" + traceId);
    }
}
