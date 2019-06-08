package com.sgic.defectTrackerDto.dto.services;

import java.util.List;

import com.sgic.defectTrackerDto.dto.entities.User;

public interface UserService {

	User saveUser(User user);

	List<User> getUsers();
	
	User getUserById(int userId);
	
	void deleteUserById(int userId);
	
	User updateUser(User user);
}
