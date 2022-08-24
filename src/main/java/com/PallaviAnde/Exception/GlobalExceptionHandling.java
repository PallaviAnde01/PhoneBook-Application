package com.PallaviAnde.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgNotValidException(MethodArgumentNotValidException e){
		Map<String,String> map=new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach((error)->{
			String field = ((FieldError) error).getField();
			 String message = error.getDefaultMessage();
			 map.put(field, message);
		});
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resorceNotFoundExceptionhandler(ResourceNotFoundException e){
		String message = e.getMessage();
		ApiResponse api=new ApiResponse(message,false);
		
		return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
		}
}
