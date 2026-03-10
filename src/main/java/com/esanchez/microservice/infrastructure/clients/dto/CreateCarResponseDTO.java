package com.esanchez.microservice.infrastructure.clients.dto;

public class CreateCarResponseDTO {

	private String id, brand, model;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "CreateCarResponseDTO [id=" + id + ", brand=" + brand + ", model=" + model + "]";
	}
}
