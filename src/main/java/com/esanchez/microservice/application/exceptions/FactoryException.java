package com.esanchez.microservice.application.exceptions;

public class FactoryException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	
	public FactoryException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String toString() {
		return "FactoryException [errorCode=" + errorCode + ", errorMessage=" + getMessage() + "]";
	}
}
