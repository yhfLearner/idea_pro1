package com.hwua.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class ValidateUserFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        if (uri.contains("/validateCode") || uri.contains("/index.jsp") || uri.contains("/register.jsp") || uri.contains("/lr") || uri.contains("/css") || uri.contains("/scripts") || uri.contains("/user/login") || uri.contains("/images")) {
            chain.doFilter(request, response);// 直接放行
        } else {
            HttpSession session = request.getSession(false);
            //判断有没有登录,只要有登陆,session中就存放了user
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                chain.doFilter(request, response);//放行
            }

        }
    }

}
