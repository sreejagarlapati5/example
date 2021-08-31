package com.example.demo.Exceptionhandling;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptionclass.CustomerNotFoundException;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
	      return new ResponseEntity<>("Id not found to update", HttpStatus.NOT_FOUND);
	   }
	@ExceptionHandler(value =EmptyResultDataAccessException.class)
	   public ResponseEntity<Object> exception2(EmptyResultDataAccessException exception) {
	      return new ResponseEntity<>("Id not found to delete", HttpStatus.NOT_FOUND);
	   }
	@ExceptionHandler(value =CustomerNotFoundException.class)
	   public ResponseEntity<Object> exception3(CustomerNotFoundException exception) {
	      return new ResponseEntity<>("Customer Name Entered was not found", HttpStatus.NOT_FOUND);
	   }
	
}

