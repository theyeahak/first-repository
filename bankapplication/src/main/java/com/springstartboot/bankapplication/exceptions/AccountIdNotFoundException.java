package com.springstartboot.bankapplication.exceptions;

public class AccountIdNotFoundException extends RuntimeException {
	public AccountIdNotFoundException(String msg) {
		super(msg);
	}

}
