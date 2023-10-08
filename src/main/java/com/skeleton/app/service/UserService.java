package com.skeleton.app.service;

import java.util.List;

import com.skeleton.app.domain.User;

public interface UserService {

	User createUser(User user);

	User updateUser(User user);

	List<User> getAllUsers();

	User getUserById(long userId);

	void deleteUser(long userId);

}
