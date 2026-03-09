package com.esanchez.microservice.infrastructure.clients;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignAuthInterceptor implements RequestInterceptor {

	@Value("${auth-microservice.user}")
	private String username;

	@Value("${auth-microservice.pass}")
	private String password;

	@Override
	public void apply(RequestTemplate template) {
		if (template.url().contains("/v1/api/auth")) {
			String auth = username + ":" + password;
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
			template.header("Authorization", "Basic " + encodedAuth);
		}
	}
}
