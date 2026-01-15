package com.app.dao;

import com.app.model.Restaurant;
import java.util.List;

public interface RestaurantDAO {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(int restaurantId); // ✅ MUST EXIST

	Object searchRestaurants(String search);
}
