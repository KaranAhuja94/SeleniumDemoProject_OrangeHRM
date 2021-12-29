package com.orangehrm.testPackage;

import org.openqa.selenium.support.PageFactory;		
import org.testng.annotations.Test;

import com.orangehrm.uipackage.DirectoryPage;
import com.orangehrm.uipackage.LeavePage;
import com.orangehrm.uipackage.LoginPage;
import com.orangehrm.uipackage.PIMPage;

public class TestCase extends Helper {
	
	@Test
	public void orangehrm() throws InterruptedException{
		
		//Login Page
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("orange", "orangepassword123");
		
		//Employee management
		PIMPage pimPage = PageFactory.initElements(driver, PIMPage.class);
		pimPage.addEmployee();
		pimPage.editEmployeeDetails();
		pimPage.searchEmployee();
		pimPage.deleteEmployeeDetails();
		
		//LeavePage
		LeavePage leavePage = PageFactory.initElements(driver, LeavePage.class);
		leavePage.applyLeave();
		leavePage.addLeaveType();
		leavePage.displayLeaveList();
		
		//Directory
		DirectoryPage directory = PageFactory.initElements(driver, DirectoryPage.class);
		directory.searchDirectory_ByName();
	}
	
}
