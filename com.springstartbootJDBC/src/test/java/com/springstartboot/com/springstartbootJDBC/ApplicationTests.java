package com.springstartboot.com.springstartbootJDBC;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springstartboot.com.springstartbootJDBC.DAO.F1DAO;
import com.springstartboot.com.springstartbootJDBC.model.FormulaOne;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

	@Autowired
	private F1DAO dao;
	
	
//	@Test
//	void contextLoads() {
//	}
	
//	@Test
//	public void testcreate() 
//	{
//		
//	     dao.create(); 
//	     System.out.println("f1 table created successfully.");
//	}
	
//	@Test
//    public void testinsert() {
//        FormulaOne f1 = new FormulaOne(5, "Ferrari", "Dhayaa");
//        int rows = dao.insert(f1);
//       System.out.println(rows+" row got added ");
//    }
//	
//	 @Test
//	    public void testupdate() {
//	        FormulaOne f1 = new FormulaOne(1, "Ferrari", "Lewis Hamilton"); 
//	        int rows = dao.update(f1);
//	        System.out.println("updated rows : " + rows);
//	    }
//
//	    @Test
//	    public void testdel() {
//	        int rows = dao.delete(5); 
//	        System.out.println("total no of rows deleted: " + rows);
//	    }
//
//	    @Test
//	    public void testFind() {
//	    	System.out.println();
//	        dao.find(1); 
//	        System.out.println();
//	    }

}
