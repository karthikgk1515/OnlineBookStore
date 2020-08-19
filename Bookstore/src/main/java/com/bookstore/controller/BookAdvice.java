package com.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bookstore.exception.ErrorMessage;
import com.bookstore.exception.NotFoundException;


@RestControllerAdvice
public class BookAdvice {


	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<ErrorMessage> handleException(Exception ex) {
		ErrorMessage exceptionresponse= new ErrorMessage(ex.getMessage(), " Something went wrong, please enter correct details");
		return new ResponseEntity<>(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NotFoundException.class})
	public ResponseEntity<ErrorMessage> handleException1(NotFoundException ex) {
		ErrorMessage exceptionresponse= new ErrorMessage(ex.getMessage(), " Something went wrong, please enter correct details");
		return new ResponseEntity<>(exceptionresponse,HttpStatus.BAD_REQUEST);
	}	
	}

