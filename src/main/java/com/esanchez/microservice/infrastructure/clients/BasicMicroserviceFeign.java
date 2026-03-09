package com.esanchez.microservice.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import feign.Body;

@FeignClient(
		name = "basic-microservice",
		url = "${basic-microservice.url}",
		configuration = FeignAuthInterceptor.class)
public interface BasicMicroserviceFeign {

	@PostMapping("/v1/api/cars")
	CarDTO createCar(@Body CarDTO car);
}
