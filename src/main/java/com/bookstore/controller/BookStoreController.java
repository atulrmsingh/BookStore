package com.bookstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dto.UserLogin;
import com.bookstore.dto.UserRegistration;
import com.bookstore.response.ResponseHandler;
import com.bookstore.service.BookStoreService;

@RestController
@RequestMapping("/books")
public class BookStoreController {

	@Autowired
	BookStoreService bookService;

	Logger logger = LoggerFactory.getLogger(BookStoreController.class);

	@PostMapping("/registerUser")
	public ResponseEntity<Object> registerUser(@RequestBody UserRegistration user) {
		try {
			logger.info("Start of registerUser API >> Request >> " + user);
			ResponseEntity<Object> response = bookService.registerUser(user);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in registerUser API >> Error Message >> " + e.getMessage());
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLogin user) {
		try {
			logger.info("Start of login API >> Request >> " + user);
			ResponseEntity<Object> response = bookService.login(user);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in login API >> Error Message >> " + e.getMessage());
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
		}
	}

}
