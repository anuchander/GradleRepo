package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeMethod
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	@Test
	public void test1() throws IOException {
		
		ExtentTest test = extent.createTest("Google Search Test One with TestNG", "my first extent report test - with TestNG");
	    test.log(Status.INFO, "Starting test1");
		driver.get("https://www.google.com");
	    test.pass("Navigated to Google site");
	    driver.findElement(By.name("q")).sendKeys(" ");
	    test.pass("Enter text in search box");
	    driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	    test.pass("Clicked on Search button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
        driver.close();
        //test.log(Status.INFO, "Closed the browser");
        test.log(Status.INFO,"Test1 test completed");
        
	}
 
	
	@Test
	public void test2() throws IOException {
		ExtentTest test2 = extent.createTest("Google Search Test Two with TestNG", "my first extent report test - with TestNG");
		test2.log(Status.INFO, "Starting test2");
		driver.get("https://www.google.com");
	    test2.pass("Navigated to Google site");
	    driver.findElement(By.name("q")).sendKeys(" ");
	    test2.pass("Enter text in search box");
	    driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	    test2.fail("Clicked on Search button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test2.addScreenCaptureFromPath("screenshot.png");
        test2.log(Status.INFO,"Test2 test completed");
	}

	@AfterMethod
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();

	}

}
