package com.esanchez.microservice.application.utils;

public enum ResponseStatus {

	SUCCESS("success"),
	ERROR("error");
	
	private String value;
	
	private ResponseStatus(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
