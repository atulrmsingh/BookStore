package com.bookstore.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bookstore.dao.BookStoreRepo;
import com.bookstore.dto.UserLogin;
import com.bookstore.dto.UserRegistration;
import com.bookstore.entity.UserEntity;
import com.bookstore.response.ResponseHandler;

@Service
public class BookStoreServiceImpl implements BookStoreService {
	
	@Value("${user_add}")
	private String userAdd;

	@Value("${userNotFound}")
	private String userNotFound;
	
	@Value("${userFound}")
	private String userFound;
	
	@Value("${emailExist}")
	private String emailExist;
	
	@Autowired
	BookStoreRepo bookRepo;
	
	ModelMapper map = new ModelMapper();
	
	@Override
	public ResponseEntity<Object> login(UserLogin login) {
		UserEntity user = bookRepo.findByUserName(login.getUserName()).orElse(null);
		if(user.getPassword().equals(login.getPassword())) {
			return ResponseHandler.generateObjectResponse(userFound, HttpStatus.OK,user);
		}else {
			return ResponseHandler.generateResponse(userNotFound, HttpStatus.OK);
		}
	}
	@Override
	public ResponseEntity<Object> registerUser(UserRegistration user) {
		UserEntity userEntity = bookRepo.findByUserName(user.getUserName()).orElse(null);
		UserEntity user1 = map.map(user, UserEntity.class);
		bookRepo.save(user1);
		return ResponseHandler.generateObjectResponse(userAdd, HttpStatus.OK, user1);		
	}

}
