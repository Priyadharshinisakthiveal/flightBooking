package com.flight;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {IllegalArgumentException.class, NoSuchElementException.class, EmptyResultDataAccessException.class,EntityNotFoundException.class})
	public ResponseEntity<Object> IAExceptionHandler(Exception e , WebRequest request){
		String msg = "Error in input\n" + e.getMessage();
		return handleExceptionInternal(e,msg,new HttpHeaders(),HttpStatus.CONFLICT, request);
	}
	
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,HttpStatus status,WebRequest request){
		List<String> errorlist = e.getBindingResult().getAllErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage())
				.collect(Collectors.toList());
		System.out.println("in exception " + errorlist);
		return handleExceptionInternal(e,errorlist,headers,HttpStatus.BAD_REQUEST,request);
	}

}
