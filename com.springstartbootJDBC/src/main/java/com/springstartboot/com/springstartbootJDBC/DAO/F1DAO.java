package com.springstartboot.com.springstartbootJDBC.DAO;

import java.util.Optional;

import com.springstartboot.com.springstartbootJDBC.model.FormulaOne;

public interface F1DAO {
	//public int create()
/*
	public void create();
	public int insert(FormulaOne f1);
	public int update(FormulaOne f1);
	public int delete(int id);
	public void find(int id);
*/	
	public Optional<FormulaOne> select(int id);
	}
		
	


