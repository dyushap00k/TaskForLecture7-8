package com.servlet;

import com.db.DataBase;
import com.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getSession().invalidate();
        User u1 = new User("Andrey",     "dyushapook", "qwerty");
        User u2 = new User("Sasha",     "sashasl", "qwerty123");
        User u3 = new User("Vova",     "volodbol", "qwerty456");
        User u4 = new User("Anton",     "elbebra17", "123qwerty");
        User u5 = new User("Андрей",     "Андрей17", "Андрей17Андрей17");
        DataBase.create(u1);
        DataBase.create(u2);
        DataBase.create(u3);
        DataBase.create(u4);
        DataBase.create(u5);
        boolean isInvalid = req.getParameter("incorrect") != null;
        req.setAttribute("isInvalid", isInvalid);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        User user = DataBase.readUser(login);
        if (user == null) {
            resp.sendRedirect("/login?incorrect");
        } else if (!user.getPassword().equals(password)) {
            resp.sendRedirect("/login?incorrect");
        } else {
            req.getSession().setAttribute("login", login);
            resp.sendRedirect("/welcome");
        }
    }
}
