package com.art.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.art.model.Cart;
import com.art.model.CartItem;

import com.art.proxy.UserProxy;
import com.art.request.AddCartItemRequest;
import com.art.request.UpdateCartItemRequest;
import com.art.service.CartService;
import com.art.exception.InvalidItemException;
//import com.reg.entity.User;
import com.art.model.*;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserProxy userProxy;
	
	@PutMapping("/cart/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req, @RequestHeader("Authorization") String jwt) throws Exception{
		CartItem cartItem  = cartService.addItemToCart(req, jwt);
		return new ResponseEntity<>(cartItem, HttpStatus.OK);
	}
	@PutMapping("/cart-item/update")
	public ResponseEntity<CartItem> updateCartItemQuantity(@RequestBody UpdateCartItemRequest req, @RequestHeader("Authorization") String jwt) throws Exception{
		CartItem cartItem  = cartService.updateCartItemQuantity(req.getId(), req.getQuantity());
		return new ResponseEntity<>(cartItem, HttpStatus.OK);
	}
	@DeleteMapping("/cart-item/{id}/remove")
	public ResponseEntity<Cart> removeCartItem(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception{
		Cart cart  = cartService.removeItemFromCart(id, jwt);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
	@PutMapping("/cart/clear")
	public ResponseEntity<Cart> clearCart( @RequestHeader("Authorization") String jwt) throws Exception{
		ResponseEntity<User> user1 =  userProxy.findUserByJwtToken(jwt);
		  User user = user1.getBody();
		Cart cart  = cartService.clearCart(user.getUserid());
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
	@GetMapping("/cart")
	public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws Exception{
		ResponseEntity<User> user1 =  userProxy.findUserByJwtToken(jwt);
		User user = user1.getBody();
		Cart cart  = cartService.findCartByUserId(user.getUserid());
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
	
	@GetMapping("/cart/total")
	public Long calculateCartTotals(@RequestHeader("Authorization") String jwt) throws Exception {
		ResponseEntity<User> user1 =  userProxy.findUserByJwtToken(jwt);
		User user = user1.getBody();
		Cart cart  = cartService.findCartByUserId(user.getUserid());
		return cartService.calculateCartTotals(cart);
	}
	
	@GetMapping("/view/{id}")
	  public ResponseEntity<Product> getUserById(@PathVariable 	String id) throws InvalidItemException{
		  //return productService.getUserInProduct(userId);
		Product p=cartService.getProductById(id);
		return  new ResponseEntity<Product>(HttpStatus.OK).ok(p);
	  }




}
