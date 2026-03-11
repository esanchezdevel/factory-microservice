package com.esanchez.microservice.infrastructure.clients.services;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.esanchez.microservice.application.exceptions.FactoryException;

import feign.FeignException;

@Service
public class FeignExecutorService {

	private static final Logger logger = LogManager.getLogger(FeignExecutorService.class);
	
	private static final int MAX_RETRY_ATTEMPTS = 1;
	
	private final AuthService authService;
	
	public FeignExecutorService(AuthService authService) {
		this.authService = authService;
	}
	
	public <T> T execute(Supplier<T> function) throws FactoryException {
		
		T response = null;
		
		for (int attempt = 0; attempt <= MAX_RETRY_ATTEMPTS; attempt++) {
			logger.info("Request attempt: {}", attempt);
			try {
				response = function.get();
				
				break;
			} catch (FeignException e) {
				logger.error("Error creating car: {}", e.getMessage());
				
				if (e.status() != HttpStatus.UNAUTHORIZED.value() || (e.status() == HttpStatus.UNAUTHORIZED.value()) && attempt == 1) {
					throw new FactoryException(e.status(), e.getMessage());
				}
				
				logger.info("Invalidate token to request a new JWT for the retry");
				authService.invalidateToken();
			}			
		}
		return response;
	}
}
