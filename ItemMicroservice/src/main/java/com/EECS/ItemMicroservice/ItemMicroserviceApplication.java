package com.EECS.ItemMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemMicroserviceApplication.class, args);
	}

}
