package com.art.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.art.model.User;



@FeignClient(name="USER-SERVICE" , url="http://localhost:3306")
public interface UserProxy {

	

	
	
	
	
	
	 @GetMapping("/getUserById/{userId}")
	    public ResponseEntity<?> getUserById(@PathVariable int userId);
	
}
