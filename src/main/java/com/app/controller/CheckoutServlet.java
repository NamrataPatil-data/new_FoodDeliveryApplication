package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    // ✅ HANDLE GET (redirects land here)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // 🔐 Login check
        if (session.getAttribute("loggedUser") == null) {
            session.setAttribute("redirectAfterLogin", "checkout");
            response.sendRedirect("login.jsp");
            return;
        }

        // ✅ Show checkout page
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    // ✅ HANDLE POST (Confirm order button)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("loggedUser") == null) {
            session.setAttribute("redirectAfterLogin", "checkout");
            response.sendRedirect("login.jsp");
            return;
        }

        // Next step: address / payment
        response.sendRedirect("address.jsp");
    }
}
