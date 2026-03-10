package com.esanchez.microservice.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.esanchez.microservice.infrastructure.clients.dto.AuthRequestDTO;
import com.esanchez.microservice.infrastructure.clients.dto.AuthResponseDTO;

@FeignClient(
		name = "auth-microservice",
		url = "${auth-microservice.url}"
		)
public interface AuthMicroserviceFeign {

	@PostMapping(value = "/v1/api/auth/login", consumes = "application/json", produces = "application/json")
	AuthResponseDTO authenticate(@RequestBody AuthRequestDTO request);
}
