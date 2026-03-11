package com.esanchez.microservice.application.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.esanchez.microservice.application.exceptions.FactoryException;
import com.esanchez.microservice.application.services.CarFactoryService;
import com.esanchez.microservice.infrastructure.clients.BasicMicroserviceFeign;
import com.esanchez.microservice.infrastructure.clients.dto.CreateCarRequestDTO;
import com.esanchez.microservice.infrastructure.clients.dto.CreateCarResponseDTO;
import com.esanchez.microservice.infrastructure.clients.services.AuthService;
import com.esanchez.microservice.infrastructure.clients.services.FeignExecutorService;

@Service
public class CarFactoryServiceImpl implements CarFactoryService {

	private final static Logger logger = LogManager.getLogger(CarFactoryServiceImpl.class);
	
	private final AuthService authService;
	
	private final BasicMicroserviceFeign basicMicroserviceFeign;
	
	private final FeignExecutorService feignExecutorService;
	
	public CarFactoryServiceImpl(AuthService authService, BasicMicroserviceFeign basicMicroserviceFeign, FeignExecutorService feignExecutorService) {
		this.authService = authService;
		this.basicMicroserviceFeign = basicMicroserviceFeign;
		this.feignExecutorService = feignExecutorService;
	}
	
	@Override
	public void createCar(boolean isRetry) throws FactoryException {
		logger.info("Creating new car");
		
		authService.getJwtToken();
		
		CreateCarRequestDTO request = new CreateCarRequestDTO.Builder().brand("renault").model("laguna").build();
		
		CreateCarResponseDTO response = feignExecutorService.execute(() -> basicMicroserviceFeign.createCar(request));
		
		logger.info("Response: {}", response);
	}
}
