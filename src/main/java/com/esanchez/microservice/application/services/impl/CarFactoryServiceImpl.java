package com.esanchez.microservice.application.services.impl;

import org.springframework.stereotype.Service;

import com.esanchez.microservice.application.exceptions.FactoryException;
import com.esanchez.microservice.application.services.CarFactoryService;

@Service
public class CarFactoryServiceImpl implements CarFactoryService {

	@Override
	public void createCar() throws FactoryException {
		// TODO Call to basic-microservice using OpenFeign
		
	}
}
