package com.spring.crud.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.AddCoupon;
import com.spring.crud.model.AddProduct;
import com.spring.crud.model.AddToCart;
import com.spring.crud.repository.AddCouponRepository;
import com.spring.crud.repository.AddToCartRepository;
import com.spring.response.APISuccessResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController 
@RequestMapping("/api")
public class AddtoCartController {
	@Autowired
	AddToCartRepository addToCartRepository;
	@PostMapping("/addToCart")
	public ResponseEntity<APISuccessResponse> createCoupon(@RequestBody AddToCart addToCart){
		  APISuccessResponse responce = null;
		try {
			AddToCart _addToCart = addToCartRepository
					.save(new AddToCart(addToCart.getCartID(),addToCart.getMaterialID(),addToCart.getUserID()));
			responce = new APISuccessResponse(HttpStatus.OK, "Product Added in Cart Successfully", _addToCart);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
