package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.model.AddToCart;

public interface AddToCartRepository extends JpaRepository<AddToCart,Integer> {

}
