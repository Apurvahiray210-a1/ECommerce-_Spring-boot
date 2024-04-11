package com.art.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCartItemRequest {

	private String id;
	
	private int quantity;

	public String getProductId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
