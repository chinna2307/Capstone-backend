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

import com.spring.crud.dto.OrderRequest;
import com.spring.crud.model.GetOrderedProducts;
import com.spring.crud.model.GetSingleOrder;
import com.spring.crud.model.OrderMaster;
import com.spring.crud.model.OrderMaterials;
import com.spring.crud.repository.AddToCartRepository;
import com.spring.crud.repository.GetSingleOrderedProductRepo;
import com.spring.crud.repository.OrderMasterRepository;
import com.spring.crud.repository.OrderMaterialsRepository;
import com.spring.response.APISuccessResponse;
@CrossOrigin(origins = "null", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class OrderRequestController {
	@Autowired
	AddToCartRepository addToCartRepository;
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private OrderMaterialsRepository orderMaterialsRepository;
	@Autowired
	private GetSingleOrderedProductRepo getSingleOrderedProductRepo;
	@PostMapping("/place")
	public OrderMaster placeOrder(@RequestBody OrderRequest request) {
		addToCartRepository.deleteByUserId(request.getOrderMaster().getUserID());
		 return orderMasterRepository.save(request.getOrderMaster());
	}
	@PostMapping("/placeSingle")
	public OrderMaster placeSingleOrder(@RequestBody OrderRequest request) {
		 return orderMasterRepository.save(request.getOrderMaster());
	}
	@GetMapping("/getUserOrdered/{id}")
    public ResponseEntity<APISuccessResponse> getOrderDetails(@PathVariable(value = "id") int userID){
		  APISuccessResponse responce = null;
		try {
			List<OrderMaster> productList = orderMasterRepository.findByUserID(userID);
			responce = new APISuccessResponse(HttpStatus.OK, "Get Ordered Product Successfully", productList);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/getSingleOrder")
    public ResponseEntity<APISuccessResponse> getOrderDetails(@RequestBody GetSingleOrder request){
		  APISuccessResponse responce = null;
		try {
			List<GetSingleOrder> productList = getSingleOrderedProductRepo.findOrder(request.getUserID(),request.getOr_fk());
			responce = new APISuccessResponse(HttpStatus.OK, "Get Ordered Product Successfully", productList);
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getOrderdedProducts")
	 public List<OrderMaster> getOrderdedProducts(){
		 return orderMasterRepository.findAll();
	 }
	
	
}
