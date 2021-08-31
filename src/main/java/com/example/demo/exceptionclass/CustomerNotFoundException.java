package com.example.demo.exceptionclass;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String msg) {
		super(msg);
		
	}

}

