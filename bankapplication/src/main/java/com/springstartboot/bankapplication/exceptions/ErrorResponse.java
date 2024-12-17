package com.springstartboot.bankapplication.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	LocalDateTime timestamp;
	HttpStatus status;
	String message;
	public ErrorResponse() {
		
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", status=" + status + ", message=" + message + "]";
	}
	
	

}
