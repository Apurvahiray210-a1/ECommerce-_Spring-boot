package com.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.art.model.Cart;



@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	

	// Cart findByCustomerUserid(int userId);
	
	//List<Cart> findByCustomerId(int userid);
	
}
