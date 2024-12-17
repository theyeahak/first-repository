

package com.springstartboot.bankapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstartboot.bankapplication.model.Account;
import com.springstartboot.bankapplication.model.Bank;
import com.springstartboot.bankapplication.repository.AccountRepo;

@Service
public class AccountService {
	@Autowired
	AccountRepo accRepo;
	//C R U D
	
	//C
	public void addAccount(Account acc) {
		accRepo.save(acc);
	}
	
	//R
	public List<Account> getAllAccount(){
		return accRepo.findAll();
	}
	//R
	public Account getAccountById(int id) {
		return accRepo.findById(id).get();
	}
	
	
	//U
	public void updateAccount(Account acc) {
//		Bank myBank=bankRepo.findById(id).get();
		accRepo.save(acc);
//		Bank myBank=getBankById(id);
//		myBank.setName(bank.getName());
//		myBank.setAccounts(bank.getAccounts());
//		bankRepo.save(myBank);
		
	}
	
	//D
	
	public void deleteAccount(int id) {
		accRepo.deleteById(id);
	}
	
	

}
