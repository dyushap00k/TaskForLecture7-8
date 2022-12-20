package com.servlet;

import com.db.DataBase;
import com.entity.User;
import com.service.CredentialService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getSession().invalidate();
        boolean isAlreadyUsedLogin = req.getParameter("isAlreadyUsedLogin") != null;
        boolean isIncorrectInput = req.getParameter("incorrect_input") != null;
        req.setAttribute("incorrect_input", isIncorrectInput);
        req.setAttribute("isAlreadyUsedLogin", isAlreadyUsedLogin);

        RequestDispatcher rd = req.getRequestDispatcher("view/registration.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (CredentialService.isValidName(name) &&
                CredentialService.isValidLogin(login) &&
                CredentialService.isValidPassword(password)) {

            if (DataBase.create(new User(name, login, password))) {
                resp.sendRedirect("/login");
            } else {
                resp.sendRedirect("/registration?isAlreadyUsedLogin");
            }
        }else {
            resp.sendRedirect("/registration?incorrect_input");
        }
    }
}
