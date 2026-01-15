package com.app.controller;

import java.io.IOException;

import com.app.dao.UserDAO;
import com.app.dao.impl.UserDAOImpl;
import com.app.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        User user = new User();
        user.setUsername(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));

        UserDAO dao = new UserDAOImpl();
        dao.register(user);

        res.sendRedirect("login.jsp");
    }
}

