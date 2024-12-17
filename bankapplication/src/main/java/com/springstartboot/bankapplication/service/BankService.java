package com.springstartboot.bankapplication.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstartboot.bankapplication.model.Account;
import com.springstartboot.bankapplication.model.Bank;
import com.springstartboot.bankapplication.repository.AccountRepo;
import com.springstartboot.bankapplication.repository.BankRepo;

@Service
public class BankService
{
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	AccountRepo accountRepo;
	// C R U D
	
	// C
	public void addBank(Bank bank) 
	{
	       
		bankRepo.save(bank);
	}
	
	// R
	public List<Bank> getAllBank() {
		return bankRepo.findAll();
	}
	
	// R
	public Bank getBankById(int id) {
		return bankRepo.findById(id).get();
	}
	
	// U
	public void updateBank(int id, Bank bank) {
		
	    Bank myBank = getBankById(id);
	    myBank.setBankName(bank.getBankName());
	    List<Account> updatedAccounts = bank.getAccounts();
	    for (Account account : updatedAccounts) {
	        account.setBank(myBank);
	        accountRepo.save(account);
	    }
	    
	    bankRepo.save(myBank);
	}


	
	// D
	public void deleteBank(int id) {
		bankRepo.deleteById(id);
	}
	
	public void deleteAccount(int bankid,int accountid)
	{
		    Bank myBank = getBankById(bankid);
		    for (Account account : myBank.getAccounts()) 
		    {
		        if (account.getAccountId() == accountid)
		        {
				        myBank.getAccounts().remove(account);
				        accountRepo.delete(account);
				        bankRepo.save(myBank);
		                break;
		        }
		    }
		    
	}
	public void addAccount(int bankid, Account acc)
	{
		Bank mybank = getBankById(bankid);
		acc.setBank(mybank);
	
		List<Account>accs=mybank.getAccounts();
		accs.add(acc);
		mybank.setAccounts(accs);
		accountRepo.save(acc);
		bankRepo.save(mybank);
		
	}
}

