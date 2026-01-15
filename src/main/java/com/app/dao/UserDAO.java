package com.app.dao;

import com.app.model.User;

public interface UserDAO {
    User login(String email, String password);
    boolean register(User user);
	User getUserByEmailId(String email);
}
