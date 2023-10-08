package com.skeleton.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeleton.app.domain.User;
import com.skeleton.app.exception.ResourceNotFoundException;
import com.skeleton.app.repository.UserRepository;
import com.skeleton.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with id : " + user.getId()));

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {

		Optional<User> userdb = this.userRepository.findById(userId);

		if (userdb.isPresent()) {
			return userdb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	@Override
	public void deleteUser(long userId) {
		userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with id : " + userId));

		this.userRepository.deleteById(userId);

	}

}