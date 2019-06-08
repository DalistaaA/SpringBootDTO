package com.sgic.defectTrackerDto.dtomapper;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.defectTrackerDto.dto.entities.User;
import com.sgic.defectTrackerDto.dto.services.UserService;
import com.sgic.defectTrackerDto.dtos.UserDto;

@Service
public class UserDtoMapper {

	@Autowired
	private UserService userService;
	
	ModelMapper modelmapper = new ModelMapper();
	
	PropertyMap<UserDto, User> userMap = new PropertyMap<UserDto, User>() {
		protected void configure() {
			map().setFirstName(source.getFirstName());
			map().setLastName(source.getLastName());
			map().setEmail(source.getEmail());
			map().setDesignation(source.getDesignation());
		}
	};

	@SuppressWarnings("unused")
	private UserDtoMapper EntityToDTO(User user) {
		UserDtoMapper userDTO = modelmapper.map(user, UserDtoMapper.class);
		return userDTO;
	}
	
	
	public User saveUser(UserDto userDto) {
		TypeMap<UserDto, User> typeMap = modelmapper.getTypeMap(UserDto.class, User.class );
		if(typeMap==null) {
			modelmapper.addMappings(userMap);
		}
		
		User user = modelmapper.map(userDto, User.class);
		return userService.saveUser(user);
	}
	
	public List<UserDto> getAllUsers(){
		List<User> user=userService.getUsers();
		Type listType =new TypeToken<List<UserDto>>() {}.getType();
		List<UserDto> getuser= new ModelMapper().map(user, listType);
		return getuser;
	}
	
	public UserDto deleteUser(int userId) {
		userService.deleteUserById(userId);
		return null;
	}

	public void updateUsers(UserDto userDto) {
		User user = modelmapper.map(userDto, User.class);
		EntityToDTO(userService.updateUser(user));
	}
}
