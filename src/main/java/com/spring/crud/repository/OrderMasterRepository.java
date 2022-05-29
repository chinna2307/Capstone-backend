package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.crud.model.GetOrderedProducts;
import com.spring.crud.model.OrderMaster;
import com.spring.crud.model.OrderMaterials;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {
	@Query("select a from OrderMaster a where a.userID = ?1")
    List<OrderMaster> findByUserID(int userID);
	
}
