package com.art.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.art.request.AddCartItemRequest;
//import com.product.model.Product;
import com.art.model.*;
//import com.art.model.product.Product;

public interface CartService {

	//CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;
	
	//CartItem updateCartItemQuantity(Long cartid, int quantity) throws Exception;
	
	//Cart removeItemFromCart(Long cartItemId) throws Exception;
	
	//Long calculateCartTotals(Cart cart) throws Exception;
	
	//public double getTotalPrice(int userid);
	
	//Cart findCartById(Long cartid) throws Exception;
	
	//Cart findCartByUserId(int userid) throws Exception;
	
	//Cart clearCart(int userid) throws Exception;
	//void  addProductToCart(long cartid,String id,int quantity );
	
	//Product getProductById(String id) throws InvalidItemException;
		//Product getProductById(String productId);
	 /*Product getProductById(@PathVariable int id);

	    void removeProductFromCart(long cartid);

	    void addProductToCart(long cartId, int id, int quantity);

	    void updateCart(long cartId, int id, int quantity);
	    
	    public List<Cart> getUserCart(int id,int userid);


	    List<Cart> displayUserCart();

	    double getTotalPrice(int id);*/
	
	Cart addProductToCart(Cart cart);


	 public List<Cart> getAllProductInCart();
	 
	 public String deleteProductFromCart(int cartId);
	 
	  public void updateCart(int cartId,int id,int quantity,Cart cart);
	  
	  public Product getProductById( int id);
	 
	
	
	
}
