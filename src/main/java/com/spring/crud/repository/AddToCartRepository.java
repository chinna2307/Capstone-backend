package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring.crud.model.AddToCart;
import com.spring.crud.model.GetCartMaterials;

public interface AddToCartRepository extends JpaRepository<AddToCart,Integer> {
	@Query("select a,m from GetCartMaterials a "
			+ "inner join AddProduct m on m.materialID = a.materialID where a.userID = ?1")
    List<GetCartMaterials> findByUserID(int userID);
	@Transactional
	@Modifying
    @Query("delete from AddToCart u where u.userID = ?1")
    void deleteByUserId(int userID);	
}
