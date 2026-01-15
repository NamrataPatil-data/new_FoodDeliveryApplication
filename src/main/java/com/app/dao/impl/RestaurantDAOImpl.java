package com.app.dao.impl;

import com.app.dao.RestaurantDAO;
import com.app.model.Restaurant;
import com.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {

    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> list = new ArrayList<>();
        String sql = "SELECT restaurantId, name, address, imagePath, rating FROM restaurant";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setRestaurantId(rs.getInt("restaurantId"));
                r.setName(rs.getString("name"));
                r.setLocation(rs.getString("address"));
                r.setImagePath(rs.getString("imagePath"));
                r.setRating(rs.getDouble("rating"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ THIS MUST MATCH INTERFACE EXACTLY
    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        Restaurant r = null;
        String sql = "SELECT * FROM restaurant WHERE restaurantId=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Restaurant();
                r.setRestaurantId(rs.getInt("restaurantId"));
                r.setName(rs.getString("name"));
                r.setLocation(rs.getString("address"));
                r.setImagePath(rs.getString("imagePath"));
                r.setRating(rs.getDouble("rating"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }

	@Override
	public Object searchRestaurants(String search) {
		// TODO Auto-generated method stub
		return null;
	}
}
