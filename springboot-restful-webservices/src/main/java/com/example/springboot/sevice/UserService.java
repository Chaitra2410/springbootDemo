package com.example.springboot.sevice;

import java.util.List;

import com.example.springboot.entity.User;

public interface UserService {

	User createUser(User user);
	
	User getUserById(Long userId);
	
	 List<User> getAllUsers();
	 
	 User updateUser(User user);
	 
	 void deleteUser(long userId);
}
