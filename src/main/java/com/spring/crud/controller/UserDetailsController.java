package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.crud.model.UserDetails;
import com.spring.crud.repository.UserDetailsRepository;
@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController 
@RequestMapping("/api")
public class UserDetailsController {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@PostMapping("/signUp")
	public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails userDetails){
		try {
			UserDetails _userDetails = userDetailsRepository
					.save(new UserDetails(userDetails.getEmail(), userDetails.getName(),userDetails.getPassword(), userDetails.getRoleID()  ));
			return new ResponseEntity<>(_userDetails, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
