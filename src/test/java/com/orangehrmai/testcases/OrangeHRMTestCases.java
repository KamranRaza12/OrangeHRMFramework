package com.orangehrmai.testcases;

import org.testng.annotations.Test;

import com.orangehrmai.driverscript.TestBase;
import com.orangehrmai.pages.OrangeHRMHomePage;
import com.orangehrmai.pages.OrangeHRMLoginPage;
import com.orangehrmai.pages.OrangeHRMMyinfoPage;
import com.orangehrmai.pages.OrangeHRMPimPage;

import org.openqa.selenium.support.PageFactory;

public class OrangeHRMTestCases extends TestBase{

	//Parameterizing input values
	public String adminUsername ="Admin";
	public String adminPassword ="admin123";
	public String employeeFirstName ="Wolves";
	public String employeeLastName ="M";
	public String employeeId ="";
	public String employeeUsername ="Wolves";
	public String employeePassword ="wolves123";
	@Test(priority=1)
	public void adminLoginAndLogoutValidation() {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		
		loginPage.userLogin(adminUsername, adminPassword);
		homePage.homePageTitleValidation();
		homePage.logout();
		loginPage.loginPageTitleValidation();
	}
	
	@Test(priority=2)
	public void addNewEmployee() throws InterruptedException {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMPimPage pimPage = PageFactory.initElements(driver, OrangeHRMPimPage.class);

		loginPage.userLogin(adminUsername, adminPassword);
		homePage.homePageTitleValidation();
		pimPage.pimTitleValidation();
		pimPage.addEmployeeNameAndId(employeeFirstName, employeeLastName, employeeId);
		pimPage.addEmployeeCredentials(employeeUsername, employeePassword);
		pimPage.addedEmployeeProfileNameValidation(employeeFirstName+" "+employeeLastName);
		homePage.logout();
	}
	
	@Test(priority=3)
	public void employeeLoginAndLogoutValidation() {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMMyinfoPage myInfoPage = PageFactory.initElements(driver, OrangeHRMMyinfoPage.class);
		
		loginPage.userLogin(employeeUsername, employeePassword);
		myInfoPage.userLoginProfileNameValidation(employeeFirstName+" "+employeeLastName);
		homePage.logout();
		loginPage.loginPageTitleValidation();
	}


	
}

