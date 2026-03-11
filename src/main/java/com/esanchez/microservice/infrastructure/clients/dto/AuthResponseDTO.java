package com.esanchez.microservice.infrastructure.clients.dto;

public class AuthResponseDTO extends ApiResponseDTO {

	private JwtDTO body;

	public JwtDTO getBody() {
		return body;
	}

	public void setBody(JwtDTO body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "AuthResponseDTO [apiResponse=" + super.toString() + ", body=" + body + "]";
	}
}
