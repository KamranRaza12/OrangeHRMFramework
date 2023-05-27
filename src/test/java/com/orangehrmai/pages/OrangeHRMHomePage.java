package com.orangehrmai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class OrangeHRMHomePage {
	public WebDriver driver;

	public OrangeHRMHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath=ObjectRepository.homePageHeadingXpath) 
	@CacheLookup
	WebElement homePageHeading;

	@FindBy(xpath=ObjectRepository.profileTabDropDownXpath) 
	@CacheLookup
	WebElement profileTab;

	@FindBy(xpath=ObjectRepository.logoutXpath) 
	@CacheLookup
	WebElement logoutbutton;
	
	public void homePageTitleValidation() {		
		String actualTitle = homePageHeading.getText();
		String expectedTitle = "Dashboard";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Dashboard heading is displayed");
			Reporter.log("Dashboard heading is displayed");
		}else {
			System.out.println("Dashboard heading is not displayed");
			Reporter.log("Dashboard heading is not displayed");
		}	
	}
	
	public void logout() {
		profileTab.click();
		logoutbutton.click();
		System.out.println("User Logged Out Successfully");	
		Reporter.log("User Logged Out Successfully");
	}
	
	
}
