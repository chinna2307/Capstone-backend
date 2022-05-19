package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.crud.model.GetOrderedProducts;
import com.spring.crud.model.PlaceOrder;

public interface PlaceOrderRepository extends JpaRepository<PlaceOrder,Integer> {
	@Query("select a,m from GetOrderedProducts a "
			+ "inner join AddProduct m on m.materialID = a.materialID where a.userID = ?1")
    List<GetOrderedProducts> findByUserID(int userID);
}
