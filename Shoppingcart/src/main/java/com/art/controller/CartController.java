package com.art.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.art.proxy.UserProxy;
import com.art.request.AddCartItemRequest;
import com.art.request.UpdateCartItemRequest;
import com.art.service.CartService;
import com.art.service.CartServiceImpl;
//import com.art.model.CartItem;
//import com.reg.entity.User;
import com.art.model.*;
//import com.art.model.product.Product;

@RestController
@RequestMapping("/api")
public class CartController {

	
	@Autowired
		private CartServiceImpl cartService;
		@PostMapping("/addToCart")
		public Cart addProductToCart(@RequestBody Cart cart) {
			return cartService.addProductToCart(cart);
			
		}
		
		@GetMapping("/getAllProductsInCart")
	    public List<Cart> getAllProductsInCart() {
	        return cartService.getAllProductInCart();
	    }
		
		@DeleteMapping("/deleteProductFromCart/{cartId}")
	    public String deleteProductFromCart(@PathVariable int cartId) {
	        return cartService.deleteProductFromCart(cartId);
	    }
		

		@PutMapping("/updateCart/{cartId}/{productId}/{quantity}")
	    public void updateCart(@PathVariable int cartId,
	                           @PathVariable int productId,
	                           @PathVariable int quantity,
	                           @RequestBody Cart cart) {
	        cartService.updateCart(cartId, productId, quantity, cart);
	    }
		
		@GetMapping("/getProductById/{id}")
		  public Product getProductById(@PathVariable int id)
		  {
			return cartService.getProductById(id);
		  }

	}





