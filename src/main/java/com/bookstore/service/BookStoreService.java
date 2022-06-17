package com.bookstore.service;

import org.springframework.http.ResponseEntity;

import com.bookstore.dto.UserLogin;
import com.bookstore.dto.UserRegistration;

public interface BookStoreService {

	
	public ResponseEntity<Object> login(UserLogin login);
	public ResponseEntity<Object> registerUser(UserRegistration user);
	
}
