package com.springstartboot.com.springstartbootapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyTest {

	private static String endpointspecq = "http://localhost:2003/surveys/Survey1/question/Question2";

	private static String endpointallques = "http://localhost:2003//surveys/Survey2/question";
	private RestTemplate temp = new RestTemplate();

	String outputspecq = """
				{
			    "id": "Question2",
			    "desc": "Fastest Growing Cloud Platform",
			    "options": [
			        "AWS",
			        "Azure",
			        "Google Cloud",
			        "Oracle Cloud"
			    ],
			    "correctans": "Google Cloud"
			}""";

	String allques = """
			[
			    {
			        "id": "Question1"

			    },
			    {
			        "id": "Question3"

			    }

			]""";

	@Test
	public void testspecq() throws JSONException {
		ResponseEntity<String> resp = temp.getForEntity(endpointspecq, String.class);
		// System.out.println(resp.getBody());
		assertTrue(resp.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", resp.getHeaders().get("Content-Type").get(0));
		// System.out.println(resp.getHeaders());
		JSONAssert.assertEquals(outputspecq, resp.getBody(), true);
	}

	@Test
	public void testallques() throws JSONException {
		ResponseEntity<String> resp = temp.getForEntity(endpointallques, String.class);
		assertTrue(resp.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(allques, resp.getBody(), false);
	}
}
