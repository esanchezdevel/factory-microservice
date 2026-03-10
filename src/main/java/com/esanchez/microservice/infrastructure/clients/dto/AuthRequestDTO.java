package com.esanchez.microservice.infrastructure.clients.dto;

public class AuthRequestDTO {

	private String username, password;
	
	public AuthRequestDTO(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public static class Builder {
		
		private String username, password;
		
		public Builder username(String username) {
			this.username = username;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public AuthRequestDTO build() {
			return new AuthRequestDTO(this);
		}
	}
}
