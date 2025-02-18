package com.springstartboot.com.springstartbootJDBC.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.springstartboot.com.springstartbootJDBC.DAO.F1DAO;
import com.springstartboot.com.springstartbootJDBC.model.FormulaOne;
@Repository
public class F1DAOImplementation {
//implements F1DAO{
/*
	@Autowired
	JdbcTemplate jdbctemp;
	
	@Override
	public void create() {
		 String  cq = "CREATE TABLE FormulaOne (id INT PRIMARY KEY,teamName VARCHAR(255),driverName VARCHAR(255) )";
	        jdbctemp.execute(cq);
	        System.out.println("f1 table created successfully.");
	}

	@Override
	public int insert(FormulaOne f1) {
		
	   String insert1="insert into formulaone values(?,?,?)";
	   int rows =jdbctemp.update(insert1,f1.getId(),f1.getTeamName(),f1.getDriverName());
		
		
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int update(FormulaOne f1) {
		// TODO Auto-generated method stub
		String updateQuery = "UPDATE formulaone SET teamName = ?, driverName = ? WHERE id = ?";
        int rows = jdbctemp.update(updateQuery, f1.getTeamName(), f1.getDriverName(), f1.getId());
        System.out.println("Rows updated: " + rows);
        return rows;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		 String deleteQuery = "DELETE FROM FormulaOne WHERE id = ?";
	        int rows = jdbctemp.update(deleteQuery, id);
	        System.out.println("Rows that got deleted: " + rows);
	        return rows;
	}

	@Override
	public void find(int id) 
	{
		// TODO Auto-generated method stub
		 String findQuery = "SELECT * FROM formulaone WHERE id = ?";
	        SqlRowSet rs = jdbctemp.queryForRowSet(findQuery, id);

	        if (rs.next())
	        {
	            System.out.println("ID: " + rs.getInt("id"));
	            System.out.println("Team Name: " + rs.getString("teamName"));
	            System.out.println("Driver Name: " + rs.getString("driverName"));
	        } else
	        {
	            System.out.println("No record found with ID: " + id);
	        }
	    }

*/	
    private F1DAO dao;
    public F1DAOImplementation(F1DAO dao) {
    	this.dao=dao;
    }
    
	public void display(int id) {
		System.out.println(dao.select(id));
	}
		
	}


