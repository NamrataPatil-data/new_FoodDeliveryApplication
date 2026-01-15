package com.app.model;

public class Restaurant {

    private int restaurantId;
    private String name;
    private String location;
    private String imagePath;
    private double rating;

    // ✅ Constructors
    public Restaurant() {}

    public Restaurant(int restaurantId, String name, String location,
                      String imagePath, double rating) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.imagePath = imagePath;
        this.rating = rating;
    }

    // ✅ Getters & Setters
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 🔥 THIS WAS MISSING
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    private int deliveryTime;

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
