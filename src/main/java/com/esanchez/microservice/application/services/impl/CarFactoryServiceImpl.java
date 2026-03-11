package com.esanchez.microservice.application.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.esanchez.microservice.application.exceptions.FactoryException;
import com.esanchez.microservice.application.services.CarFactoryService;
import com.esanchez.microservice.infrastructure.clients.BasicMicroserviceFeign;
import com.esanchez.microservice.infrastructure.clients.dto.CreateCarRequestDTO;
import com.esanchez.microservice.infrastructure.clients.dto.CreateCarResponseDTO;
import com.esanchez.microservice.infrastructure.clients.services.AuthService;

import feign.FeignException;

@Service
public class CarFactoryServiceImpl implements CarFactoryService {

	private final static Logger logger = LogManager.getLogger(CarFactoryServiceImpl.class);
	
	private final AuthService authService;
	
	private final BasicMicroserviceFeign basicMicroserviceFeign;
	
	public CarFactoryServiceImpl(AuthService authService, BasicMicroserviceFeign basicMicroserviceFeign) {
		this.authService = authService;
		this.basicMicroserviceFeign = basicMicroserviceFeign;
	}
	
	@Override
	public void createCar(boolean isRetry) throws FactoryException {
		logger.info("Creating new car");
		
		authService.getJwtToken();
		
		CreateCarRequestDTO request = new CreateCarRequestDTO.Builder().brand("renault").model("laguna").build();
		
		try {
			CreateCarResponseDTO response = basicMicroserviceFeign.createCar(request);
			logger.info("Response: {}", response);
		} catch (FeignException e) {
			logger.error("Error creating car: {}", e.getMessage());
			
			if (e.status() != HttpStatus.UNAUTHORIZED.value() || (e.status() == HttpStatus.UNAUTHORIZED.value() && isRetry)) {
				throw new FactoryException(e.status(), e.getMessage());
			}
			
			logger.info("Retry request asking for a new JWT");
			authService.invalidateToken();
			createCar(true);
		}
	}
}
