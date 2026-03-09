package com.esanchez.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FactoryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryMicroserviceApplication.class, args);
	}

}
