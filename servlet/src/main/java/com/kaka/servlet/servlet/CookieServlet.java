package com.kaka.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-09-26 14:15
 */
@WebServlet(
        name = "cookieServlet",
        urlPatterns = {"/servlet/cookieServlet"},
        loadOnStartup = 1)
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
    }
}
