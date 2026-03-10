package com.esanchez.microservice.infrastructure.clients.dto;

public class JwtDTO {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtDTO [token=" + token + "]";
	}
}
