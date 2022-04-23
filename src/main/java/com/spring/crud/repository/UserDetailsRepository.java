package com.spring.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.crud.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

}
