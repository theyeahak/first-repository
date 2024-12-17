package com.springstartboot.com.springstartbootJDBC.model;

public class FormulaOne {
	private int id;
	private String teamName;
	private String driverName;
	
	public FormulaOne() {
	
	}
	public FormulaOne(int id, String teamName, String driverName) {
		
		this.id = id;
		this.teamName = teamName;
		this.driverName = driverName;
	}
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTeamName() {
		return teamName;
	}




	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}




	public String getDriverName() {
		return driverName;
	}




	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}




	@Override
	public String toString() {
		return "FormulaOne [id=" + id + ", teamName=" + teamName + ", driverName=" + driverName + "]";
	}
	
	
	
	
	

}
