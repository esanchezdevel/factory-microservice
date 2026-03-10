package com.esanchez.microservice.infrastructure.clients.dto;

public class CreateCarRequestDTO {
	
	private String brand, model;

	public CreateCarRequestDTO(Builder builder) {
		this.brand = builder.brand;
		this.model = builder.model;
	}
	
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public static class Builder {
		
		private String brand, model;
		
		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}
		
		public Builder model(String model) {
			this.model = model;
			return this;
		}
		
		public CreateCarRequestDTO build() {
			return new CreateCarRequestDTO(this);
		}
	}
}
