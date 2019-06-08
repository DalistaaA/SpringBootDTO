package com.sgic.defectTrackerDto.dto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.defectTrackerDto.dto.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUserId(int userId);
}
