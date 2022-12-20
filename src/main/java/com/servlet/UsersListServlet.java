package com.servlet;

import com.db.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users_list")
public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", DataBase.getAllUsers());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/users_list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
