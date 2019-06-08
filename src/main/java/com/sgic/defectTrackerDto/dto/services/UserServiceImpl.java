package com.sgic.defectTrackerDto.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.defectTrackerDto.dto.entities.User;
import com.sgic.defectTrackerDto.dto.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findUserByUserId(userId);
	}

	@Override
	public void deleteUserById(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
