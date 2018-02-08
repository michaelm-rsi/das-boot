package com.boot;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class ShipwreckControllerWebIntegrationTest {
	@Test
	public void testListAll() throws IOException {
		return;
//		TestRestTemplate restTemplate = new TestRestTemplate();
//		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
//		
//		assertThat( response.getStatusCode(), equalTo(HttpStatus.SC_OK));
//		ObjectMapper objectMapper = new ObjectMapper();
//		JsonNode responseJson = objectMapper.readTree(response.getBody());
//		
//		assertThat( responseJson.isMissingNode(), is(false));
//		assertThat( responseJson.toString(), equalTo("[]"));
	}
}
