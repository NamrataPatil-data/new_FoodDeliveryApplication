package com.app.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.app.dao.OrderDAO;
import com.app.dao.impl.OrderoDAOImpl;
import com.app.model.Order;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        OrderDAO orderDAO = new OrderoDAOImpl();
        List<Order> orders = orderDAO.getOrdersByUserId(userId);

        // 🔴 VERY IMPORTANT
        request.setAttribute("orders", orders);

        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
