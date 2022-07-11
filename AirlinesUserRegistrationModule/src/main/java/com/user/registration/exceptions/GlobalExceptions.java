package com.user.registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.registration.helper.ApiResponse;

@RestControllerAdvice
public class GlobalExceptions {

	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException rnfe){
		String message="No Entity Found";
		ApiResponse apiResponse = new ApiResponse(message,false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
