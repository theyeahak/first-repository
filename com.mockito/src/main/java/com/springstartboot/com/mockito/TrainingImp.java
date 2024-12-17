package com.springstartboot.com.mockito;

public class TrainingImp {
	//implements TrainingService{
	
	private TrainingService ts;	
	public TrainingImp(TrainingService ts) {
	
		this.ts = ts;
	}




//	@Override
//	public Training retrievename() {
//		return new Training("Mercy");
//	}

	
	public String TrainerCheck() {
		
		
		Training t=ts.retrievename();
		if(t.getTrainerName().equalsIgnoreCase("Mercy"))
		{
			return "VOILA";
		}
		else {
			
			return " :( ";
		}
			
			
	
	}
	

}
