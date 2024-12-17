package com.springstartboot.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springstartboot.bankapplication.model.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{

}
