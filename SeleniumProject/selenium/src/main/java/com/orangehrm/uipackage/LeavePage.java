package com.orangehrm.uipackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.How;

public class LeavePage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public LeavePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}
	
	@FindBy(how = How.ID, using="menu_dashboard_index")
	WebElement dashboard;
	@FindBy(how = How.XPATH, using = "//a[@class='toggle tiptip']")
	WebElement leaveListToggle;
	@FindBy(how = How.XPATH, using = "//a[@class='toggle tiptip activated']")
	WebElement leaveListToggleActivate;
	@FindBy(how = How.XPATH, using="//a[@id='menu_leave_viewLeaveModule']")
	WebElement leaveTab;
	@FindBy(how = How.XPATH, using = "//input[@id='btnSearch']")
	WebElement searchButton;
	@FindBy(how = How.ID, using = "menu_leave_Configure")
	WebElement configureDropdown;
	@FindBy(how = How.ID, using = "menu_leave_leaveTypeList")
	WebElement leaveType;
	@FindBy(how = How.XPATH, using = "//div/h1[text()='Leave Types']")
	WebElement leaveTypeTab;
	@FindBy(how = How.ID, using = "btnAdd")
	WebElement addLeaveTypeButton;
	@FindBy(how = How.XPATH, using = "//div/h1[text()='Add Leave Type']")
	WebElement addLeaveTypeTab;
	@FindBy(how = How.ID, using = "leaveType_txtLeaveTypeName")
	WebElement leaveTypeName;
	@FindBy(how = How.ID, using = "saveButton")
	WebElement saveButton;
	@FindBy(how = How.ID, using = "menu_leave_applyLeave")
	WebElement applyButton;
	@FindBy(how = How.ID, using = "applyleave_txtLeaveType")
	WebElement leaveTypeDropdown;
	@FindBy(how = How.XPATH, using = "//div[@id='applyleave_leaveBalance']")
	WebElement leaveBalance;
	@FindBy(how = How.XPATH, using = "//div[@id='applyleave_leaveBalance']/a")
	WebElement viewDetails;
	@FindBy(how = How.XPATH, using = "//div/table/tfoot/tr/td[@id='balance_total']")
	WebElement leaveBalanceCount;
	@FindBy(how = How.XPATH, using = "//input[@id='closeButton']")
	WebElement okButton;
	@FindBy(how = How.XPATH, using="//select[@class='ui-datepicker-month']")
	WebElement monthDropdown;
	@FindBy(how = How.XPATH,using = "//select[@class='ui-datepicker-year']")
	WebElement yearDropdown;
	@FindBy(how = How.XPATH,using = "//input[@id='applyleave_txtFromDate']")
	WebElement fromDate;
	@FindBy(how = How.XPATH,using = "//input[@id='applyleave_txtToDate']")
	WebElement toDate;
	@FindBy(how = How.XPATH,using = "//select[@id='applyleave_partialDays']")
	WebElement duration;
	@FindBy(how = How.XPATH,using = "//input[@id='applyBtn']")
	WebElement applyBtn;
	@FindBy(how = How.ID,using = "menu_leave_viewLeaveList")
	WebElement leaveListTab;
	@FindBy(how = How.XPATH,using = "//input[@id='calFromDate']")
	WebElement fromDate_LeaveList;
	@FindBy(how = How.XPATH,using = "//input[@id='calToDate']")
	WebElement toDate_LeaveList;
	@FindBy(how = How.XPATH,using = "//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']")
	WebElement allCheckbox;
	@FindBy(how = How.XPATH,using = "//input[@id='leaveList_txtEmployee_empName']")
	WebElement employeeName;
	@FindBy(how = How.XPATH,using = "//input[@id='btnSearch']")
	WebElement searchBtn;
	
	public void applyLeave() {
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		dashboard.click();
		leaveTab.click();
		wait.until(ExpectedConditions.visibilityOf(leaveListToggle));
		leaveListToggle.click();
		leaveListToggleActivate.click();
		wait.until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();
		Select select = new Select(leaveTypeDropdown);
		select.selectByValue("1");
		String balance = leaveBalance.getText();
		String balanceCount = balance.substring(0, 5);
		//System.out.println(balanceCount);
		viewDetails.click();
		String count = leaveBalanceCount.getText();
		okButton.click();
		Assert.assertEquals(balanceCount, count);
		fromDate.click();
		selectDate("2021-12-30");
		toDate.click();
		selectDate("2021-12-31");
		applyBtn.click();
	}
	
	public void addLeaveType() {
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		dashboard.click();
		leaveTab.click();
		wait.until(ExpectedConditions.visibilityOf(leaveListToggle));
		leaveListToggle.click();
		leaveListToggleActivate.click();
		wait.until(ExpectedConditions.visibilityOf(configureDropdown));
		action = new Actions(driver);
		action.moveToElement(configureDropdown).perform();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", leaveType);
		wait.until(ExpectedConditions.visibilityOf(leaveTypeTab));
		addLeaveTypeButton.click();
		wait.until(ExpectedConditions.visibilityOf(addLeaveTypeTab));
		leaveTypeName.sendKeys("Sick Leave");
		saveButton.click();
	}
	
	public void displayLeaveList() {
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		dashboard.click();
		leaveTab.click();
		wait.until(ExpectedConditions.visibilityOf(leaveListToggle));
		leaveListTab.click();
		wait.until(ExpectedConditions.visibilityOf(fromDate_LeaveList));
		fromDate_LeaveList.click();
		selectDate("2021-12-15");
		toDate_LeaveList.click();
		selectDate("2021-12-31");
		allCheckbox.click();
		employeeName.sendKeys("Kajal M");
		searchBtn.click();
		List<WebElement> leaveList = driver.findElements(By.xpath("//form/div/table/tbody/tr"));
		for (WebElement leaveListRow : leaveList) {
			System.out.println(leaveListRow.getText());
		}
	}
	
	public void selectDate(String formatDate) {
		String date[] = null;
		if(formatDate.contains("-")) {
			date = formatDate.split("-");
		}	
		else if (formatDate.contains("/")) {
			date = formatDate.split("/");
		}
		else if (formatDate.contains(" ")) {
			date = formatDate.split(" ");
		}
		
		String year = date[0];
		String month = date[1];
		String day = date[2];
		
		if(month.length()==2) {
			int monthValue = Integer.parseInt(month) - 1;
			Select monthSelect = new Select(monthDropdown);
			monthSelect.selectByValue(String.valueOf(monthValue));
		}
		else if (month.length()!=2) {
			int monthValue = Integer.parseInt(month) - 1;
			new Select(monthDropdown).selectByValue(String.valueOf(monthValue));
		}
		
		new Select(yearDropdown).selectByVisibleText(year);
		
		driver.findElement(By.linkText(day)).click();
	}
	
}
