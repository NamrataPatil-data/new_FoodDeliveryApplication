//package com.app.dao.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//import com.app.dao.OrderItemDAO;
//import com.app.model.OrderItem;
//import com.app.util.DBConnection;
//
//public class OrderItemDAOImp implements OrderItemDAO {
//
//    @Override
//    public void saveOrderItem(OrderItem oi) {
//
//        String sql = "INSERT INTO order_item (order_id, menu_id, quantity, total_amount) VALUES (?, ?, ?, ?)";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, oi.getOrderid());
//            ps.setInt(2, oi.getMenuid());
//            ps.setInt(3, oi.getQuantity());
//            ps.setInt(4, oi.getTotalamount());
//
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.app.dao.OrderItemDAO;
import com.app.model.OrderItem;
import com.app.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String INSERT_ORDER_ITEM =
        "INSERT INTO order_item (orderId, menuId, totalAmount) VALUES (?, ?, ?)";

    @Override
    public void saveOrderItem(OrderItem item) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_ORDER_ITEM)) {

            ps.setInt(1, item.getOrderitemid());
            ps.setInt(2, item.getMenuid());
            ps.setDouble(3, item.getTotalamount());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
