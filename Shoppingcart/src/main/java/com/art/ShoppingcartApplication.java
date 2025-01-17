package com.art;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.art.*"})
@EnableJpaRepositories("com.art.repository")
@EnableFeignClients
@EnableDiscoveryClient(autoRegister=true)

//@EnableDiscoveryClient
//@EnableFeignClients
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}

}
