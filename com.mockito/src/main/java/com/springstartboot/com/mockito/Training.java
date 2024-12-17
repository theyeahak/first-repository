package com.springstartboot.com.mockito;

public class Training {
	String trainerName;
	public Training()
	{
		
	}
	public Training(String trainerName) 
	{
		
		this.trainerName = trainerName;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	@Override
	public String toString() {
		return "Training [trainerName=" + trainerName + "]";
	};
	
	

}
