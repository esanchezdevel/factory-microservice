package com.esanchez.microservice.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
		name = "auth-microservice",
		url = "${auth-microservice.url}"
		)
public interface AuthMicroserviceFeign {

	@PostMapping("/v1/api/auth")
	AuthResponse authenticate();
}
