package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.crud.model.GetSingleOrder;
import com.spring.crud.model.OrderMaterials;

public interface GetSingleOrderedProductRepo extends JpaRepository<GetSingleOrder, Integer> {
	@Query("select a,m from GetSingleOrder a inner join AddProduct m on m.materialID = a.materialID where a.userID = ?1 and a.or_fk = ?2")
    List<GetSingleOrder> findOrder(int userID, int orderID);
}
