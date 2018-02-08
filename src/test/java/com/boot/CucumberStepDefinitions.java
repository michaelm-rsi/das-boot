package com.boot;

import static org.junit.Assert.assertTrue;

import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CucumberStepDefinitions {
	private WebDriver driver;
	
	@Before
	public void setup() {
		JUnitCore.runClasses(SpringRunner.class);
		setupLocal();
//BrowserStack - worry with later.		
//		DesiredCapabilities capability = DesiredCapabilities.chrome();
//	    capability.setPlatform(Platform.WINDOWS);
//	    driver = new RemoteWebDriver(
//	      new URL("https://michaelmorris5:CnK3B8wAxF4xpsu54xJc@hub-cloud.browserstack.com/wd/hub"),
//	      capability
//	    );
	}
	
	public void setupLocal() {
		System.out.println("Setup Local");
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Setup Local - complete");

	}
	
	@After
	public void after() throws Exception {
		driver.quit();
	}

	@Given("^I am on \"([^\"]*)\"$")
	public void iAmOnPage(String url) {
		driver.navigate().to("http://localhost:8080/" + url );
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSee(String arg) {
		String body = driver.findElement(By.tagName("body")).getText();
		assertTrue(body.contains(arg));
	}
}
