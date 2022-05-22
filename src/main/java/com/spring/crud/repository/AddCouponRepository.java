package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.crud.model.AddCoupon;

public interface AddCouponRepository extends JpaRepository<AddCoupon,Integer> {

}
