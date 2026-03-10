package com.esanchez.microservice.infrastructure.clients.dto;

public class AuthResponseDTO {

	private String responseCode;
	
	private String message;
	
	private JwtDTO body;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JwtDTO getBody() {
		return body;
	}

	public void setBody(JwtDTO body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "AuthResponseDTO [responseCode=" + responseCode + ", message=" + message + ", body=" + body + "]";
	}
}
