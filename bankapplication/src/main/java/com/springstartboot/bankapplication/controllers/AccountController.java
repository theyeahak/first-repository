package com.springstartboot.bankapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springstartboot.bankapplication.model.*;
import com.springstartboot.bankapplication.service.*;

@RestController
public class AccountController {
	@Autowired
	AccountService as;
	
	@RequestMapping("/accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<Account> getAllBank(){
		return as.getAllAccount();
	}

	
	@RequestMapping("/accountbyid/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Account getBankById(@PathVariable int id) {
		return as.getAccountById(id);
	}
	
	@RequestMapping("/addaccount")
	@ResponseStatus(HttpStatus.CREATED)
	public void addBank(@RequestBody Account acc) {
		as.addAccount(acc);
	}
	

	@RequestMapping("/accounts/updateaccount")
	@ResponseStatus(HttpStatus.OK)
	public void updateBank(@RequestBody Account acc) {
	    as.updateAccount(acc);
	}

	@RequestMapping("/accounts/deleteaccount/{Id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBank(@PathVariable int Id) {
		as.deleteAccount(Id);
	}
	
}
