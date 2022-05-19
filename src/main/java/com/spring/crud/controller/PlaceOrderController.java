package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.GetCartMaterials;
import com.spring.crud.model.GetOrderedProducts;
import com.spring.crud.model.PlaceOrder;
import com.spring.crud.repository.PlaceOrderRepository;
import com.spring.response.APISuccessResponse;
@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController 
@RequestMapping("/api")
public class PlaceOrderController {
	@Autowired
	PlaceOrderRepository placeOrderRepository;
	@PostMapping("/placeOrder")
	public ResponseEntity<APISuccessResponse> placeOrder(@RequestBody List<PlaceOrder> placeOrder){
		  APISuccessResponse responce = null;
		try {
			placeOrderRepository.saveAll(placeOrder);
			responce = new APISuccessResponse(HttpStatus.OK, "Product Ordered Successfully", null);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getUserOrderedDetails/{id}")
    public ResponseEntity<APISuccessResponse> getOrderDetails(@PathVariable(value = "id") int userID){
		  APISuccessResponse responce = null;
		try {
			List<GetOrderedProducts> productList = placeOrderRepository.findByUserID(userID);
			responce = new APISuccessResponse(HttpStatus.OK, "Get Ordered Product Successfully", productList);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
