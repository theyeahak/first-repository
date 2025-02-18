package com.springstartboot.com.springstartbootJDBC;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springstartboot.com.springstartbootJDBC.DAO.F1DAO;
import com.springstartboot.com.springstartbootJDBC.model.FormulaOne;
import com.springstartboot.com.springstartbootJDBC.repository.F1DAOImplementation;

@ExtendWith(MockitoExtension.class)
public class InjectDAO {
	@Mock
	private F1DAO dao;
	
	@InjectMocks
	private F1DAOImplementation fi;
	
	
	@Test
	public void testDAOselect()
	{
		List<FormulaOne> list= new ArrayList<>();
		FormulaOne f1= new FormulaOne(1,"mercedes","aadhi-ji");
		FormulaOne f2= new FormulaOne(2,"redbull","max");
		list.add(f1);
		list.add(f2);
		when(dao.select(1)).thenReturn(list.stream().filter(g->g.getId()==1).findFirst());
		when(dao.select(2)).thenReturn(list.stream().filter(g->g.getId()==2).findFirst());
		fi.display(1);
		fi.display(2);
		
	}

}
