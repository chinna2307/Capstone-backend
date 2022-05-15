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

import com.spring.crud.model.AddProduct;
import com.spring.crud.repository.AddProductRepository;
import com.spring.response.APISuccessResponse;
@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController 
@RequestMapping("/api")
public class AddProductController {
	@Autowired
	AddProductRepository addProductRepository;
	@PostMapping("/addProduct")
	public ResponseEntity<APISuccessResponse> createProduct(@RequestBody AddProduct addProduct){
		  APISuccessResponse responce = null;
		try {
			AddProduct _addProduct = addProductRepository
					.save(new AddProduct(addProduct.getCategoryID(), addProduct.getMaterialName(),addProduct.getPrice(),addProduct.getImageURL()));
			responce = new APISuccessResponse(HttpStatus.OK, "Product Added Successfully", _addProduct);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @GetMapping("/getProductByCategory/{id}")
    public ResponseEntity<APISuccessResponse> getProductByCategoryId(@PathVariable(value = "id") int categoryID){
		  APISuccessResponse responce = null;
		try {
			List<AddProduct> productList = addProductRepository.findByCategoryId(categoryID);
			responce = new APISuccessResponse(HttpStatus.OK, "Get Product Successfully", productList);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    


}
