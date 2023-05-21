package com.orangehrmai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class OrangeHRMPimPage {

	@FindBy(xpath=ObjectRepository.pimButtonXpath) 
	@CacheLookup
	WebElement pimButton;
	
	@FindBy(xpath=ObjectRepository.pimHeadingXpath) 
	@CacheLookup
	WebElement pimHeading;
	
	@FindBy(xpath=ObjectRepository.addEmployeeTabXpath)
	@CacheLookup
	WebElement addEmployeeTab;

	@FindBy(xpath=ObjectRepository.addEmployeeFirstNameXpath) 
	@CacheLookup
	WebElement addEmployeeFirstName;
	
	@FindBy(xpath=ObjectRepository.addEmployeeLastNameXpath)
	@CacheLookup
	WebElement addEmployeeLastName;
	
	@FindBy(xpath=ObjectRepository.addEmployeeIdXpath)
	@CacheLookup
	WebElement addEmployeeId;
	
	@FindBy(xpath=ObjectRepository.createLoginDetailsSwitchButtonXpath)
	@CacheLookup
	WebElement addEmployeeCreateLoginDetails;
	
	@FindBy(xpath=ObjectRepository.addEmployeeUsernameXpath)
	@CacheLookup
	WebElement addEmployeeUsername;
	
	@FindBy(xpath=ObjectRepository.addEmployeePasswordXpath)
	@CacheLookup
	WebElement addEmployeePassword;
	
	@FindBy(xpath=ObjectRepository.addEmployeeConfirmPasswordXpath)
	@CacheLookup
	WebElement addEmployeeConfirmPassword;
	
	@FindBy(xpath=ObjectRepository.addEmployeeEnabledRadioButton)
	@CacheLookup
	WebElement addEmployeeEnabledRadioButton;
	
	@FindBy(xpath=ObjectRepository.addEmployeeSaveButtonXpath)
	@CacheLookup
	WebElement addEmployeeSaveButton;
	
	@FindBy(xpath=ObjectRepository.addedEmployeeProfileNameXpath)
	@CacheLookup
	WebElement addedEmployeeProfileName;
	
	
	
	
	
	public void pimTitleValidation() {
		pimButton.click();
		System.out.println("pim button clicked");
		String actualTitle = pimHeading.getText();
		String expectedTitle = "PIM";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PIM Heading is displayed");
			Reporter.log("PIM Heading is displayed");
		}else {
			System.out.println("PIM Heading is not displayed");
			Reporter.log("PIM Heading is not displayed");
		}
	}
	
	public void addEmployeeNameAndId(String firstName, String lastName, String employeeId) throws InterruptedException {
		addEmployeeTab.click();
		addEmployeeFirstName.sendKeys(firstName);
		addEmployeeLastName.sendKeys(lastName);
		addEmployeeId.click();
		addEmployeeId.clear();
		addEmployeeId.sendKeys(employeeId);
		
	}
	
	public void addEmployeeCredentials(String userName, String password) throws InterruptedException {
		addEmployeeCreateLoginDetails.click();
		addEmployeeUsername.sendKeys(userName);
		if (addEmployeeEnabledRadioButton.isSelected()) {
			System.out.println("Enabled status is already selected");
		}else {
			System.out.println("Enabled status is not selected on startup"); 
			addEmployeeEnabledRadioButton.click();
		}
		addEmployeePassword.sendKeys(password);
		addEmployeeConfirmPassword.sendKeys(password);
		addEmployeeSaveButton.click();		
		System.out.println("New Employee Added Successfully");	
		Reporter.log("New Employee Added Successfully");
	}
	
	public void addedEmployeeProfileNameValidation(String employeeName) throws InterruptedException{

		Thread.sleep(5000);
		String actualName= addedEmployeeProfileName.getText();
		String expectedName = employeeName;
		if(actualName.equals(expectedName)) {
			System.out.println("New Employee name is displayed");
			Reporter.log("New Employee name is displayed");
		}else {
			System.out.println("New Employee name is not displayed");
			Reporter.log("New Employee name is not displayed");
		}
		
	}

}
