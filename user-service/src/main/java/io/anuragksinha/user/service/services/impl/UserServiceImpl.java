package io.anuragksinha.user.service.services.impl;

import java.util.List;
import java.util.UUID;

import io.anuragksinha.user.service.entities.User;
import io.anuragksinha.user.service.exceptions.ResourceNotFoundException;
import io.anuragksinha.user.service.repositories.UserRepository;
import io.anuragksinha.user.service.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		//generate unique userId
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(()->
				new ResourceNotFoundException("User with given id is not found on server!!"+userId));
	}

	@Override
	public Boolean delete(String userId) {
		return null;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}
}
