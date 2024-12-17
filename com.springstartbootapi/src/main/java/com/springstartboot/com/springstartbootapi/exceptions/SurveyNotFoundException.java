package com.springstartboot.com.springstartbootapi.exceptions;

public class SurveyNotFoundException extends RuntimeException {
	public SurveyNotFoundException(String msg){
		super(msg);
	}

}
