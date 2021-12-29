package com.orangehrm.testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.frameworkPackage.BrowserFactory;

public class Helper {
	
	public static WebDriver driver;
	BrowserFactory browserFactory;
	
	@BeforeSuite
	public void beforeSuite() {
		
	}
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Helper.driver = BrowserFactory.getDriver();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@AfterClass
	public void afterClass() {
	}
	
	@AfterSuite
	public void afterSuite() {
		
	}
}
