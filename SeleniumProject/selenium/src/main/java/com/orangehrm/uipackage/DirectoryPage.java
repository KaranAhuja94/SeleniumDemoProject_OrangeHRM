package com.orangehrm.uipackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DirectoryPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DirectoryPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}
	
	@FindBy(how = How.ID, using="menu_dashboard_index")
	WebElement dashboard;
	@FindBy(how = How.XPATH, using = "//a/b[text()='Directory']")
	WebElement directoryTab;
	@FindBy(how = How.XPATH, using = "//input[@id='searchDirectory_emp_name_empName']")
	WebElement employeeName;
	@FindBy(how = How.ID, using = "searchBtn")
	WebElement searchButton;
	@FindBy(how = How.XPATH, using = "//li[@class='next']/a[@class='tiptip']")
	WebElement nextButton;
	@FindBy(how = How.XPATH, using = "//div[@class='navigationHearder']/div/ul/li/a[contains(text(),'7')]")
	WebElement pageNumber;
	
	public void searchDirectory_ByName() {
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		dashboard.click();
		directoryTab.click();
		employeeName.sendKeys("Karan");
		searchButton.click();
		List<WebElement> searchResults = driver.findElements(By.xpath("//div/div/table/tbody/tr"));
		System.out.println("Directory:");
		for (WebElement searchResult : searchResults) {
			System.out.println(searchResult.getText());
		}
	}
	
	/*public void getDirectoryRecords() {
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		dashboard.click();
		directoryTab.click();
		List<WebElement> directoryRecords_Odd = driver.findElements(By.xpath("//div/div/table/tbody/tr[@class='odd']"));
		List<WebElement> directoryRecords_Even = driver.findElements(By.xpath("//div/div/table/tbody/tr[@class='even']"));
		for (WebElement directoryRecordOdd : directoryRecords_Odd) {
			for (WebElement directoryRecordEven : directoryRecords_Even) {
				System.out.println(directoryRecordOdd.getText());
				System.out.println(directoryRecordEven.getText());
				nextButton.click();
			}
		}
		if(pageNumber.getText().equalsIgnoreCase("7"))
			System.out.println("End of records");
	}*/
	
}
