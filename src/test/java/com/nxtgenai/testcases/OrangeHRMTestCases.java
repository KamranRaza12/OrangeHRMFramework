package com.nxtgenai.testcases;

import org.testng.annotations.Test;

import com.nxtgenai.driverscript.TestBase;
import com.nxtgenai.pages.OrangeHRMHomePage;
import com.nxtgenai.pages.OrangeHRMLoginPage;
import com.nxtgenai.pages.OrangeHRMMyinfoPage;
import com.nxtgenai.pages.OrangeHRMPimPage;

import org.openqa.selenium.support.PageFactory;

public class OrangeHRMTestCases extends TestBase{
	
	@Test(priority=1)
	public void adminLoginAndLogoutValidation() {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		
		loginPage.userLogin("Admin", "admin123");
		homePage.homePageTitleValidation();
		homePage.logout();
		loginPage.loginPageTitleValidation();
	}
	
	@Test(priority=2)
	public void addNewEmployee() throws InterruptedException {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMPimPage pimPage = PageFactory.initElements(driver, OrangeHRMPimPage.class);

		loginPage.userLogin("Admin", "admin123");
		homePage.homePageTitleValidation();
		pimPage.pimTitleValidation();
		pimPage.addEmployeeNameAndId("Wolves", "M", "");
		pimPage.addEmployeeCredentials("Wolves", "wolves123");
		pimPage.addedEmployeeProfileNameValidation("Wolves M");
		homePage.logout();
	}
	
	@Test(priority=3)
	public void employeeLoginAndLogoutValidation() {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMMyinfoPage myInfoPage = PageFactory.initElements(driver, OrangeHRMMyinfoPage.class);
		
		loginPage.userLogin("Wolves", "wolves123");
		myInfoPage.userLoginProfileNameValidation("Wolves M");
		homePage.logout();
		loginPage.loginPageTitleValidation();
	}


	
}

