package com.esanchez.microservice.infrastructure.clients;

import org.springframework.http.HttpStatus;

import com.esanchez.microservice.infrastructure.clients.services.AuthService;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class JwtErrorDecoder implements ErrorDecoder {

	private final AuthService authService;
	private final ErrorDecoder defaultDecoder = new Default();

	public JwtErrorDecoder(AuthService authService) {
		this.authService = authService;
	}

	@Override
	public Exception decode(String methodKey, Response response) {

		if (response.status() == HttpStatus.UNAUTHORIZED.value()) {

			authService.invalidateToken();

			return new RetryableException(response.status(), 
											"JWT expired", 
											response.request().httpMethod(), 
											(Long) null, 
											response.request());
		}

		return defaultDecoder.decode(methodKey, response);
	}
}
