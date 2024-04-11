package com.art.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.product.model.User;
import com.art.model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartid;
   
   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;
   
   private int quantity;
   private double totalPrice; // You can calculate it in your service or repository layer
public void calculateTotalPrice() {
	// TODO Auto-generated method stub
	 if (product != null) {
         this.totalPrice = quantity * product.getPrice();
     }
}
   
   // Other fields or methods as needed
}