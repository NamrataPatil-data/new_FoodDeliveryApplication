////package com.app.dao.impl;
//
////import java.sql.Connection;
////im/port java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.app.dao.OrderDAO;
//import com.app.model.Order;
//import com.app.util.DBConnection;
//
//public class old-OrderDAOImpl implements OrderDAO {
//
//    @Override
//    public int saveOrder(Order order) {
//        int orderId = 0;
//
//        String sql = "INSERT INTO orders (user_id, order_date, total_amount, status, payment_mode) VALUES (?, ?, ?, ?, ?)";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            ps.setInt(1, order.getUserId());
//            ps.setTimestamp(2, order.getOrderDate());
//            ps.setDouble(3, order.getTotalAmount());
//            ps.setString(4, order.getStatus());
//            ps.setString(5, order.getPaymentMode());
//
//            ps.executeUpdate();
//
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                orderId = rs.getInt(1);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return orderId;
//    }
//
//    @Override
//    public List<Order> getOrdersByUserId(int userId) {
//        List<Order> orders = new ArrayList<>();
//
//        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, userId);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Order order = new Order();
//                order.setOrderId(rs.getInt("order_id"));
//                order.setUserId(rs.getInt("user_id"));
//                order.setTotalAmount(rs.getDouble("total_amount"));
//                order.setOrderDate(rs.getTimestamp("order_date"));
//                order.setStatus(rs.getString("status"));
//                order.setPaymentMode(rs.getString("payment_mode"));
//
//                orders.add(order);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return orders;
//    }
//}
