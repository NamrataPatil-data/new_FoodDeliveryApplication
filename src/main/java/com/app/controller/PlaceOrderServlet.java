package com.app.controller;

import java.io.IOException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.app.dao.OrderDAO;
import com.app.dao.OrderItemDAO;
import com.app.dao.impl.OrderItemDAOImpl;
import com.app.dao.impl.OrderoDAOImpl;
import com.app.model.Cart;
import com.app.model.CartItem;
import com.app.model.Order;
import com.app.model.OrderItem;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // 1. Check login
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        // 2. Get cart
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        // 3. Calculate total amount
        double totalAmount = 0;
        for (CartItem cartItem : cart.getItems()) {
            totalAmount += cartItem.getMenu().getPrice() * cartItem.getQuantity();
        }

        // 4. Create Order
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setStatus("PLACED");
        order.setPaymentMode("COD");

        OrderDAO orderDAO = new OrderoDAOImpl();
        int orderId = orderDAO.saveOrder(order);

        if (orderId <= 0) {
            throw new RuntimeException("Order not saved");
        }

        // 5. Save Order Items
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

        for (CartItem item : cart.getItems()) {
            OrderItem oi = new OrderItem();
            oi.setOrderitemid(orderId);
            oi.setMenuid(item.getMenu().getMenuId());
            oi.setQuantity(item.getQuantity());
            oi.setTotalamount(
                    (int) (item.getMenu().getPrice() * item.getQuantity())
            );

            orderItemDAO.saveOrderItem(oi);
        }

        // 6. Clear cart
        session.removeAttribute("cart");

        // 7. Redirect to success page
        response.sendRedirect("orderSuccess.jsp");
    }
}
