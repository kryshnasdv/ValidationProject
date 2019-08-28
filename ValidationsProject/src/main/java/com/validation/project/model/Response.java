package com.validation.project.model;

public class Response {
	
	String status;
	
	String payload;
	
	ErrorResponse errorResponse;

	public Response() {
		
	}

	public Response(String status, String payload, ErrorResponse errorResponse) {
		super();
		this.status = status;
		this.payload = payload;
		this.errorResponse = errorResponse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
		
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", payload=" + payload + ", errorResponse=" + errorResponse + "]";
	}

	
	
	

}
