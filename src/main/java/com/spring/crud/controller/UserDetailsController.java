package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

import com.spring.crud.model.UserDetails;
import com.spring.crud.repository.UserDetailsRepository;
import com.spring.response.APISuccessResponse;
@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController 
@RequestMapping("/api")
public class UserDetailsController {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@PostMapping("/signUp")
	public ResponseEntity<APISuccessResponse> createUserDetails(@RequestBody UserDetails userDetails){
		  APISuccessResponse responce = null;
		try {
			UserDetails _userDetails = userDetailsRepository
					.save(new UserDetails(userDetails.getEmail(), userDetails.getName(),userDetails.getRoleID(),userDetails.getPassword()));
			responce = new APISuccessResponse(HttpStatus.OK, "User Created", _userDetails);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 @PostMapping("/login")
	    public ResponseEntity<APISuccessResponse> loginUser(@Valid @RequestBody UserDetails userDetails) {
		 	APISuccessResponse responce = null;
	        List<UserDetails> users = userDetailsRepository.findAll();
	        for (UserDetails other : users) {
	        	
	            if (other.getEmail().equals(userDetails.getEmail()) && 
	            		other.getPassword().equals(userDetails.getPassword())) {
	            	userDetailsRepository.findByEmail(other.getEmail());
	            	responce = new APISuccessResponse(HttpStatus.OK, "Get Login User Detail", userDetailsRepository.findByEmail(other.getEmail()));
	                return new ResponseEntity<>(responce, HttpStatus.CREATED);
	            } else if (other.getEmail().equals(userDetails.getEmail()) && 
	            		!other.getPassword().equals(userDetails.getPassword())) {
	            	return new ResponseEntity<>(responce, HttpStatus.CREATED);
	            }
	        }
	        return new ResponseEntity<>(responce, HttpStatus.CREATED);
	    }
	 
	
	
}
