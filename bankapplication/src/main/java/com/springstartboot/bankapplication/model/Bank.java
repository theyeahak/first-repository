package com.springstartboot.bankapplication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;

    private String bankName;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Account> accounts;

    // Getters and setters
    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public Bank() { }

    public Bank(String bankName) {
        this.bankName = bankName;
    }
}
