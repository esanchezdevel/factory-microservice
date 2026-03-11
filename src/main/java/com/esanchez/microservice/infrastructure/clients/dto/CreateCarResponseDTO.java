package com.esanchez.microservice.infrastructure.clients.dto;

public class CreateCarResponseDTO extends ApiResponseDTO {

	private CarDTO body;

	public CarDTO getBody() {
		return body;
	}

	public void setBody(CarDTO body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "CreateCarResponseDTO [apiResponse=" + super.toString() + ", body=" + body + "]";
	}
}
