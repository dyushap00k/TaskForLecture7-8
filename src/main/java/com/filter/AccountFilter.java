package com.filter;

import com.db.DataBase;
import com.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AccountFilter", urlPatterns = {"/welcome/*", "/users_list/*"})
public class AccountFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        HttpSession session = httpReq.getSession();
        String login = (String) session.getAttribute("login");
        User user = DataBase.readUser(login);
        if (login != null && user != null)
            filterChain.doFilter(servletRequest, servletResponse);
        httpResp.sendRedirect("/login");
    }
}
