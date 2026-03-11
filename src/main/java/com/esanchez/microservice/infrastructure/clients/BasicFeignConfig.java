package com.esanchez.microservice.infrastructure.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esanchez.microservice.infrastructure.clients.services.AuthService;

import feign.RequestInterceptor;

@Configuration
public class BasicFeignConfig {
	
	@Bean
	RequestInterceptor jwtRequestInterceptor(AuthService authService) {
		return template -> {
			
			String token = authService.getJwtToken();
			
			template.header("Authorization", "Bearer " + token);
		};
	}
}
