package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.MenuDao;
import com.app.model.Menu;
import com.app.util.DBConnection;

public class MenuDAOImpl implements MenuDao {

    private static final String GET_MENU_BY_RESTAURANT =
        "SELECT * FROM menu WHERE restaurantId = ? AND isAvailable = 1";

    private static final String GET_MENU_BY_ID =
        "SELECT * FROM menu WHERE menuId = ?";

    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_MENU_BY_RESTAURANT)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Menu m = new Menu();

                m.setMenuId(rs.getInt("menuId"));
                m.setRestaurantId(rs.getInt("restaurantId"));
                m.setItemName(rs.getString("itemName"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));
                m.setAvailable(rs.getBoolean("isAvailable"));
                m.setImagePath(rs.getString("imagePath"));

                menuList.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public Menu getMenuById(int menuId) {

        Menu m = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_MENU_BY_ID)) {

            ps.setInt(1, menuId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Menu();

                m.setMenuId(rs.getInt("menuId"));
                m.setRestaurantId(rs.getInt("restaurantId"));
                m.setItemName(rs.getString("itemName"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));
                m.setAvailable(rs.getBoolean("isAvailable"));
                m.setImagePath(rs.getString("imagePath"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return m;
    }
}

    
