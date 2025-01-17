package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.product.repository")
@EnableDiscoveryClient(autoRegister=true)
//@ComponentScan("com.reg.*")

//@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.product.*"})
public class ProductManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementBackendApplication.class, args);
	} 

}
