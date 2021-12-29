package com.orangehrm.uipackage;

import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME,using="txtUsername")
	WebElement username;
	@FindBy(how = How.NAME,using="txtPassword")
	WebElement password;
	@FindBy(how = How.NAME,using="Submit")
	WebElement loginButton;
	
	public void login(String userName, String pass) {
		username.sendKeys(userName);
		password.sendKeys(pass);
		loginButton.click();
	}
}
