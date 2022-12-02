package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver;
	

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		ExtentTest test = extent.createTest("Google Search Test One", "My first test with extent reports");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting test case");
		
		driver.get("http://www.google.com");
		test.pass("Navigated to Google.com");
		driver.findElement(By.name("q")).sendKeys(" ");
		test.pass("Entered text in search box");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test.pass("Closed the browser");
		test.info("Test completed");
		
		
		//Test2 for creating two tests cases for extent reports
		
		ExtentTest test2 = extent.createTest("Google Search Test Two", "My second test with extent reports");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		test2.log(Status.INFO, "Starting test case");
		
		driver.get("http://www.google.com");
		test2.pass("Navigated to Google.com");
		driver.findElement(By.name("q")).sendKeys(" ");
		test2.fail("Error in entering value in search box", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test2.pass("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test2.pass("Closed the browser");
		test2.info("Test completed");
		
	
		
	
		extent.flush();
		
		
		

	}

}
