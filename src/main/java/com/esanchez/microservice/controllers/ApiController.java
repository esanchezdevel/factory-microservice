package com.esanchez.microservice.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esanchez.microservice.application.dto.ResponseDTO;
import com.esanchez.microservice.application.exceptions.FactoryException;
import com.esanchez.microservice.application.services.CarFactoryService;
import com.esanchez.microservice.application.utils.ResponseStatus;

@RestController
@RequestMapping("/api/cars")
public class ApiController {

	private static final Logger logger = LogManager.getLogger(ApiController.class);
	
	private final CarFactoryService carFactoryService;
	
	public ApiController(CarFactoryService carFactoryService) {
		this.carFactoryService = carFactoryService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO> createCar() {
		logger.info("Create new car request");
		
		try {
			carFactoryService.createCar();
			logger.info("Car created");
			return ResponseEntity.ok(new ResponseDTO(ResponseStatus.SUCCESS.value()));
		} catch (FactoryException e) {
			logger.error("Error creating car. {}", e.getMessage());
			return ResponseEntity.status(e.getErrorCode()).body(new ResponseDTO(ResponseStatus.ERROR.value()));
		}
	}
}
