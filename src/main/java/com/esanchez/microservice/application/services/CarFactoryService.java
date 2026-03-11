package com.esanchez.microservice.application.services;

import com.esanchez.microservice.application.exceptions.FactoryException;

public interface CarFactoryService {

	/**
	 * Create a new car executing a POST request to the 
	 * basic-microservice
	 * 
	 * @param isRetry Indicate if the request is a retry after one unauthorized error.
	 * @throws FactoryException
	 */
	void createCar(boolean isRetry) throws FactoryException;
}
