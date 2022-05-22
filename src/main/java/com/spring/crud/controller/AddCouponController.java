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
import com.spring.crud.repository.AddCouponRepository;
import com.spring.response.APISuccessResponse;


@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController 
@RequestMapping("/api")
public class AddCouponController {
	@Autowired
	AddCouponRepository addCouponRepository;
	@PostMapping("/addCoupon")
	public ResponseEntity<APISuccessResponse> createCoupon(@RequestBody AddCoupon addCoupon){
		  APISuccessResponse responce = null;
		try {
			AddCoupon _addCoupon = addCouponRepository
					.save(new AddCoupon(addCoupon.getCouponID(), addCoupon.getCouponName(),addCoupon.getCouponCode(),addCoupon.getDiscount()));
			responce = new APISuccessResponse(HttpStatus.OK, "Coupon Added Successfully", _addCoupon);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getCoupon")
    public ResponseEntity<APISuccessResponse> getCoupon(){
		  APISuccessResponse responce = null;
		try {
			List<AddCoupon> couponList = addCouponRepository.findAll();
			responce = new APISuccessResponse(HttpStatus.OK, "Get Coupon Successfully", couponList);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteCoupon/{id}")
    public ResponseEntity<APISuccessResponse> deleteCoupon(@PathVariable(value = "id") int couponID){
		  APISuccessResponse responce = null;
		try {
			
			addCouponRepository.deleteById(couponID);
			responce = new APISuccessResponse(HttpStatus.OK, "Coupon deleted Successfully", null);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
