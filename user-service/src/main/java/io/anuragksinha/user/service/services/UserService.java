package io.anuragksinha.user.service.services;

import java.util.List;

import io.anuragksinha.user.service.entities.User;

public interface UserService{
	//create user
	User saveUser(User user);
	//get all user
	List<User> getAllUsers();
	//get single user for a given userId
	User getUser(String userId);
	//delete User by Id
	Boolean delete(String userId);
	//update User
	User updateUser(User user);

}
