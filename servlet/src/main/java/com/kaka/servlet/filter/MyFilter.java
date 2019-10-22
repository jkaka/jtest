package com.kaka.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-09-26 14:39
 */
@WebFilter(filterName = "myFilter", urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("《myFilter start...》");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("《myFilter end...》");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
