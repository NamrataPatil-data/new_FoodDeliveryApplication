package com.app.controller;

import java.io.IOException;

import com.app.dao.impl.MenuDAOImpl;
import com.app.model.Cart;
import com.app.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        String menuIdStr = request.getParameter("menuId");

        if(action != null && menuIdStr != null){
            int menuId = Integer.parseInt(menuIdStr);
            Menu menu = new MenuDAOImpl().getMenuById(menuId);

            if(action.equals("add")) cart.addItem(menu);
            if(action.equals("plus")) cart.increase(menuId);
            if(action.equals("minus")) cart.decrease(menuId);
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
