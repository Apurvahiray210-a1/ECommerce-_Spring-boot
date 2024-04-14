package com.art.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Table(name = "admin")
public class Product {
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private String description;
    private double price;
    private String status;
    //private String imageName;
    private String imageFilename;
    //private int categoryId;
   // private int userid;
 
    
    
	
	
}
