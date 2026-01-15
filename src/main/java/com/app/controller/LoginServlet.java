package com.app.controller;

import java.io.IOException;

import com.app.dao.UserDAO;
import com.app.dao.impl.UserDAOImpl;
import com.app.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAOImpl();
        User user = dao.login(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            
            session.setAttribute("loggedUser", user);

            // 🔁 VERY IMPORTANT (return after login)
            String redirectURL = (String) session.getAttribute("redirectAfterLogin");

            if (redirectURL != null) {
                session.removeAttribute("redirectAfterLogin");
                response.sendRedirect(redirectURL);
            } else {
            	response.sendRedirect(request.getContextPath() + "/HomeServlet");

            }

        } else {
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
