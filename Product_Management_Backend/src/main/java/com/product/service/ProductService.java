package com.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.model.Product;

public interface ProductService {

 public Product saveProduct(Product product);
 public List<Product>getAllProduct();
 public Product getProductById(int id);
 public String deleteProduct(int id);
 public Product updateProduct(Product product,int id);
//public List<Product>getProductByCategoryId(int categoryId);
//public ResponseEntity<?> getUserById(int userId);
}
