package com.springstartboot.com.springstartbootapi.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springstartboot.com.springstartbootapi.classes.Question;
import com.springstartboot.com.springstartbootapi.classes.Survey;
import com.springstartboot.com.springstartbootapi.exceptions.ErrorResponse;
import com.springstartboot.com.springstartbootapi.exceptions.QuestionNotAvailable;
import com.springstartboot.com.springstartbootapi.exceptions.QuestionNotFoundException;
import com.springstartboot.com.springstartbootapi.exceptions.SurveyNotFoundException;
import com.springstartboot.com.springstartbootapi.service.SurveyService;

@RestController
public class SurveyController {
	private SurveyService service=new SurveyService();
	
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurvey()
	{
		
		return service.retrieveAllSurveys();
	}
	
	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSpecificSurvey(@PathVariable String surveyId)
	{
		return service.retrieveSpecificSurvey(surveyId);
		
	}
	
	 @RequestMapping("/surveys/{surveyId}/question")
	    public List<Question> retrieveAllQuestions(@PathVariable String surveyId) {
		 
		 
	        return service.retrieveAllQuestions(surveyId);
	    }
	 
	 @RequestMapping("/surveys/{surveyId}/question/{questionId}")
	 public Question retrieveSpecificQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		 return service.retrieveSpecificQuestion(surveyId, questionId);
	 }
	 
	 



//	 
//	 @RequestMapping("/surveys/{surveyId}/addques")
//	 public void postingQuestion(@PathVariable String surveyId, @RequestBody Question question) {
//		 service.postingQuestion(surveyId, question);
//	    // String responseMessage = "hip hip hooray! " + surveyId;
//	     
//	 }
	 
	 
	 @RequestMapping("/surveys/{surveyId}/addques")
	 public ResponseEntity<Void> postingQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		 
		 if( service.postingQuestion(surveyId, question)) {
			 
			 return new ResponseEntity<Void>(HttpStatus.CREATED);
			 
		 }
		 else {
			 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			 
		 }
	   
	     
	 }
	 @RequestMapping("/surveys/{surveyId}/question/{questionId}/delete")
	 public ResponseEntity<Void> deleteSpecificQuestion(@PathVariable String surveyId,@PathVariable String questionId) {
		 if(service.deleteSpecificQuestion(surveyId, questionId)){
			 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			 		 }
		 else {
			 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			 
		 }
		
	 }
	 
	 @RequestMapping("/surveys/{surveyId}/question/{questionId}/update")
	 public ResponseEntity<Void> updateSpecificQuestion(@PathVariable String surveyId,@PathVariable String questionId,@RequestBody Question question){
		 service.updateSpecificQuestion(surveyId, questionId, question);
		 if(service.updateSpecificQuestion(surveyId, questionId, question))
		 {
			 return new ResponseEntity<Void>(HttpStatus.CREATED);
		 }
		 else 
		 {
			 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		 
	     }
	 
	 
	 
	 }	 
	 
	 @ExceptionHandler
	 public ResponseEntity<?> handleSurveyNotFoundException(SurveyNotFoundException se){
		 ErrorResponse er= new ErrorResponse();
		 er.setMessage(se.getMessage());
		 er.setStatus(HttpStatus.NOT_FOUND);
		 er.setTimestamp(LocalDateTime.now());
		 return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @ExceptionHandler
	 public ResponseEntity<?> handleQuestionNotFoundException(QuestionNotFoundException qe){
		 ErrorResponse er= new ErrorResponse();
		 er.setMessage(qe.getMessage());
		 er.setStatus(HttpStatus.NOT_FOUND);
		 er.setTimestamp(LocalDateTime.now());
		 return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @ExceptionHandler
	 public ResponseEntity<?> handleQuestionNotAvailableException(QuestionNotAvailable qna){
		 ErrorResponse er= new ErrorResponse();
		 er.setMessage(qna.getMessage());
		 er.setStatus(HttpStatus.NOT_FOUND);
		 er.setTimestamp(LocalDateTime.now());
		 return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
		 
	 }
	 
	 
	 

}
