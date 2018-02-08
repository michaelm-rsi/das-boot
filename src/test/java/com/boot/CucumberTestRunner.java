package com.boot;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class CucumberTestRunner {
	@Test
	public void runCucumberTests() throws Exception {
		JUnitCore.runClasses(CucumberRunner.class);
	}
	
	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources")
	public static class CucumberRunner {	
	}
}
