package com.app.dao;

import java.util.List;
import com.app.model.Order;

public interface OrderDAO {

    int saveOrder(Order order);

    List<Order> getOrdersByUserId(int userId);
}
