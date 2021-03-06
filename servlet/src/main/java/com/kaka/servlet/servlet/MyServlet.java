package com.kaka.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-09-26 12:27
 */
@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/servlet/MyServlet"},
        loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法...");
        System.out.println("get方法...123");
        // 设置响应内容类型
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>get method</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post方法...");
        // 设置响应内容类型
        resp.setContentType("text/html");
        resp.getWriter().write("post method");
    }
}
