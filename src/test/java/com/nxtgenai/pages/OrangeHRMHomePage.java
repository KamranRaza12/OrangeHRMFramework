package com.nxtgenai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class OrangeHRMHomePage {

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
		System.out.println(actualTitle);
		String expectedTitle = "Dashboard";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Dashboard Heading is displayed");
			Reporter.log("Dashboard Heading is displayed");
		}else {
			System.out.println("Dashboard Heading is not displayed");
			Reporter.log("Dashboard Heading is not displayed");
		}	
	}
	
	public void logout() {
		profileTab.click();
		logoutbutton.click();
		System.out.println("User Logged Out Successfully");	
		Reporter.log("User Logged Out Successfully");
	}
	
	
}
