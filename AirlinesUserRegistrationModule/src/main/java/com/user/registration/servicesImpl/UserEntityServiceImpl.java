package com.user.registration.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.AttributeNotFoundException;
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.entities.UserEntity;
import com.user.registration.exceptions.GlobalExceptions;
import com.user.registration.exceptions.ResourceNotFoundException;
import com.user.registration.helper.UserEntityDto;
import com.user.registration.repositories.UserEntityRepository;
import com.user.registration.services.UserEntityService;

@Service
public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	
	@Override
	public UserEntityDto createUser(UserEntityDto userEntityDto) {
		UserEntity dtoToUser = this.dtoToUser(userEntityDto);
		UserEntity saveEntity = this.userEntityRepository.save(dtoToUser);
		return this.userToDto(saveEntity);
	}

	@Override
	public UserEntityDto updateUser(UserEntityDto userEntityDto, Integer userId) {
		
		UserEntity UpdateuserEntity = this.userEntityRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId));
		UserEntityDto userDtoUpdate = this.modelMapper.map(UpdateuserEntity, UserEntityDto.class);
		return userDtoUpdate;
	}

	@Override
	public UserEntityDto getUser(Integer userId) {
		UserEntity getUserEntity = this.userEntityRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId));
		UserEntityDto getUserDto = this.modelMapper.map(getUserEntity, UserEntityDto.class);
		return getUserDto;
	}

	@Override
	public List<UserEntityDto> getAllUsers() {
		List<UserEntity> listOfUsers = this.userEntityRepository.findAll();
		List<UserEntityDto> listOfUserDtos = listOfUsers.stream().map(e->this.modelMapper.map(e, UserEntityDto.class)).collect(Collectors.toList());
		return listOfUserDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		UserEntity deleteUser = this.userEntityRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId",userId));
		this.userEntityRepository.delete(deleteUser);
	}
	
	public UserEntity dtoToUser(UserEntityDto userEntityDto) {
		 UserEntity userEntity = this.modelMapper.map(userEntityDto, UserEntity.class);
		return userEntity;
	}
	
	public UserEntityDto userToDto(UserEntity userEntity) {
		UserEntityDto userEntityDto = this.modelMapper.map(userEntity, UserEntityDto.class);
		return userEntityDto;
	}

	

}
