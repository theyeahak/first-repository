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

import com.springstartboot.bankapplication.model.Account;
import com.springstartboot.bankapplication.model.Bank;
import com.springstartboot.bankapplication.service.BankService;

@RestController
public class BankController {
	@Autowired
	BankService bs;
	
	@RequestMapping("/banks")
	@ResponseStatus(HttpStatus.OK)
	public List<Bank> getAllBank(){
		return bs.getAllBank();
	}

	
	@RequestMapping("/bankbyid/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Bank getBankById(@PathVariable int id) {
		return bs.getBankById(id);
	}
	
	@RequestMapping("/addbank")
	@ResponseStatus(HttpStatus.CREATED)
	public void addBank(@RequestBody Bank bank) {
		bs.addBank(bank);
	}
	

	@RequestMapping("/banks/updatebank/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateBank(@PathVariable int id,@RequestBody Bank bank) {
	    bs.updateBank(id,bank);
	}

	@RequestMapping("/banks/deletebank/{Id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBank(@PathVariable int Id) {
		bs.deleteBank(Id);
	}
	@RequestMapping("/banks/{bankId}/deleteaccount/{accountId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAccount(@PathVariable int bankId, @PathVariable int accountId) {
		bs.deleteAccount(bankId, accountId);
	}
	@RequestMapping("/banks/{bankId}/addaccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public void addAccount(@PathVariable int bankId, @RequestBody Account acc) {
		bs.addAccount(bankId, acc);
	}
	
	
}
