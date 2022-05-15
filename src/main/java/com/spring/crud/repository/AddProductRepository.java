package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.crud.model.AddProduct;

public interface AddProductRepository extends JpaRepository<AddProduct,Integer>{
	@Query("select m from AddProduct m where m.categoryID = ?1")
    List<AddProduct> findByCategoryId(int categoryID);
}
