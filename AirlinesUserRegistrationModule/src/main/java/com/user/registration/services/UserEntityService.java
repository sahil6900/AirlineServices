package com.user.registration.services;

import java.util.List;

import com.user.registration.helper.UserEntityDto;

public interface UserEntityService {
	UserEntityDto createUser(UserEntityDto userEntityDto);
	
	UserEntityDto updateUser(UserEntityDto userEntityDto,Integer userId);
	
	UserEntityDto getUser(Integer userId);
	
	List<UserEntityDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
