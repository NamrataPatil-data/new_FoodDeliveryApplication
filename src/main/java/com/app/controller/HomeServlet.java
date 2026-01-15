package com.app.controller;

import java.io.IOException;
import java.util.List;

import com.app.dao.RestaurantDAO;
import com.app.dao.impl.RestaurantDAOImpl;
import com.app.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	@WebServlet("/HomeServlet")
	public class HomeServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        RestaurantDAO dao = new RestaurantDAOImpl();
	        List<Restaurant> restaurantList = dao.getAllRestaurants();
	        String search = request.getParameter("search");
	        if (search != null && !search.isEmpty()) {
	            Object list = dao.searchRestaurants(search);
	        }


	        request.setAttribute("restaurantList", restaurantList);
	        request.getRequestDispatcher("home.jsp").forward(request, response);
	    }
	}


