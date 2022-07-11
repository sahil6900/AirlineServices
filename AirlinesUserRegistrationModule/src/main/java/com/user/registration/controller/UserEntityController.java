package com.user.registration.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.entities.UserEntity;
import com.user.registration.helper.ApiResponse;
import com.user.registration.helper.UserEntityDto;
import com.user.registration.services.UserEntityService;

@RestController
@RequestMapping("/user/api")
public class UserEntityController {
	
	@Autowired
	private UserEntityService userEntityService;
	
	@PostMapping("/create")
	public ResponseEntity<UserEntityDto> creatEntity(@RequestBody UserEntityDto userEntityDto){
		UserEntityDto createUser = this.userEntityService.createUser(userEntityDto);
		return new ResponseEntity<UserEntityDto>(createUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserEntityDto> updateEntity(@RequestBody UserEntityDto userEntityDto,@PathVariable Integer userId){
		UserEntityDto updateUser = this.userEntityService.updateUser(userEntityDto, userId);
		return new ResponseEntity<UserEntityDto>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntityDto> getEntity(@PathVariable Integer id){
		UserEntityDto getUser = this.userEntityService.getUser(id);
		return new ResponseEntity<UserEntityDto>(getUser,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserEntityDto>> getAllUsers(){
		List<UserEntityDto> getAllUsers = this.userEntityService.getAllUsers();
		return new ResponseEntity<List<UserEntityDto>>(getAllUsers,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
		this.userEntityService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true),HttpStatus.OK);
	}
}
