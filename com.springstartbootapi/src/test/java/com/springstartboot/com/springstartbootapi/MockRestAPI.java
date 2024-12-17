package com.springstartboot.com.springstartbootapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springstartboot.com.springstartbootapi.controllers.SurveyController;
import com.springstartboot.com.springstartbootapi.service.SurveyService;

@WebMvcTest(controllers=SurveyController.class)
public class MockRestAPI {
	
	@MockitoBean
	private SurveyService service;
	
	@Autowired
	private MockMvc mock;
	
	private static String endpointspecq="http://localhost:8080/surveys/Survey1/questions/Question1";
	
	@Test
	public void testMock() throws Exception
	{
		MockHttpServletRequestBuilder reqbuild
		= MockMvcRequestBuilders.get(endpointspecq).accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult mvc=mock.perform(reqbuild).andReturn();
		System.out.println("Content type:"+mvc.getResponse().getContentAsString());
		System.out.println("Content type:"+mvc.getResponse().getStatus());
		
		
		
	}
}
