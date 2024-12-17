package com.springstartboot.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springstartboot.bankapplication.model.Bank;
@Repository
public interface BankRepo extends JpaRepository<Bank, Integer>{

}
