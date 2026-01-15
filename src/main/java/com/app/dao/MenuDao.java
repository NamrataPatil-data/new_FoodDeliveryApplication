package com.app.dao;

import java.util.List;

import com.app.model.Menu;

public interface MenuDao {

    List<Menu> getMenuByRestaurantId(int restaurantId);

    Menu getMenuById(int menuId);
}
