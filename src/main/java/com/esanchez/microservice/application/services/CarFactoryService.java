package com.esanchez.microservice.application.services;

import com.esanchez.microservice.application.exceptions.FactoryException;

public interface CarFactoryService {

	/**
	 * Create a new car executing a POST request to the 
	 * basic-microservice
	 * 
	 * @throws FactoryException
	 */
	void createCar() throws FactoryException;
}
