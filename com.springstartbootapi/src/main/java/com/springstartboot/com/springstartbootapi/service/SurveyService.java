package com.springstartboot.com.springstartbootapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.springstartboot.com.springstartbootapi.classes.Question;
import com.springstartboot.com.springstartbootapi.classes.Survey;
import com.springstartboot.com.springstartbootapi.exceptions.QuestionNotAvailable;
import com.springstartboot.com.springstartbootapi.exceptions.QuestionNotFoundException;
import com.springstartboot.com.springstartbootapi.exceptions.SurveyNotFoundException;

public class SurveyService {
	
	private static List<Survey> surveys=new ArrayList<>();
	
	static
	{
		
		Question question1 = new Question("Question1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2",
		        "Fastest Growing Cloud Platform", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3",
		        "Most Popular DevOps Tool", Arrays.asList(
		                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
		
		List<Question> lq=new ArrayList<>(Arrays.asList(question1,question2,question3  ));
		
		Survey survey1=new Survey("Survey1","Cloud","Devops",lq);
		
		surveys.add(survey1);
		
		Question questions1 = new Question("Question1",
		        "Which is not Java Feature", Arrays.asList(
		                "Portable", "PlatformIndependent", "OOPs", "support multiple Inheritance"), "support multiple Inheritance");
		Question questions2 = new Question("Question3",
		        "Which is not SQL Features", Arrays.asList(
		                "CRUD operation", "ACID properties", "Normalization", "OOPs"), "OOPs");
		
		List<Question> lqs=new ArrayList<>(Arrays.asList(questions1,questions2));
		
		Survey survey2=new Survey("Survey2","JavaSQL","Backend",lqs);
		
		surveys.add(survey2);
		
		
		
		
		List<Question> lq3=new ArrayList<>(Arrays.asList( ));
		Survey servey3=new Survey("Survey3","Testing","Test",lq3);
		surveys.add(servey3);
		
		
		
	}
	
	public List<Survey>  retrieveAllSurveys()
	{
		return surveys;
		
	}
/*	
	public Survey retrieveSpecificSurvey(String surveyId)
	{
		Predicate<Survey> predicate=s->s.getId().equalsIgnoreCase(surveyId);
		Optional<Survey> opt= surveys.stream().filter(predicate).findFirst();
		
		if(opt.isEmpty())
			return null;
		else
			return opt.get();
		
		
	}
	
	*/
	
	public Survey retrieveSpecificSurvey(String surveyId) {
	    Optional<Survey>opt= surveys.stream()
	                  .filter(s -> s.getId().equalsIgnoreCase(surveyId))
	                  .findFirst();
	    if(opt.isEmpty()) {
	    	 throw new SurveyNotFoundException(surveyId+"---> Oops!,Given SurveyID is not available :( ");
	    }
	    else {
	    	return opt.get();
	    }
	                  
	}

	
	public List<Question> retrieveAllQuestions(String surveyId) 
	{
        List<Question> allQuestions = new ArrayList<>();
       
        for (Survey survey : surveys)
        {
        	if(survey.getId().equalsIgnoreCase(surveyId))
        	{
        		allQuestions.addAll(survey.getQuestions());
        		
        	}
        	        }                                                    
        
        if(allQuestions.isEmpty()) {
        	
        	throw new QuestionNotAvailable(surveyId+ "---> Oops!,Given SurveyID Has No Questions to Return :( ");
        }
        return allQuestions;
        		
    }
	
	public Question retrieveSpecificQuestion(String surveyId, String questionId){
		//List<Question> specQues= new ArrayList<>();
		for(Survey survey:surveys) {
			if(survey.getId().equalsIgnoreCase(surveyId)) {
				
				for(Question question: survey.getQuestions()) {
					if(question.getId().equalsIgnoreCase(questionId)){
						//specQues.add(question);
						return question;					
					}					
				}
				throw new QuestionNotFoundException(questionId+"---> Oops!,Given QuestionID is not available :( ");
			}
			
			
			
		}
		 throw new SurveyNotFoundException(surveyId+"---> Oops!,Given SurveyID is not available :( ");
		
			
	
	}
	
	public boolean postingQuestion(String surveyId, Question question) {
		
		for(Survey survey: surveys) 
		{
			if(survey.getId().equalsIgnoreCase(surveyId)) {
				survey.getQuestions().add(question);
				return true;
			}
			
		}
		return false;
		
		
		
	}
	
	public boolean deleteSpecificQuestion(String surveyId, String questionId) {
		for(Survey survey:surveys)
		{
			if(survey.getId().equalsIgnoreCase(surveyId))
			{
				for(Question question: survey.getQuestions()) 
				{
					if(question.getId().equalsIgnoreCase(questionId))
					{
						//specQues.add(question);
						survey.getQuestions().remove(question);
						return true;
						
					
					
					}
					
				}
			}
			
		}
		
		return false;
	}
	
	public boolean updateSpecificQuestion(String surveyId, String questionId, Question question ) 
	{
		
		deleteSpecificQuestion(surveyId,questionId);
		postingQuestion(surveyId, question);
		if(postingQuestion(surveyId, question))
			{
				return true;
			}

	return false;	
	}
	
	
	
	

}
