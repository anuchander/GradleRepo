package com.qa.tests;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	private static org.apache.logging.log4j.Logger demologger = LogManager.getLogger(GoogleTest.class.getName());

	@Test
	public void googleTitleTest() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Google title is: "+ title);
		demologger.error("DB connection failed");
		demologger.info("Click successful");
		demologger.debug("This is debug");
		demologger.fatal("This is fatal message!");
		Assert.assertEquals(title, "Google");
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
	}
	
	
	
	

}
