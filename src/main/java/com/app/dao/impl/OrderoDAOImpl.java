package com.app.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.app.dao.OrderDAO;
import com.app.model.Order;
import com.app.util.DBConnection;

public class OrderoDAOImpl implements OrderDAO {

    private static final String INSERT_ORDER =
        "INSERT INTO orders (userId, orderDate, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?)";

    @Override
    public int saveOrder(Order order) {

        int orderId = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     INSERT_ORDER,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserId());
            ps.setTimestamp(2, order.getOrderDate());
            ps.setDouble(3, order.getTotalAmount());
            ps.setString(4, order.getStatus());
            ps.setString(5, order.getPaymentMode());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderId;
    }

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
