package com.sgic.defectTrackerDto.dto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.defectTrackerDto.dtomapper.UserDtoMapper;
import com.sgic.defectTrackerDto.dtos.UserDto;

@RestController
public class UserController {

	@Autowired
	private UserDtoMapper userDtoMapper;
	
	@PostMapping("/saveUser")
	public HttpStatus saveProject(@Valid @RequestBody UserDto userDto) {
		userDtoMapper.saveUser(userDto);
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDto> getUsers(){
		return userDtoMapper.getAllUsers();
	}
	
	@DeleteMapping("/deleteUserById/{userId}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable("userId") int userId){
		userDtoMapper.deleteUser(userId);
		return new ResponseEntity<UserDto>(HttpStatus.OK);
		
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto){
		userDtoMapper.updateUsers(userDto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.NO_CONTENT);
	}
}
