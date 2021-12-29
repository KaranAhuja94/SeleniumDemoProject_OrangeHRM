package com.orangehrm.uipackage;
	
import java.util.List;		
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(how = How.ID, using="menu_dashboard_index")
	WebElement dashboard;
	@FindBy(how = How.XPATH, using="//a/b[text()='PIM']")
	WebElement pimTab;
	@FindBy(how = How.ID, using="menu_pim_addEmployee")
	WebElement addEmployeeButton;
	@FindBy(how = How.ID, using="firstName")
	WebElement firstName;
	@FindBy(how = How.ID, using="lastName")
	WebElement lastName;
	@FindBy(how = How.ID, using="chkLogin")
	WebElement loginCheckbox;
	@FindBy(how = How.ID, using="user_name")
	WebElement username;
	@FindBy(how = How.ID, using="user_password")
	WebElement password;
	@FindBy(how = How.ID, using="re_password")
	WebElement confirmPassword;
	@FindBy(how = How.ID, using="status")
	WebElement status;
	@FindBy(how = How.ID, using="photofile")
	WebElement fileUpload;
	@FindBy(how = How.ID, using="btnSave")
	WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Personal Details']")
	WebElement personalDetails;
	@FindBy(how = How.XPATH, using = "//p/input[@id='btnSave']")
	WebElement editButton;
	@FindBy(how = How.ID, using="personal_optGender_1")
	WebElement male;
	@FindBy(how = How.ID, using = "personal_optGender_2")
	WebElement female;
	@FindBy(how = How.ID,using = "personal_cmbMarital")
	WebElement maritalStatus;
	@FindBy(how = How.ID,using = "personal_cmbNation")
	WebElement nationality;
	@FindBy(how = How.XPATH,using = "//li/input[@id='personal_DOB']/following-sibling::img[@class='ui-datepicker-trigger']")
	WebElement dateOfBirth;
	@FindBy(how = How.XPATH,using = "//select[@class='ui-datepicker-year']")
	WebElement yearDropdown;
	@FindBy(how = How.XPATH,using = "//select[@class='ui-datepicker-month']")
	WebElement monthDropdown;
	@FindBy(how = How.XPATH, using = "//form[@id='frmEmpPersonalDetails']/fieldset/p/input[@id='btnSave']")
	WebElement saveButton1;
	@FindBy(how = How.XPATH, using = "//a[text()='Employee List']")
	WebElement employeeListButton;
	@FindBy(how = How.XPATH, using = "//input[@id='empsearch_employee_name_empName']")
	WebElement searchTextBox;
	@FindBy(how = How.ID, using = "searchBtn")
	WebElement searchButton;
	@FindBy(how = How.ID, using = "empsearch_id")
	WebElement employeeIdTextBox;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr/td/input[@id='ohrmList_chkSelectRecord_416']")
	WebElement checkbox;
	@FindBy(how = How.ID, using = "btnDelete")
	WebElement deleteButton;
	@FindBy(how = How.ID, using = "dialogDeleteBtn")
	WebElement okButton;
	
	public void addEmployee() {
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		pimTab.click();
		wait.until(ExpectedConditions.visibilityOf(addEmployeeButton));
		addEmployeeButton.click();
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.click();
		firstName.sendKeys("Karan");
		lastName.click();
		lastName.sendKeys("Ahuja");
		fileUpload.sendKeys("D:\\SeleniumProject\\image.png");
		loginCheckbox.click();
		username.sendKeys("karanahuja");
		password.sendKeys("Password@123");
		confirmPassword.sendKeys("Password@123");
		Select statusDropdown = new Select(status);
		WebElement selectedOption = statusDropdown.getFirstSelectedOption();
		System.out.println(selectedOption.getText());
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(personalDetails));
	}
	
	public void editEmployeeDetails() {
		editButton.click();
		male.click();
		List<WebElement> genders = driver.findElements(By.xpath("//ol/li/ul[@class='radio_list']/li/input"));
		for(int i=0;i<genders.size();i++) {
			if(genders.get(i).isSelected()) {
				List<WebElement> genderLabel = driver.findElements(By.xpath("//ol/li/ul[@class='radio_list']/li/label"));
				System.out.println(genderLabel.get(i).getText());
			}
				
		}
		Select maritalStatusDropdown = new Select(maritalStatus);
		maritalStatusDropdown.selectByValue("Single");
		Select nationalityDropdown = new Select(nationality);
		nationalityDropdown.selectByVisibleText("Indian");
		dateOfBirth.click();
		selectDate("1994-04-19");
		saveButton1.click();
	}
	
	public void searchEmployee(){
		employeeListButton.click();
		searchTextBox.sendKeys("Karan");
		searchButton.click();
		List<WebElement> employeeRecords = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement employeeRecord : employeeRecords) {
			System.out.println(employeeRecord.getText());
		}
	}
	
	public void deleteEmployeeDetails() {
		employeeIdTextBox.click();
		employeeIdTextBox.sendKeys("0548");
		searchButton.click();
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		checkbox.click();
		deleteButton.click();
		okButton.click();
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
