package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {
	@Value("${server.address}")
	private String serverHost;
	
	@Value("${server.port}")
	private String serverPort;
	
	@Test
	public void testListAll() throws IOException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		UriComponentsBuilder url = UriComponentsBuilder.newInstance()
			.scheme("http")
			.host(serverHost)
			.port(serverPort)
			.path("/api/v1/shipwrecks");
		
		ResponseEntity<String> response = restTemplate.getForEntity(url.toUriString(), String.class);
		
		assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertThat( responseJson.isMissingNode(), is(false));
		assertThat( responseJson.toString(), equalTo("[]"));
	}
}

