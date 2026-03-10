package com.esanchez.microservice.infrastructure.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esanchez.microservice.infrastructure.clients.services.AuthService;

import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;

@Configuration
public class BasicFeignConfig {

	private static final int RETRYER_INITIAL_INTERVAL = 100;
	private static final int RETRYER_MAX_INTERVAL = 1000;
	private static final int RETRYER_MAX_ATTEMPTS = 2;
	
	@Bean
	RequestInterceptor jwtRequestInterceptor(AuthService authService) {
		return template -> {
			
			String token = authService.getJwtToken();
			
			template.header("Authorization", "Bearer " + token);
		};
	}
	
	@Bean
	ErrorDecoder errorDecoder(AuthService authService) {
		return new JwtErrorDecoder(authService);
	}
	
	@Bean
	Retryer retryer() {
		return new Retryer.Default(RETRYER_INITIAL_INTERVAL, RETRYER_MAX_INTERVAL, RETRYER_MAX_ATTEMPTS);
	}
}
