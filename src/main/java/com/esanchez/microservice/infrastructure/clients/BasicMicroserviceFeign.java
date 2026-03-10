package com.esanchez.microservice.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.esanchez.microservice.infrastructure.clients.dto.CreateCarRequestDTO;
import com.esanchez.microservice.infrastructure.clients.dto.CreateCarResponseDTO;

@FeignClient(
		name = "basic-microservice",
		url = "${basic-microservice.url}",
		configuration = BasicFeignConfig.class
		)
public interface BasicMicroserviceFeign {

	@PostMapping(value = "/v1/api/cars", consumes = "application/json", produces = "application/json")
	CreateCarResponseDTO createCar(@RequestBody CreateCarRequestDTO request);
}
