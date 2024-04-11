package com.art.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.art.proxy.ProductProxy;
//import com.art.proxy.UserProxy;

import com.art.repository.CartRepository;
import com.art.request.AddCartItemRequest;
import com.product.external.services.UserService;
import com.art.exception.CartNotFoundException;
import com.art.exception.ResourceNotFound;
import com.art.model.*;


@Service
public class CartServiceImpl implements CartService {
    
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
    
    @Autowired
    private CartRepository cartRepository;
    
   
    
   //@Autowired
   // private UserProxy userProxy;
    
    @Autowired
    private ProductProxy productProxy;
    
   // @Autowired
  // private  UserProxy userservice;
    
   
    
    

   
   /* @Override
    
    public Product getProductById(@PathVariable int id) {
        try {
            logger.info("Fetching product with ID: {}", id);
            Product responseEntity = productProxy.getProductById(id);
            return responseEntity;
        } catch (Exception e) {
            logger.error("Error occurred while fetching product with ID: {}", id, e);
            throw new CartNotFoundException("Product with ID " + id + " not found");
        }
    }



   
    public void addProductToCart(long cartId, int id, int quantity) {
        try {
            logger.info("Adding product with ID {} to cart with ID {}", id, cartId);
            Product product = getProductById(id); // Assuming getProductById(int id) method is available

            Cart cart = new Cart();
            cart.setCartid(cartId);
            cart.setProduct(product);
            cart.setQuantity(quantity);
            cart.setTotalPrice(quantity);

            cartRepository.save(cart);
            logger.info("Product added to cart successfully");
        } catch (CartNotFoundException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error occurred while adding product to cart", e);
            throw new CartNotFoundException("Failed to add product to cart");
        }
    }

    @Override
    public void removeProductFromCart(int id) {
        Optional<Cart> optionalCart = cartRepository
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cartRepository.delete(cart);
        } else {
            throw new CartNotFoundException("Product with ID " + id + " not found in the cart");
        }
    }

    @Override
    public List<Cart> displayUserCart() {
        return cartRepository.findAll();
    }
}

    @Override
    public void updateCart(int cartId, String productId, int quantity) {
        Optional<Cart> optionalCart = repo.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            if (cart.getProduct().getProductId().equals(productId)) {
                cart.setQuantity(quantity);
                cart.calculateTotalPrice(); // Recalculate total price based on quantity
                repo.save(cart);
                logger.info("Cart updated successfully");
            } else {
                throw new CartNotFoundException("Product with ID " + productId + " not found in the cart");
            }
        } else {
            throw new CartNotFoundException("Cart with ID " + cartId + " not found");
        }
    }

    @Override
    public List<Cart> getUserCart(String productId) {
        Optional<Cart> optionalCart = repo.findByProductProductId(productId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.calculateTotalPrice();
            return Collections.singletonList(cart);
        } else {
            String msg = "Cart not found for productId: " + productId;
            logger.error(msg);
            throw new CartNotFoundException(msg);
        }
    }


    @Override
    public double getTotalPrice(int id) {
        Optional<Cart> optionalCart = repo.findByProductProductId(productId);
        
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            return cart.getTotalPrice();
        } else {
            String msg = "Cart not found for productId: " + productId;
            logger.error(msg);
            throw new CartNotFoundException(msg);
        }
    }

    public ResponseEntity<?> getUserInProduct(int userId){
		return userservice.getUserById(userId);
}*/

	private Logger logger1=LoggerFactory.getLogger(CartServiceImpl .class);
	@Override
	public Cart addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}
/*
	
	public void addToCart(String productId,int cartId) {
		ResponseEntity<Product>productResponse=restTemplate.getForEntity("http://8080/product/{productId}", Product.class, productId);
	   Product product=productResponse.getBody();
	   Cart cart=new Cart();
	   //Cart cart1 = retrieveShoppingCartFromAnotherMicroservice(cartId);

       // Add the fetched product to the shopping cart
       cart.setProduct(product);

       // Update the shopping cart in your microservice
       updateShoppingCartInYourMicroservice(cart);
   }

	  public void updateShoppingCartInYourMicroservice(Cart cart) {
	        // Fetch the existing shopping cart from the repository
	        Cart existingCart = cartRepo.findById(cart.getCartId()).orElse(null);

	        if (existingCart != null) {
	            // Update the existing cart with the new data
	            existingCart.setCartItems(cart.getCartItems()); // Assuming Cart has a method to set items

	            // Save the updated shopping cart
	            cartRepo.save(existingCart);
	        } else {
	        	System.out.println("Car is empty");
	            // Handle error: cart not found
	            // You can choose to throw an exception, log an error, or handle it in another way
	        }
	    }

*/

	@Override
	public List<Cart> getAllProductInCart() {
		
		return cartRepository.findAll();
	}
	
	public String deleteProductFromCart(String cartId) {
		///Cart cart=cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", cartId));;;
		Cart cart=cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFound("Product", "Product Id", cartId));
		if(cart!=null) {
			cartRepository.deleteById(cartId);
			return "Product Deleted Successfully";
		}
		return "Something wrong on server";
		}
	
	
	public void updateCart(String cartId, String productId, int quantity) {
	    Optional<Cart> optionalCart = cartRepository.findById(cartId);
	    if (optionalCart.isPresent()) {
	        Cart cart = optionalCart.get();
	        if (cart.getProduct().equals(productId)) {
	            cart.setQuantity(quantity);
	            
	            
	            cartRepository.save(cart);
	            logger.info("Cart updated successfully");
	        } else {
	            throw new ResourceNotFound("Cart", "ProductId", productId);
	        }
	    } else {
	        throw new ResourceNotFound("Cart", "CartId", cartId);
	    }
	}
	
	
}
