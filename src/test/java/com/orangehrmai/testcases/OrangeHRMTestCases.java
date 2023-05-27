package com.orangehrmai.testcases;

import com.orangehrmai.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangehrmai.driverscript.TestBase;

import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OrangeHRMTestCases extends TestBase{
	public static FileInputStream fis;
	public static Properties config = new Properties();
	@BeforeClass
	public void readData() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\orangehrmai\\driverscript\\testData.properties");
		config.load(fis);
	}
	@Test(priority=1)
	public void adminLoginAndLogoutValidation() {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		
		loginPage.userLogin(config.getProperty("adminUsername"), config.getProperty("adminPassword"));
		homePage.homePageTitleValidation();
		homePage.logout();
		loginPage.loginPageTitleValidation();
	}
	
	@Test(priority=2)
	public void addNewEmployee() throws InterruptedException {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMPimPage pimPage = PageFactory.initElements(driver, OrangeHRMPimPage.class);

		loginPage.userLogin(config.getProperty("adminUsername"), config.getProperty("adminPassword"));
		homePage.homePageTitleValidation();
		pimPage.pimTitleValidation();
		pimPage.addEmployeeNameAndId(config.getProperty("employeeFirstName"), config.getProperty("employeeLastName"), config.getProperty("employeeId"));
		pimPage.addEmployeeCredentials(config.getProperty("employeeUsername"), config.getProperty("employeePassword"));
		pimPage.addedEmployeeProfileNameValidation(config.getProperty("employeeUsername")+" "+config.getProperty("employeeLastName"));
		homePage.logout();
	}
	
	@Test(priority=3)
	public void employeeLoginAndLogoutValidation() throws InterruptedException {
		
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMMyinfoPage myInfoPage = PageFactory.initElements(driver, OrangeHRMMyinfoPage.class);


		loginPage.userLogin(config.getProperty("employeeUsername"), config.getProperty("employeePassword"));
		myInfoPage.userLoginProfileNameValidation(config.getProperty("employeeUsername")+" "+config.getProperty("employeeLastName"));
		homePage.logout();
		loginPage.loginPageTitleValidation();
	}

	@Test(priority=4)
	public void getEmployeeDetailsReport() throws Exception {
		OrangeHRMLoginPage loginPage = PageFactory.initElements(driver, OrangeHRMLoginPage.class);
		OrangeHRMHomePage homePage = PageFactory.initElements(driver, OrangeHRMHomePage.class);
		OrangeHRMPimPage pimPage = PageFactory.initElements(driver, OrangeHRMPimPage.class);
		OrangeHRMGetEmployeeDetails getData = PageFactory.initElements(driver, OrangeHRMGetEmployeeDetails.class);

		loginPage.userLogin(config.getProperty("adminUsername"), config.getProperty("adminPassword"));
		homePage.homePageTitleValidation();
		pimPage.pimTitleValidation();
		pimPage.clickReports();
		pimPage.clickEmployeeJobDetailsReports();

		getData.getTableDetails();


		Thread.sleep(5000);


	}

}

