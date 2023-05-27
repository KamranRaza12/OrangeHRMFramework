package com.orangehrmai.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


import com.orangehrm.objectrepository.ObjectRepository;



public class OrangeHRMLoginPage {
	public WebDriver driver;
	public Actions mouseHover;

	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Initilize the webelements locators values using FINDBY class	
	@FindBy(xpath=ObjectRepository.loginPageTitleXpath) 
	@CacheLookup
	WebElement loginPageHeading;
	@FindBy(xpath=ObjectRepository.usernameXpath) 
	@CacheLookup
	WebElement usernameTextbox;

	@FindBy(xpath=ObjectRepository.passwordXpath) 
	@CacheLookup
	WebElement passwordTextbox;

	@FindBy(xpath= ObjectRepository.loginButtonXpath) 
	@CacheLookup
	WebElement loginButton;

	
	// Reusuable methods	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		Reporter.log("Browser is Maximized");
		System.out.println("Browser is Maximized");
	}

	public void closeBrowser() {		
		driver.close();
		Reporter.log("Browser is Closed");
		System.out.println("Browser is Closed");
	}

	
	public void loginPageTitleValidation() {		
		String actualTitle = loginPageHeading.getText();
		String expectedTitle = "Login";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Login Heading is displayed");
			Reporter.log("Login Heading is displayed");
		}else {
			System.out.println("Login Heading is not displayed");
			Reporter.log("Login Heading is not displayed");
		}		
	}
	public void userLogin(String username, String password) {		
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		loginButton.click();
		System.out.println("User logged in Successfully");
		Reporter.log("User logged in Successfully");
	}

	
}
